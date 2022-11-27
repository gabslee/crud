package br.com.crud.empresa;

import br.com.crud.components.ResponseEmpresa;
import br.com.crud.components.ResponseEmpresaData;

import java.util.ArrayList;
import java.util.List;

public class EmpresaMapper {

    static ResponseEmpresaData toResponse(Empresa empresa){
        ResponseEmpresaData responseEmpresa = new ResponseEmpresaData();
        responseEmpresa.setIdEmpresa(empresa.getId().intValue());
        responseEmpresa.setEmail(empresa.getEmail());
        responseEmpresa.setNome(empresa.getNome());
        responseEmpresa.setCnpj(String.valueOf(empresa.getCnpj()));
        responseEmpresa.setTelefone(empresa.getTelefone());
        responseEmpresa.setStatus(String.valueOf(status.toStatus(empresa.getStatus().getStatus())));
        return responseEmpresa;
    }

    static List<ResponseEmpresaData> toResponse(List<Empresa> empresas){
        List<ResponseEmpresaData> responseEmpresaData = new ArrayList<>();
        empresas.forEach(empresa -> {
            responseEmpresaData.add(toResponse(empresa));
        });
        return responseEmpresaData;
    }


    static Empresa toModel(ResponseEmpresaData responseEmpresaData){
        Empresa empresa = new Empresa();
        empresa.setId(responseEmpresaData.getIdEmpresa().longValue());
        empresa.setCnpj(Long.valueOf(responseEmpresaData.getCnpj()));
        empresa.setNome(responseEmpresaData.getNome());
        empresa.setEmail(responseEmpresaData.getEmail());
        empresa.setTelefone(responseEmpresaData.getTelefone());
        return empresa;
    }

    static List<Empresa> toModel(List<ResponseEmpresaData> responseEmpresaDatas){
        List<Empresa> empresas = new ArrayList<>();
        responseEmpresaDatas.forEach(responseEmpresaData -> {
            empresas.add(toModel(responseEmpresaData));
        });
        return empresas;
    }

}
