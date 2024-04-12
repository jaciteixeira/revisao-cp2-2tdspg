package br.com.fiap.revisaocp22tdspg.repository;

import br.com.fiap.revisaocp22tdspg.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
