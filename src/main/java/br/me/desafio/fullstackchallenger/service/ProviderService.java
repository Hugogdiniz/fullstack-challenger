package br.me.desafio.fullstackchallenger.service;


import br.me.desafio.fullstackchallenger.entity.Provider;
import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository repository;


    public List<Provider> findAll() {
        return repository.findAll();
    }

    public Provider findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));
    }

    public void deleteById(String id) {
        Provider provider = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));
        repository.delete(provider);
    }


    public Provider insert(Provider provider) {
        Provider newProvider = new Provider(
                provider.getName(),
                provider.getPersonType(),
                provider.getCpf(),
                provider.getCnpj(),
                provider.getActivityDescription(),
                provider.getEndereco(),
                provider.getNomeContato(),
                provider.getEmailContato(),
                provider.getPhoneList()
        );
        if (provider.getId().isEmpty()) {
            return repository.save(newProvider);
        }
        newProvider.setId(provider.getId());
        return repository.save(newProvider);
    }

}
