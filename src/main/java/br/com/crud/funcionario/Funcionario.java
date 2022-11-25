package br.com.crud.funcionario;

import br.com.crud.empresa.Empresa;
import br.com.crud.usuario.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    Long id;

    @Enumerated(EnumType.STRING)
    status status = br.com.crud.funcionario.status.ATIVO;
    @Enumerated(EnumType.STRING)
    tipo tipo;
    String cargo;
    LocalDate data_admissao;
    LocalDate data_demissao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario id_usuario;
    @OneToOne
    @JoinColumn(name = "id_empresa")
    Empresa id_empresa;

}
