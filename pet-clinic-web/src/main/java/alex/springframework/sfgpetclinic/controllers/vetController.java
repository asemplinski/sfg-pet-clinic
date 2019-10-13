package alex.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vetController {

    @RequestMapping({"/vets", "/vets/index.html","vets/index"})
    public String listVets(){
        return "vets/index";
    }

}
