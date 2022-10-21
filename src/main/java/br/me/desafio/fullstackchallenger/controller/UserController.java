package br.me.desafio.fullstackchallenger.controller;


import br.me.desafio.fullstackchallenger.entity.User;
import br.me.desafio.fullstackchallenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    //Abrir pagina index
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    //Abrir pagina de cadastro do usuário
    @GetMapping("/usercreate")
    public ModelAndView homecreate(User user) {
        ModelAndView mav = new ModelAndView("UserCreate");
        return mav;
    }


    //Abrir pagina de login do usuário
    @GetMapping("/userlogin")
    public ModelAndView homelogin() {
        ModelAndView mav = new ModelAndView("UserLogin");
        return mav;
    }


    //login invalido
    @GetMapping("/login-error")
    public String loginerror(ModelMap model) {
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo", "Credenciais inválidas!");
        model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
        model.addAttribute("subtexto", "Caso não tenha conta, se cadastre!");
        return "UserLogin";
    }

    //Criar usuario
    @PostMapping("/usercreate")
    public String create(User user, RedirectAttributes attributes) {
        if (service.createValidation(user) != null) {
                attributes.addFlashAttribute("EmailExiste", "Email ja existente!");
            return  "redirect:/usercreate";
        } else
        service.insert(user);
        attributes.addFlashAttribute("UsuarioCadastrado", "Usuário cadastrado com sucesso!");
        return "redirect:/userlogin";
    }

}
