package ru.agip.sms_send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.agip.sms_send.domain.Message;
import ru.agip.sms_send.repos.MessageRepo;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting()
    {
        return "greeting";
    }

    @GetMapping("main")
    public String mane(Model model){
        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("main")
    public String add(@RequestParam String text, Model model){
        Message message = new Message(text);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String text, Model model){
        Iterable<Message> messages;

        if (text != null && !text.isEmpty()){
            messages = messageRepo.findByText(text);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        return "main";
    }
}
