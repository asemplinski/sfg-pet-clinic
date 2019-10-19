package alex.sfgpetclinic.controllers;

import alex.springframework.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class vetController {

    private final VetService vetService;

    public vetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/", "/index.html","/index"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
