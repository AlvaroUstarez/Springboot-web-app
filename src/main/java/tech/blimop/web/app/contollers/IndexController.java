package tech.blimop.web.app.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.blimop.web.app.models.Usuario;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title", "Hola Spring Framework con Model!");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Jon");
        usuario.setApellido("Snow");
        usuario.setEmail("Snow@mail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("title", "Perfil del usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Jon", "Snow", "jon@email.com"));
        usuarios.add(new Usuario("Sansa", "Stark", "sansa@email.com"));
        usuarios.add(new Usuario("Aria", "Stark", "arya@email.com"));

        model.addAttribute("title", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }
}
