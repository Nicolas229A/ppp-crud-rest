package br.edu.ifms.ppp_crud_rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifms.ppp_crud_rest.modelo.Solicitacao;

@Component
public class SolicitacaoMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Solicitacao toEntity(SolicitacaoCreateDTO dto) {
		Solicitacao entity = mapper.map(dto, Solicitacao.class);
		return entity;
	}
	
	public SolicitacaoResponseDTO toDTO(Solicitacao entity) {
		SolicitacaoResponseDTO dto = mapper.map(entity, SolicitacaoResponseDTO.class);
		return dto;
	}
	
	public List<SolicitacaoResponseDTO> toDTO(List<Solicitacao> solicitacoes) {
		return solicitacoes.stream()
				.map(solicitacao -> toDTO(solicitacao))
				.collect(Collectors.toList());
	}
}
