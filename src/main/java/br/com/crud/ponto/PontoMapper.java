package br.com.crud.ponto;

import br.com.crud.apis.PontoApi;
import br.com.crud.components.ResponsePontoData;
import br.com.crud.components.ResponsePontoData;
import br.com.crud.components.ResponsePontoData;
import br.com.crud.ponto.Ponto;
import br.com.crud.ponto.Ponto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PontoMapper {
    
    static ResponsePontoData toResponse(Ponto ponto){
        ResponsePontoData responsePonto = new ResponsePontoData();
        responsePonto.setIdPonto(ponto.getId().intValue());
        responsePonto.setTipo(String.valueOf(tipo.toTipo(ponto.getTipo().getTipo())));
        responsePonto.setDia(String.valueOf(ponto.getDia()));
        responsePonto.setHorario(String.valueOf(ponto.getHorario()));
        responsePonto.setObservacao(ponto.getObservacao());
        responsePonto.setIdFuncionario(Math.toIntExact(ponto.getId_funcionario().getId()));
        return responsePonto;
    }

    //método que utiliza uma lista para conversão de dados de Ponto em ResponsePonto
    static List<ResponsePontoData> toResponse(List<Ponto> pontos) {
        List<ResponsePontoData> responsePontoData = new ArrayList<>();
        pontos.forEach(ponto -> responsePontoData.add(toResponse(ponto)));
        return responsePontoData;
    }
    
    static Ponto toModel(ResponsePontoData responsePontoData){
        Ponto ponto = new Ponto();
        ponto.setId(responsePontoData.getIdPonto().longValue());
        ponto.setTipo(tipo.toTipo(Integer.parseInt(responsePontoData.getTipo())));
        ponto.setDia(LocalDate.parse(responsePontoData.getDia()));
        ponto.setHorario(LocalTime.parse(responsePontoData.getHorario()));
        ponto.setObservacao(responsePontoData.getObservacao());
        return ponto;
    }

    //método que utiliza uma lista para conversão de dados ResponsePonto em Ponto
    static List<Ponto> toModel(List<ResponsePontoData> responsePontoDatas) {
        List<Ponto> pontos = new ArrayList<>();
        responsePontoDatas.forEach(responsePontoData -> {
            pontos.add(toModel(responsePontoData));
        });
        return pontos;


    }
    
}
