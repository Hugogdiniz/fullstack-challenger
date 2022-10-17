package br.me.desafio.fullstackchallenger.controller;


import br.me.desafio.fullstackchallenger.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User(1L, "Maria Brown", "maria@gmail.com", "123456");
        User alex = new User(2L, "Alex Green", "alex@gmail.com", "654321");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
