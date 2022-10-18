package br.me.desafio.fullstackchallenger.service;

import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void createValidation(User obj) {
        User existsUserName = repository.findByName(obj.getName());

        if (existsUserName != null) {
            throw new Error("User already exists!");
        }

        User existUserEmail = repository.findByEmail(obj.getEmail());

        if (existUserEmail != null) {
            throw new Error("User already exists!");
        }
    }
}
