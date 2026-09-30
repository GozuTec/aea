package pe.com.labocer.labocer_web.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.labocer.labocer_web.model.Producto;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        // Marca la pestaña activa para el fragmento del Navbar
        model.addAttribute("activePage", "home");

        // Lista de Productos Favoritos para el Home
        List<Producto> favoritos = List.of(
            new Producto("Trento Dark", "Peccin", "Chocolate", "Marron", 
                         "img/productos/Trento-Dark.png", "PEC-TRE-DK", 
                         "Wafer crocante cubierto de chocolate oscuro."),
            new Producto("Pinaton Chupetes", "Soberana", "Caramelo Duro", "Surtido", 
                         "img/productos/Pinaton-Soberana.png", "SOB-PIN-001", 
                         "Chupetes surtidos de caramelo duro con relleno."),
            new Producto("Oka Loka Nanos", "Super", "Chicle", "Morado", 
                         "img/productos/OkaLokaNanos-Super.png", "SUP-OKA-NAN", 
                         "Caramelos masticables sabores acidos frutales."),
            new Producto("Pastillas Minty Menta", "Docile", "Pastillas", "Verde", 
                         "img/productos/Minty-Menta-Docile.png", "DOC-MIN-001", 
                         "Pastillas refrescantes sabor menta intensa.")
        );

        // Lista de Productos Nuevos para el Home
        List<Producto> nuevos = List.of(
            new Producto("Tio Cornet", "Simsek", "Chocolate", "Morado", 
                         "img/productos/Tio-Cornet-Simsek.png", "SIM-TIO-001", 
                         "Cono crocante relleno de crema de chocolate y vainilla."),
            new Producto("Marshmallows Tornado", "Crismelos", "Marsmelos", "Azul", 
                         "img/productos/Marshmallows-TornadoCeleste-Crismelos.png", "CRI-MAR-AZU", 
                         "Nubes de azucar suaves sabor vainilla y fresa."),
            new Producto("Big Bom XL", "Americandy", "Chicle", "Rosado", 
                         "img/productos/Big-Bom-XL-Americandy.png", "AME-BIG-XL", 
                         "Chupetones gigantes rellenos con goma de mascar."),
            new Producto("Zazuage Tutti Frutti", "Dori", "Caramelo Duro", "Azul", 
                         "img/productos/Zazuage-TuttiFrutti-Dori.png", "DOR-ZAZ-001", 
                         "Chicles confitados en display de alta rotacion.")
        );

        // Lista de nombres de marcas para el carrusel inferior
        List<String> marcas = List.of("docile", "peccin", "Adro", "garoto", "riclan", "soberana");

        model.addAttribute("favoritos", favoritos);
        model.addAttribute("nuevos", nuevos);
        model.addAttribute("marcas", marcas);

        return "index";
    }
}