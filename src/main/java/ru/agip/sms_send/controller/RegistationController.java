package ru.agip.sms_send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.agip.sms_send.domain.Role;
import ru.agip.sms_send.domain.User;
import ru.agip.sms_send.repos.UserRepo;

import java.util.Collections;

@Controller
public class RegistationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.addAttribute("message", "Пользователь уже существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
