package alex.sfgpetclinic.controllers;

import alex.springframework.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class ownerController {

    private final OwnerService ownerService;

    public ownerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "/owners/index";
    }

    @RequestMapping({"/find"})
    public String returnError(){
        return "notImplemented";
    }

}
