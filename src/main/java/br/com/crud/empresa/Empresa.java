package br.com.crud.empresa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity(name = "Empresa")
@Table(name = "empresas")
@EqualsAndHashCode(of = "id")
public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    Long id;
    String nome;
    Long cnpj;
    String telefone;
    String email;
    @Enumerated(EnumType.STRING)
    status status = br.com.crud.empresa.status.ATIVO;


}
