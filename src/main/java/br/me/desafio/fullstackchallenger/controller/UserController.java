package br.me.desafio.fullstackchallenger.controller;


import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService service;

//    @GetMapping
//    public ResponseEntity<List<User>> findAll(){
//        List<User> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }

//    @GetMapping("/usercreate")
//    public String home() {
//        return "UserCreate";
//    }

    @PostMapping("/usercreate")
    public void create(User user) {
        service.insert(user);
    }
}
