//Mapper é uma classe de conversão de dados
//com o objetivo de manter o contrato ativo

package br.com.crud.usuario;

import br.com.crud.components.ResponseUsuarioData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    //método que converte dado Autor em um dado ResponseAutor

    static ResponseUsuarioData toResponse(Usuario usuario) {
        ResponseUsuarioData resposeUsuario = new ResponseUsuarioData();
        resposeUsuario.setIdUsuario(usuario.getId().intValue());
        resposeUsuario.setNome(usuario.getNome());
        resposeUsuario.setEmail(usuario.getEmail());
        resposeUsuario.setCpf(String.valueOf(usuario.getCpf()));
        resposeUsuario.setNascimento(String.valueOf(usuario.getNascimento()));
        resposeUsuario.setFoto(usuario.getFoto());
        return resposeUsuario;
    }

    //método que utiliza uma lista para conversão de dados de Autor em ResponseAutor
    static List<ResponseUsuarioData> toResponse(List<Usuario> usuarios){
        List<ResponseUsuarioData> responseUsuarioData = new ArrayList<>();
        usuarios.forEach(usuario -> responseUsuarioData.add(toResponse(usuario)));
        return responseUsuarioData;
    }

    //método que converte dado responseUsuarioData em um dado Usuario no modelo pré-definido no contrato
    static Usuario toModel(ResponseUsuarioData responseUsuarioData){
        Usuario usuario = new Usuario();
        usuario.setId(Long.valueOf(responseUsuarioData.getIdUsuario()));
        usuario.setNome(responseUsuarioData.getNome());
        usuario.setEmail(responseUsuarioData.getEmail());
        usuario.setCpf(Long.valueOf(responseUsuarioData.getCpf()));
        usuario.setNascimento(LocalDate.parse(responseUsuarioData.getNascimento()));
        usuario.setFoto(responseUsuarioData.getFoto());
        return usuario;
    }

    //método que utiliza uma lista para conversão de dados ResponseAutor em Usuario
    static List<Usuario> toModel(List<ResponseUsuarioData> responseUsuarioDatas){
        List<Usuario> usuarios = new ArrayList<>();
        responseUsuarioDatas.forEach(responseUsuarioData -> {
            usuarios.add(toModel(responseUsuarioData));
        });
        return usuarios;
    }

}
