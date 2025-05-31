package br.edu.ifms.ppp_crud_rest.dto;

import java.time.LocalDate;

public class SolicitacaoResponseDTO {
	
	private Long id;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private String detalhes;
	private String status;
	private String tipo_problema;
	private String problema;
	private String cep;
	private String bairro;
	private String rua;
	private Integer numero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	public LocalDate getData_fim() {
		return data_fim;
	}
	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo_problema() {
		return tipo_problema;
	}
	public void setTipo_problema(String tipo_problema) {
		this.tipo_problema = tipo_problema;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
