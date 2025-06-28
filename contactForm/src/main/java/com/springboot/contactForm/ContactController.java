package com.springboot.contactForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

    @GetMapping("/submit")
    public String showForm() {
        return "redirect:/contact.html";
    }

    @PostMapping("/submit")
    @ResponseBody
    public String handleForm(@ModelAttribute Contact contact) {
        return "Thank you, " + contact.Name + "! Message received.";
    }
}

