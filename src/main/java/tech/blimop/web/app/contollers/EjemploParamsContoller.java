package tech.blimop.web.app.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsContoller {

    @GetMapping("/")
    public String index(){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", defaultValue = "Algún valor") String texto, Model model){
        model.addAttribute("resultado", "El texto enviado es: "+ texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, Integer numero, Model model){
        model.addAttribute("resultado",  "El saludo es: "+ saludo + " y el numero es: "+ numero);
        return "params/ver";
    }

}
