package br.com.fiap.revisaocp22tdspg.resource;

import br.com.fiap.revisaocp22tdspg.dto.request.AlunoRequest;
import br.com.fiap.revisaocp22tdspg.dto.response.AlunoResponse;
import br.com.fiap.revisaocp22tdspg.entity.Aluno;
import br.com.fiap.revisaocp22tdspg.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource implements ResourceDTO<AlunoRequest, AlunoResponse>{

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<Collection<AlunoResponse>> findAll(

            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cpf", required = false) String cpf,
            @RequestParam(name = "email", required = false) String email
    ) {
        var aluno = Aluno.builder()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Aluno> example = Example.of(aluno, matcher);

        var encontrados = service.findAll();
        var resposta = encontrados.stream().map(service :: toResponse).toList();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<AlunoResponse> findById( @PathVariable Long id) {

        var encontrado = service.findById(id);
        if (encontrado == null) return ResponseEntity.notFound().build();
        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<AlunoResponse> save( @RequestBody @Valid AlunoRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);
        var resposta = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( saved.getId() )
                .toUri();

        return ResponseEntity.created(uri).body(resposta);
    }
}
