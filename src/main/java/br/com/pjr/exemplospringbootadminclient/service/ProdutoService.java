package br.com.pjr.exemplospringbootadminclient.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pjr.exemplospringbootadminclient.entidade.Produto;
import br.com.pjr.exemplospringbootadminclient.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Transactional
	public Produto incluir(Produto produto) {

		produto.setId(null);

		produto.setDataCadastro(new Date());

		return repository.save(produto);
	}

	@Transactional
	public Produto alterar(final Produto produto, final Long id) {

		Produto produtoSalvo = pesquisarPorId(id);

		BeanUtils.copyProperties(produto, produtoSalvo, "id");

		return repository.save(produtoSalvo);

	}

	public Produto pesquisarPorId(final Long id) {

		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(0));

	}

	@Transactional
	public void excluir(final Long id) {

		repository.deleteById(id);

	}

	public List<Produto> listar() {

		return repository.findAll();

	}

}
