package br.com.fiap.revisaocp22tdspg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_2TDSPG_ALUNO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CPF", columnNames = "CPF_ALUNO"),
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "EMAIL_ALUNO")
})
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ALUNO")
    @SequenceGenerator(name = "SQ_ALUNO", sequenceName = "SQ_ALUNO", allocationSize = 1)
    @Column(name = "ID_ALUNO")
    private Long id;

    @Column(name = "NM_ALUNO")
    private String nome;

    @Column(name = "CPF_ALUNO")
    private String cpf;

    @Column(name = "EMAIL_ALUNO")
    private String email;

    @Column(name = "SENHA_ALUNO")
    private String senha;

}
