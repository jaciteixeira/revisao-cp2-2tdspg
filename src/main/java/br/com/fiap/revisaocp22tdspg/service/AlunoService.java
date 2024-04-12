package br.com.fiap.revisaocp22tdspg.service;

import br.com.fiap.revisaocp22tdspg.dto.request.AlunoRequest;
import br.com.fiap.revisaocp22tdspg.dto.response.AlunoResponse;
import br.com.fiap.revisaocp22tdspg.entity.Aluno;
import br.com.fiap.revisaocp22tdspg.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService implements ServiceDTO<Aluno, AlunoRequest, AlunoResponse> {

    @Autowired
    AlunoRepository repo;

    @Override
    public Aluno toEntity(AlunoRequest r) {
        return Aluno.builder()
                .senha(r.senha())
                .nome(r.nome())
                .email(r.email())
                .cpf(r.cpf())
                .build();

    }

    @Override
    public AlunoResponse toResponse(Aluno e) {
        return AlunoResponse.builder()
                .id(e.getId())
                .email(e.getEmail())
                .nome(e.getNome())
                .build();
    }

    @Override
    public List<Aluno> findAll() {
        return repo.findAll();
    }


    @Override
    public List<Aluno> findAll(Example<Aluno> example) {
        return repo.findAll(example);
    }

    @Override
    public Aluno findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Aluno save(Aluno e) {
        return repo.save(e);
    }
}
