package br.me.desafio.fullstackchallenger.service;

import br.me.desafio.fullstackchallenger.entity.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

        public Endereco ConsultarCep(String cepconsulta) {
            final String URI = "https://viacep.com.br/ws/" + cepconsulta + "/json/";

            RestTemplate rest = new RestTemplate();
            Endereco retorno
                    = rest.getForObject(URI, Endereco.class);
            return retorno;
        }
}

