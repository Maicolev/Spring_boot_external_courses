package web;

import domain.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.PersonService;

import java.util.List;

@Controller
public class StartController {

    @Autowired
    private PersonService personService;

    public String initial (Model model, @AuthenticationPrincipal User user) {
       List<Person> people = personService.getAllPersons();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/add")
    public String add(Person person) {
        return "modify";
    }

    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors) {
        if(errors.hasErrors()) {
            return "modify";
        }
        personService.savePerson(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Person person, Model model) {
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }

    @GetMapping("/remove")
    public String eliminar(Person person){
        personService.deletePerson(person);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Nombre de la plantilla de Thymeleaf (login.html)
    }

    @GetMapping("/errores/403")
    public String accessDenied() {
        return "errors/403"; // Nombre de la plantilla de Thymeleaf (403.html)
    }

}
