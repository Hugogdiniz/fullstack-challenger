package br.me.desafio.fullstackchallenger.service;


import br.me.desafio.fullstackchallenger.entity.Provider;
import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository repository;

    public Provider insert(Provider obj) {

        return repository.insert(obj);
    }
}
