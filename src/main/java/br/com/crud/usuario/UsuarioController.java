package br.com.crud.usuario;

import br.com.crud.apis.UsuarioApi;
import br.com.crud.components.RequestPayloadUsuario;
import br.com.crud.components.ResponseUsuario;
import br.com.crud.components.ResponseUsuarioData;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController implements UsuarioApi {

    @Autowired
    UsuarioService service;

    @GetMapping
    @Override
    public ResponseEntity<ResponseUsuario> listaUsuario() {
        List<ResponseUsuario> usuarioFromService = new ArrayList<>();
        List<Usuario> usuarios = service.findAll();
        usuarioFromService.get(0).setData(UsuarioMapper.toResponse(usuarios));
        return ResponseEntity.ok(usuarioFromService.get(0));
    }


}
