package br.me.desafio.fullstackchallenger.service;

import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User insert(User obj) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(obj.getPassword());
        obj.setPassword(encodedPassword);
        return repository.insert(obj);
    }

    public String createValidation(User obj) {

        Optional<User> existUserEmail = repository.findByEmail(obj.getEmail());
        if (existUserEmail.isPresent()) {
            return existUserEmail.get().getEmail();
        }
        return null;
    }
}
