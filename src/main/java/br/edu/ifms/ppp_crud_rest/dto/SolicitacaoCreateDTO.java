package br.edu.ifms.ppp_crud_rest.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SolicitacaoCreateDTO {
	
	@NotNull(message = "A data de início é obrigatória.")
    @FutureOrPresent(message = "A data de início não pode ser no passado.")
    private LocalDate data_inicio;

//  @NotNull(message = "A data de fim é obrigatória.")
    @Future(message = "A data de fim deve ser uma data futura.")
    private LocalDate data_fim;

    @NotBlank(message = "Os detalhes são obrigatórios.")
    @Size(max = 500, message = "Os detalhes devem ter no máximo 500 caracteres.")
    private String detalhes;

    @NotBlank(message = "O status é obrigatório.")
    @Pattern(regexp = "PENDENTE|EM_ANDAMENTO|CONCLUIDO", 
             message = "O status deve ser PENDENTE, EM_ANDAMENTO ou CONCLUIDO.")
    private String status;

    @NotBlank(message = "O tipo de problema é obrigatório.")
    private String tipo_problema;

    @NotBlank(message = "A descrição do problema é obrigatória.")
    @Size(max = 300, message = "O problema deve ter no máximo 300 caracteres.")
    private String problema;
    
    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{5}-\\d{3}|\\d{8}", message = "O CEP deve estar no formato XXXXX-XXX ou XXXXXXXX.")
    private String cep;
    
    @NotBlank(message = "O bairro é obrigatório.")
    @Size(min = 2, max = 100, message = "O bairro deve ter entre 2 e 100 caracteres.")
	private String bairro;
    
    @NotBlank(message = "A rua é obrigatória.")
    @Size(min = 2, max = 150, message = "A rua deve ter entre 2 e 150 caracteres.")
	private String rua;
	
    @Min(value = 1, message = "Se fornecido, o número deve ser maior que zero.")
	private Integer numero;

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
