package br.edu.ifms.ppp_crud_rest.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.ppp_crud_rest.dto.SolicitacaoCreateDTO;
import br.edu.ifms.ppp_crud_rest.dto.SolicitacaoMapper;
import br.edu.ifms.ppp_crud_rest.dto.SolicitacaoResponseDTO;
import br.edu.ifms.ppp_crud_rest.excecao.SolicitacaoNotFoundException;
import br.edu.ifms.ppp_crud_rest.modelo.Solicitacao;
import br.edu.ifms.ppp_crud_rest.servico.SolicitacaoServico;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoControle {
	
	
	@Autowired
	private SolicitacaoServico solicitacaoServico;
	
	@Autowired
	private SolicitacaoMapper solicitacaoMapper;
	
	@PostMapping
    public ResponseEntity<SolicitacaoResponseDTO> salvar(@RequestBody @Valid SolicitacaoCreateDTO solicitacaoCreateDTO) {
        Solicitacao solicitacao = solicitacaoMapper.toEntity(solicitacaoCreateDTO);
        
        Solicitacao solicitacaoGravada = solicitacaoServico.gravar(solicitacao);
        
        SolicitacaoResponseDTO solicitacaoResponseDTO = solicitacaoMapper.toDTO(solicitacaoGravada);   
        
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoResponseDTO);
    }

	@GetMapping
	public ResponseEntity<List<SolicitacaoResponseDTO>> buscarTodos() {
		List<Solicitacao> solicitacoes = solicitacaoServico.buscarTodos();
		
		List<SolicitacaoResponseDTO> solicitacoesResponseDTO = solicitacaoMapper.toDTO(solicitacoes);
		
		return ResponseEntity.status(HttpStatus.OK).body(solicitacoesResponseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Long id) throws SolicitacaoNotFoundException {
		Solicitacao solicitacaoGravada = solicitacaoServico.buscarSolicitacaoPorId(id);
			
		SolicitacaoResponseDTO solicitacaoResponseDTO = solicitacaoMapper.toDTO(solicitacaoGravada);
			
		return ResponseEntity.status(HttpStatus.OK).body(solicitacaoResponseDTO);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id, @RequestBody @Valid SolicitacaoCreateDTO solicitacaoCreateDTO) throws SolicitacaoNotFoundException {
		Solicitacao solicitacao = solicitacaoMapper.toEntity(solicitacaoCreateDTO);
			
		Solicitacao solicitacaoGravada = solicitacaoServico.alterarSolicitacao(id, solicitacao);
			
		SolicitacaoResponseDTO solicitacaoResponseDTO = solicitacaoMapper.toDTO(solicitacaoGravada);
			
		return ResponseEntity.status(HttpStatus.OK).body(solicitacaoResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Long id) throws SolicitacaoNotFoundException {
		solicitacaoServico.apagarSolicitacao(id);
		return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso!");
	}
	
	
}
