package br.com.validaCpf.controller;

import br.com.validaCpf.service.ValidadorCPFService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validador/")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ValidadorCpfController {

    private final ValidadorCPFService validadorCPFService;

    @GetMapping("{cpf}")
    public ResponseEntity<?> validaCPF(@PathVariable("cpf") String cpf) {
        if (validadorCPFService.verificaCPFValido(cpf)) {
            if(cpf.equalsIgnoreCase("82502851076")) {
                return ResponseEntity.ok(ResponseDto.builder()
                        .status("UNABLE_TO_VOTE")
                        .build());
            }
            return ResponseEntity.ok(ResponseDto.builder()
                    .status("ABLE_TO_VOTE")
                    .build());
        }
        return ResponseEntity.notFound().build();
    }
}
