package br.com.pjr.exemplospringbootadminclient.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pjr.exemplospringbootadminclient.entidade.Produto;
import br.com.pjr.exemplospringbootadminclient.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@RequestBody Produto produto, HttpServletResponse response) {

        final Produto produtoCadastrado = service.incluir(produto);

        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoCadastrado.getId())
                .toUri();

        response.setHeader(HttpHeaders.LOCATION, uri.toString());

        return produtoCadastrado;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto alterar(@RequestBody Produto produto,
                                                   @PathVariable(value = "id") Long id) {

        return service.alterar(produto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto excluir(@PathVariable("id") Long id) {

        service.excluir(id);

        return Produto.builder().id(id).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listar() {

        return service.listar();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto pesquisarPorId(@PathVariable("id") Long id) {

        final Produto produto = service.pesquisarPorId(id);

        return produto;

    }

}

