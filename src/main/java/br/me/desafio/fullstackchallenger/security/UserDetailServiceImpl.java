package br.me.desafio.fullstackchallenger.security;

import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if (user.isPresent()) {
            return user.get();

        }
        throw new UsernameNotFoundException("Dados invalidos!");

    }


}
