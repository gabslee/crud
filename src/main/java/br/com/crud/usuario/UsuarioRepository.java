package br.com.crud.usuario;

import br.com.crud.components.ResponseUsuario;
import br.com.crud.components.ResponseUsuarioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {



}
