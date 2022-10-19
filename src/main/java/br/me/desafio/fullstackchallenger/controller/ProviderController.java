package br.me.desafio.fullstackchallenger.controller;


import br.me.desafio.fullstackchallenger.entity.Provider;
import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProviderController {

    @Autowired
    ProviderService service;

    //Abrir pagina de cadastro do usuário
    @GetMapping("/providercreate")
    public ModelAndView homecreate(Provider provider) {
        ModelAndView mav = new ModelAndView("CadastroFornecedor");
        return mav;
    }

    //Cadastro do Fornecedor
    @PostMapping("/providercreate")
    public String create(Provider provider) {
//        ModelAndView mav = new ModelAndView("UserCreate");
//        service.createValidation(user);
        service.insert(provider);
        return "redirect:/home";
    }

}
