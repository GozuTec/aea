package pe.com.labocer.labocer_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/nosotros")
    public String nosotros(Model model) {
        model.addAttribute("activePage", "nosotros");
        return "nosotros";
    }

    @GetMapping("/distribuidores")
    public String distribuidores(Model model) {
        model.addAttribute("activePage", "distribuidores");
        return "distribuidores";
    }

    @GetMapping("/galeria")
    public String galeria(Model model) {
        model.addAttribute("activePage", "galeria");
        return "galeria";
    }

    @GetMapping("/trabaja")
    public String trabaja(Model model) {
        model.addAttribute("activePage", "trabaja");
        return "trabaja";
    }
}