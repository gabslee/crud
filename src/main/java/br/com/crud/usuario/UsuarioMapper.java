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
        resposeUsuario.setStatus(String.valueOf(status.toStatus(usuario.getStatus().getStatus())));
        return resposeUsuario;
    }

    //método que utiliza uma lista para conversão de dados de Autor em ResponseAutor
    static List<ResponseUsuarioData> toResponse(List<Usuario> usuarios){
        List<ResponseUsuarioData> responseUsuario = new ArrayList<>();
        usuarios.forEach(usuario -> responseUsuario.add(toResponse(usuario)));
        return responseUsuario;
    }

    //método que converte dado responseUsuarioData em um dado Usuario no modelo pré-definido no contrato
    static Usuario toModel(ResponseUsuarioData responseUsuario){
        Usuario usuario = new Usuario();
        usuario.setId(Long.valueOf(responseUsuario.getIdUsuario()));
        usuario.setNome(responseUsuario.getNome());
        usuario.setEmail(responseUsuario.getEmail());
        usuario.setCpf(responseUsuario.getCpf());
        usuario.setNascimento(LocalDate.parse(responseUsuario.getNascimento()));
        usuario.setFoto(responseUsuario.getFoto());
        usuario.setStatus(status.toStatus(Integer.parseInt(responseUsuario.getStatus())));

        return usuario;
    }

    //método que utiliza uma lista para conversão de dados ResponseAutor em Usuario
    static List<Usuario> toModel(List<ResponseUsuarioData> responseUsuarios){
        List<Usuario> usuarios = new ArrayList<>();
        responseUsuarios.forEach(responseUsuario -> {
            usuarios.add(toModel(responseUsuario));
        });
        return usuarios;
    }

}