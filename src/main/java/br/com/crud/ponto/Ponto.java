package br.com.crud.ponto;

import br.com.crud.funcionario.Funcionario;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity(name = "Ponto")
@Table(name = "pontos")
@EqualsAndHashCode(of = "id")
public class Ponto {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    tipo tipo;
    LocalDate dia;
    LocalTime horario;
    String observacao;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    Funcionario id_funcionario;
}
