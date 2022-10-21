package br.me.desafio.fullstackchallenger.controller;


import br.me.desafio.fullstackchallenger.entity.PhoneNumber;
import br.me.desafio.fullstackchallenger.entity.Provider;
import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProviderController {

    @Autowired
    ProviderService service;


    //Abrir pagina de cadastro do usuário
    @GetMapping("/providercreate")
    public ModelAndView homecreate(Provider provider) {
        provider.getPhoneList().add(new PhoneNumber());
        ModelAndView mav = new ModelAndView("CadastroFornecedor");
        return mav;
    }

    //abrir home após login
    @GetMapping("/home")
    public ModelAndView mostrarListaDeFornecedores() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("providers", service.findAll());
        return mv;
    }

    // deletar fornecedor
    @GetMapping("/home/deletar/{id}")
    public String deletarFornecedor(@PathVariable("id") String id, Model model) {
        service.deleteById(id);
        return "redirect:/home";
    }

    // editar fornecedor
    @GetMapping("/home/editar/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("CadastroFornecedor");
        Provider provider = service.findById(id);
        mav.addObject("provider", provider);
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

    // adicionar linha de telefone no cadastro do fornecedor
    @RequestMapping(value="/providercreate", params={"addRow"})
    public String addRow(final Provider provider, final BindingResult bindingResult) {
        provider.getPhoneList().add(new PhoneNumber());
        return "CadastroFornecedor";
    }


    // remover linha de telefone no cadastro do fornecedor
    @RequestMapping(value="/providercreate", params={"removeRow"})
    public String removeRow(
            final Provider provider, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final Integer Id = Integer.valueOf(req.getParameter("removeRow"));
        provider.getPhoneList().remove(Id.intValue());
        return "CadastroFornecedor";
    }

}
