package br.me.desafio.fullstackchallenger.controller;

import br.me.desafio.fullstackchallenger.entity.Endereco;
import br.me.desafio.fullstackchallenger.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/buscarcep")
public class CepController {

    @Autowired
    CepService service;

    @RequestMapping("/{cepconsulta}")
    public Endereco buscarCep(@PathVariable String cepconsulta) {

        return service.ConsultarCep(cepconsulta);
    }

}
