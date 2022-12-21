package br.com.validaCpf.service;

import br.com.validaCpf.service.validador.ValidaCPF;
import org.springframework.stereotype.Service;

@Service
public class ValidadorCPFServiceImpl implements ValidadorCPFService {

    @Override
    public Boolean verificaCPFValido(String cpf) {
        return ValidaCPF.isCPF(cpf);
    }

}
