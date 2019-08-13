package com.br.desafio.tokyo2020;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.br.desafio.tokyo2020.models.Competicao;

public class CompeticaoValidator implements Validator {
	
	private CompeticaoRepository competicaoRepository;
	private final int MAX_COMPETITION = 4; // number of maximum competition in same place
	private final List<String> NAME_ETAPA = Arrays.asList("Eliminatórias", "Oitavas de Final", "Quartas de Final", "Semifinal", "Final");
	private final List<String> VALUE_ETAPA = Arrays.asList(NAME_ETAPA.get(3), NAME_ETAPA.get(4));
	
	public CompeticaoValidator(CompeticaoRepository competicaoRepository) {
		this.competicaoRepository = competicaoRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Competicao.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Competicao competicao = (Competicao) obj;
		
		// validates modalidade input
		if (checkInputString(competicao.getModalidade())) {
			errors.rejectValue("modalidade", "modalidade.empty");
		}
		
		// validates local input
		if (checkInputString(competicao.getLocal())) {
			errors.rejectValue("local", "local.empty");
		}
		
		// validates pais1 input
		if (checkInputString(competicao.getPais1())) {
			errors.rejectValue("pais1", "pais1.empty");
		}
		
		// validates pais2 input
		if (checkInputString(competicao.getPais2())) {
			errors.rejectValue("pais2", "pais2.empty");
		}
		
		// validates pais1 and pais2 input
		if (competicao.getPais1().equals(competicao.getPais2())) {
			errors.rejectValue("pais1", "Os dois paises não podem ser o mesmo.");
		}
		
		// validates etapa input
		if (checkInputString(competicao.getEtapa())) {
			errors.rejectValue("etapa", "etapa.empty");
		} else if (!NAME_ETAPA.contains(competicao.getEtapa())) {
			errors.rejectValue("etapa", "O parametro etapa deve ser: " + String.join(",", NAME_ETAPA));
		}
		
		// validates value1 and value2
		/*
		 * O fluxo de cadastro deve permitir que se forneça o mesmo valor, para os 2 países envolvidos na disputa, apenas se a etapa 
		 * for Final ou Semifinal. Para as demais etapas, não se deve permitir que se forneça o mesmo valor.
		 */
		if (!VALUE_ETAPA.contains(competicao.getEtapa()) && competicao.getValor1() == competicao.getValor2()) {
			errors.rejectValue("valor1", "Somente é permitido os valores serem iguais nas etapas " + String.join(" e ", VALUE_ETAPA));
		}
		
		if (checkMinCompetitionDuration(competicao.getDatahoraInicio(), competicao.getDatahoraFim())) {
			errors.rejectValue("datahoraInicio", "a competição deve ter a duração de no minimo 30 minutos.");
		}
		
		if (checkTimeCompetition(competicao.getDatahoraInicio(), competicao.getDatahoraFim(),
				competicao.getLocal(), competicao.getModalidade())) {
				errors.rejectValue("datahoraInicio", "Já existe uma competição cadastrada no mesmo local/modalidade/horário");	
		}
		
		if (checkMaxCompetitionInDay(competicao.getDatahoraInicio(), competicao.getDatahoraFim(), competicao.getLocal())) {
			errors.rejectValue("local", "O número máximo de competições no mesmo local/dia chegou ao máximo.");
		}

	}
	
	private boolean checkTimeCompetition(Date begin, Date end, String local, String modalidade) {
		/*
		 Duas competições não podem ocorrer no mesmo período, no mesmo local, para a
		mesma modalidade. Ex: Se eu tenho uma partida de futebol que com início às 18:00 e término 
		às 20:00 no Estádio 1, eu não poderia ter outra partida de futebol se iniciando às 19:30 nesse mesmo estádio
		 */
		List<Competicao> findCompt = competicaoRepository.findByLocalAndModalidade(local, modalidade);
		long dt1 = begin.getTime();
		long dt2 = end.getTime();
		
		for (Competicao c : findCompt) {
			long dtt1 = c.getDatahoraInicio().getTime();
			long dtt2 = c.getDatahoraFim().getTime();
			if ((dt1 >= dtt1 && dt1 <= dtt2) || (dt2 >= dtt1 && dt2 <= dtt2)) { // date in range
				return true;
			}		
		}
		return false;
	}
	
	private boolean checkMinCompetitionDuration(Date begin, Date end) {
		// A competição deve ter a duração de no mínimo 30 minutos
		long diffDates = end.getTime() - begin.getTime();
		if (diffDates < (1000 * 60 * 30)) return true;
		return false;
	}
	
	private boolean checkMaxCompetitionInDay(Date dt1, Date dt2, String local) {
		/* 
		  Para evitar problemas, a organização das olimpíadas que limitar a no máximo 4
			competições por dia num mesmo local
		*/
		Date inicio = getCraftDate(dt1, 0, 0, 0, 0);
		Date fim = getCraftDate(dt2, 23, 59, 59, 0);
		
		long test = competicaoRepository.getCompetitionLocalDay(local, inicio, fim);
		if (test >= MAX_COMPETITION) return true;
		return false;
	}
	
	private Date getCraftDate(Date date, int hour, int minute, int second, int millisecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		return cal.getTime();
	}
	
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
	
}
