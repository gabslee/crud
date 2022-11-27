package br.com.crud.usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "Usuario")
@Table(name = "usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    Long id;
    String nome;
    String email;
    String senha;
    @Column(name = "cpf")
    String cpf;
    LocalDate nascimento;
    String foto;
    @Enumerated(EnumType.STRING)
    status status = br.com.crud.usuario.status.ATIVO;

}
