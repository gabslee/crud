package br.com.crud.ponto;

import br.com.crud.apis.PontoApi;
import br.com.crud.components.RequestPayloadPonto;
import br.com.crud.components.ResponsePonto;
import br.com.crud.ponto.Ponto;
import br.com.crud.ponto.PontoMapper;
import br.com.crud.ponto.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("ponto")
public class PontoController implements PontoApi {

    @Autowired
    PontoService service;

    @Override
    @GetMapping
    public ResponseEntity<ResponsePonto> listaPonto() {
        ResponsePonto response = new ResponsePonto();
        List<Ponto> pontos = service.findAll();
        response.setData(PontoMapper.toResponse(pontos));
        return  ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponsePonto> listaPontoId(@PathVariable("id") Integer id) {
        ResponsePonto response = new ResponsePonto();
        Ponto ponto = service.findById(id.longValue());
        response.setData(Collections.singletonList(PontoMapper.toResponse(ponto)));
        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePonto> deletePonto(@PathVariable("id") Integer id) {
        ResponsePonto response = new ResponsePonto();
        Ponto ponto = service.findById(id.longValue());
        ponto = service.delete(ponto.id);
        response.setData(Collections.singletonList(PontoMapper.toResponse(ponto)));
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<ResponsePonto> cadastroPonto(@RequestBody RequestPayloadPonto requestPayloadPonto) {
        ResponsePonto response = new ResponsePonto();
        Ponto ponto = service.fromRequest(requestPayloadPonto);
        ponto = service.create(ponto);
        response.setData(Collections.singletonList(PontoMapper.toResponse(ponto)));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ResponsePonto> alteraPonto(@PathVariable("id") Integer id,@RequestBody RequestPayloadPonto requestPayloadPonto) {
        ResponsePonto response = new ResponsePonto();
        Ponto ponto = service.fromRequest(requestPayloadPonto);
        ponto = service.update(ponto, ponto.id);
        response.setData(Collections.singletonList(PontoMapper.toResponse(ponto)));
        return ResponseEntity.ok(response);
    }
}
