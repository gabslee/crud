package br.com.crud.ponto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends JpaRepository<Ponto,Long> {
}
