package br.edu.ifms.ppp_crud_rest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.ppp_crud_rest.modelo.Solicitacao;

public interface SolicitacaoRepositorio extends JpaRepository<Solicitacao, Long> {

}
