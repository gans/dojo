package com.br.desafio.tokyo2020.models;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Competicao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String modalidade;
	
	@Column(nullable = false)
	private String local;
	
	@Column(nullable = false)
	private String pais1;
	
	@Column(nullable = false)
	private int valor1;
	
	@Column(nullable = false)
	private String pais2;
	
	@Column(nullable = false)
	private int valor2;
	
	@Column(nullable = false)
	private String etapa;
	
	@Column(nullable = false)
	private Date datahoraInicio;
	
	@Column(nullable = false)
	private Date datahoraFim;
	
	
	
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public Date getDatahoraInicio() {
		return datahoraInicio;
	}

	public void setDatahoraInicio(Date datahoraInicio) {
		this.datahoraInicio = datahoraInicio;
	}

	public Date getDatahoraFim() {
		return datahoraFim;
	}

	public void setDatahoraFim(Date datahoraFim) {
		this.datahoraFim = datahoraFim;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPais1() {
		return pais1;
	}

	public void setPais1(String pais1) {
		this.pais1 = pais1;
	}

	public String getPais2() {
		return pais2;
	}

	public void setPais2(String pais2) {
		this.pais2 = pais2;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
}
