package pe.com.labocer.labocer_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.labocer.labocer_web.model.Contacto;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("activePage", "contacto");
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarContacto(Contacto contacto, Model model) {
        model.addAttribute("activePage", "contacto");
        model.addAttribute("mensaje", "Recibido");
        return "contacto";
    }
}