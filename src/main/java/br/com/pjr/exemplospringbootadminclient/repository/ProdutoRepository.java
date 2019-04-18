package br.com.pjr.exemplospringbootadminclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pjr.exemplospringbootadminclient.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
