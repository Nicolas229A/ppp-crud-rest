package br.edu.ifms.ppp_crud_rest.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ppp_crud_rest.excecao.SolicitacaoNotFoundException;
import br.edu.ifms.ppp_crud_rest.modelo.Solicitacao;
import br.edu.ifms.ppp_crud_rest.repositorio.SolicitacaoRepositorio;

@Service
public class SolicitacaoServico {
	@Autowired
	private SolicitacaoRepositorio solicitacaoRepositorio;
	
	public Solicitacao gravar(Solicitacao solicitacao) {
		return solicitacaoRepositorio.save(solicitacao);
	}
	
	public List<Solicitacao> buscarTodos() {
		return solicitacaoRepositorio.findAll();
	}
	
	public Solicitacao buscarSolicitacaoPorId(Long id) throws SolicitacaoNotFoundException {
		Optional<Solicitacao> opt = solicitacaoRepositorio.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new SolicitacaoNotFoundException("Solicitação com id: " + id + " não existe");
		}
	}
	
	public Solicitacao alterarSolicitacao(Long id, Solicitacao solicitacao) throws SolicitacaoNotFoundException {
		Solicitacao solicitacaoGravada = buscarSolicitacaoPorId(id);
		
		solicitacaoGravada.setData_fim(solicitacao.getData_fim());
		solicitacaoGravada.setStatus(solicitacao.getStatus());
		
		return solicitacaoRepositorio.save(solicitacaoGravada);
	}
	
	public void apagarSolicitacao(Long id) throws SolicitacaoNotFoundException {
		Solicitacao solicitacao = buscarSolicitacaoPorId(id);
		solicitacaoRepositorio.delete(solicitacao);
	}
}
