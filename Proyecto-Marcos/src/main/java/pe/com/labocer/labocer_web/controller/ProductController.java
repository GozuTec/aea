package pe.com.labocer.labocer_web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.com.labocer.labocer_web.model.Producto;

@Controller
public class ProductController {

    @GetMapping("/productos")
    public String productos(Model model) {

        List<Producto> productos = List.of(

            new Producto(
                "Bien Chocolate", "Simsek", "Chocolate", "Marrón",
                "img/productos/Bien-Chocolate-Simsek.png",
                "SIM-BIEN-CH",
                "Galleta Bien con sabor chocolate de la línea Simsek."
            ),

            new Producto(
                "Bien Vainilla", "Simsek", "Confite", "Amarillo",
                "img/productos/Bien-Vainilla-Simsek.png",
                "SIM-BIEN-VA",
                "Galleta Bien con sabor vainilla de la línea Simsek."
            ),

            new Producto(
                "Big Bom XL", "Americandy", "Chicle", "Rosado",
                "img/productos/Big-Bom-XL-Americandy.png",
                "AME-BIG-XL",
                "Big Bom XL de Americandy, presentado en formato para mayoristas."
            ),

            new Producto(
                "Buzzy Tribal Tutti Frutti", "Riclan", "Chicle", "Surtido",
                "img/productos/Buzzy-Tribal-TuttiFrutti-Riclan.png",
                "RIC-BUZ-TRI",
                "Buzzy Tribal con sabor tutti frutti de Riclan."
            ),

            new Producto(
                "Cestbon Chocolate", "Simsek", "Chocolate", "Marrón",
                "img/productos/Cestbon-Chocolate-Simsek.png",
                "SIM-CES-CH",
                "Cestbon con cobertura y sabor chocolate de Simsek."
            ),

            new Producto(
                "Chocale", "Crismelos", "Chocolate", "Rojo",
                "img/productos/Chocale-Crismelos.png",
                "CRI-CHO-001",
                "Chocale de la línea Crismelos."
            ),

            new Producto(
                "Cosku", "Simsek", "Chocolate", "Marrón",
                "img/productos/Cosku-Simsek.png",
                "SIM-COS-001",
                "Galleta Cosku con chocolate de Simsek."
            ),

            new Producto(
                "Icetop", "Simsek", "Chocolate", "Azul",
                "img/productos/Icetop-Simsek.png",
                "SIM-ICE-001",
                "Icetop de Simsek, presentación en caja."
            ),

            new Producto(
                "Invite Choco Cake", "Simsek", "Chocolate", "Blanco",
                "img/productos/Invite-Choco-Cake-Simsek.png",
                "SIM-INV-CC",
                "Invite Choco Cake de Simsek."
            ),

            new Producto(
                "Invite Chocolate", "Simsek", "Chocolate", "Marrón",
                "img/productos/Invite-Chocolate-Simsek.png",
                "SIM-INV-CH",
                "Invite con chocolate de Simsek."
            ),

            new Producto(
                "Invite Donut Cake Chocolate", "Simsek", "Chocolate", "Marrón",
                "img/productos/Invite-Donut-Cake-Simsek.png",
                "SIM-INV-DC",
                "Invite Donut Cake Chocolate de Simsek."
            ),

            new Producto(
                "Invite Donut Cake Fresa", "Simsek", "Caramelos Blandos", "Rosado",
                "img/productos/Invite-Donut-Fresa-Simsek.png",
                "SIM-INV-DF",
                "Invite Donut Cake con sabor fresa de Simsek."
            ),

            new Producto(
                "Invite Croissant de Cereza", "Simsek", "Chocolate", "Blanco",
                "img/productos/InviteCroissant-Cherry-Simsek.png",
                "SIM-INV-CR",
                "Invite Croissant con sabor cereza de Simsek."
            ),

            new Producto(
                "Invite Croissant de Chocolate", "Simsek", "Chocolate", "Marrón",
                "img/productos/InviteCroissant-Chocolate-Simsek.png",
                "SIM-INV-CCH",
                "Invite Croissant con chocolate de Simsek."
            ),

            new Producto(
                "Kikirik Snack", "Simsek", "Caramelos Blandos", "Rojo",
                "img/productos/Kikirik-Simsek.png",
                "SIM-KIK-001",
                "Kikirik Snack de Simsek."
            ),

            new Producto(
                "Marshmallows Cuadrado Rosado", "Crismelos", "Marsmelos", "Rosado",
                "img/productos/Marshmallows-CuadradoRosado-Crismelos.png",
                "CRI-MAR-ROS",
                "Marsmelos Cuadrado Rosado de Crismelos."
            ),

            new Producto(
                "Marshmallows Tornado Celeste", "Crismelos", "Marsmelos", "Azul",
                "img/productos/Marshmallows-TornadoCeleste-Crismelos.png",
                "CRI-MAR-AZU",
                "Marsmelos Tornado Celeste de Crismelos."
            ),

            new Producto(
                "Minty Menta", "Docile", "Pastillas", "Verde",
                "img/productos/Minty-Menta-Docile.png",
                "DOC-MIN-001",
                "Minty de Docile con sabor menta."
            ),

            new Producto(
                "Next Limón", "Super", "Caramelo Duro", "Amarillo",
                "img/productos/Next-Limon-Super.png",
                "SUP-NEX-LI",
                "Next sabor limón de Super."
            ),

            new Producto(
                "Next Menta", "Super", "Caramelo Duro", "Verde",
                "img/productos/Next-Menta-Super.png",
                "SUP-NEX-ME",
                "Next sabor menta de Super."
            ),

            new Producto(
                "Oka Loka Nanos", "Super", "Chicle", "Morado",
                "img/productos/OkaLokaNanos-Super.png",
                "SUP-OKA-NAN",
                "Oka Loka Nanos de Super."
            ),

            new Producto(
                "Pastilla Minty Menta", "Docile", "Pastillas", "Verde",
                "img/productos/Pastilla-Minty-Menta-Docile.png",
                "DOC-PAS-MIN",
                "Pastillas Minty de Docile con sabor a menta."
            ),

            new Producto(
                "Piñatón", "Soberana", "Caramelo Duro", "Surtido",
                "img/productos/Pinaton-Soberana.png",
                "SOB-PIN-001",
                "Piñatón de Soberana, producto surtido para el canal mayorista."
            ),

            new Producto(
                "Tio Cornet Chocolate & Vainilla", "Simsek", "Chocolate", "Morado",
                "img/productos/Tio-Cornet-Simsek.png",
                "SIM-TIO-001",
                "Tio Cornet sabor chocolate y vainilla de Simsek."
            ),

            new Producto(
                "Toffee", "Soberana", "Toffee", "Marrón",
                "img/productos/Toffe-Soberana.png",
                "SOB-TOF-001",
                "Toffee de Soberana."
            ),

            new Producto(
                "Trento Dark", "Peccin", "Chocolate", "Marrón",
                "img/productos/Trento-Dark.png",
                "PEC-TRE-DK",
                "Trento Dark, wafer cubierto de chocolate oscuro de Peccin."
            ),

            new Producto(
                "Zazuage Tutti Frutti", "Dori", "Caramelo Duro", "Azul",
                "img/productos/Zazuage-TuttiFrutti-Dori.png",
                "DOR-ZAZ-001",
                "Zazuage sabor tutti frutti de Dori."
            )
        );

        model.addAttribute("productos", productos);
        model.addAttribute("activePage", "productos");

        return "productos";
    }
}