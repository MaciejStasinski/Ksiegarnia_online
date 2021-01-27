package com.example.ksiegarnia.Ksiazka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
public class URLController {
    private KsiazkaRepository ksiazkaRepository;

    @Autowired
    public  URLController(KsiazkaRepository itemRepository) {
        this.ksiazkaRepository = itemRepository;
    }


    @GetMapping("/ksiazka/{id}")
    public String getKsiazka(@PathVariable Long id, Model model) {
        Optional<Ksiazka> ksiazka = ksiazkaRepository.findById(id);
        ksiazka.ifPresent(it -> model.addAttribute("ksiazka", it));
        return ksiazka.map(it -> "ksiazka").orElse("redirect:/");

    }

}
