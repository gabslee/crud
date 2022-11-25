package br.com.crud.usuario;

import br.com.crud.components.ResponseUsuario;
import br.com.crud.components.ResponseUsuarioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

//    public List<ResponseUsuario> findAll(){
//        return repository.findAll();
//    }




    public void delete(Long id){
        repository.deleteById(id);
    }
}
