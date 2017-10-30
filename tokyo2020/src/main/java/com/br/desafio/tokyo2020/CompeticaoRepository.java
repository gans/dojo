package com.br.desafio.tokyo2020;

import java.util.Date;
import java.util.List;
import com.br.desafio.tokyo2020.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "competicao", path = "competicao")
public interface CompeticaoRepository extends PagingAndSortingRepository<Competicao, Long> {

	/*
	O endpoint de consulta de competições cadastradas, deve retornar os resultados ordenados por 
	Data/Hora de início da competição e deve permitir filtrar todas competições para uma dada modalidade. 
	Esse filtro não é obrigátorio - se não for fornecido todas competições devem ser retornadas
	 */
	@Query("select c from Competicao c " +
	         "where (c.modalidade = ?1 or ?1 is null) order by c.datahoraInicio ASC")
	List<Competicao> listCompeticoes(@Param("modalidade") String modalidade);
	
	List<Competicao> findAll();
	List<Competicao> findByLocalAndModalidade(String local, String modalidade);
	
	@Query("select count(c) from Competicao c " +
		         "where c.local = ?1 and (c.datahoraInicio >= ?2 and c.datahoraFim <= ?3)")
	long getCompetitionLocalDay(String modalidade, Date d1, Date d2);
}