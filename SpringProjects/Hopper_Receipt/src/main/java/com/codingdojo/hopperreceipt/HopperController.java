package com.codingdojo.hopperreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HopperController {
    @RequestMapping("/")
    public String index(Model model) {

        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";

        // Your code here! Add values to the view model to be rendered

        model.addAttribute("x", name);
        model.addAttribute("y", itemName);
        model.addAttribute("z", price);
        model.addAttribute("k", description);
        model.addAttribute("j", vendor);

        return "index.jsp";
    }
}
