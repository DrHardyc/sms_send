package ru.agip.sms_send;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreetingController {
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required = false, defaultValue = "Hello World") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String mane(Model model){
        model.addAttribute("some", "Hello, Hardy!");
        return "main";
    }
}
