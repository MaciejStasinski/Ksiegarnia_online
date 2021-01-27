package com.example.ksiegarnia.Zamowienie;


import com.example.ksiegarnia.Ksiazka.Ksiazka;
import com.example.ksiegarnia.Ksiazka.KsiazkaRepository;
import com.example.ksiegarnia.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;

@Controller
public class ZamowienieController {

    private KlientZamowienie klientZamowienie;
    private KsiazkaRepository ksiazkaRepository;
    private ZamowienieRepository zamowienieRepository;

    @Autowired
    public ZamowienieController(KlientZamowienie klientZamowienie, KsiazkaRepository ksiazkaRepository, ZamowienieRepository zamowienieRepository) {
        this.klientZamowienie = klientZamowienie;
        this.ksiazkaRepository = ksiazkaRepository;
        this.zamowienieRepository = zamowienieRepository;
    }
    @GetMapping("/zamowienie/dodaj")
    public String addKsiazkaToZamowienie(@RequestParam Long ksiazkaId, Model model) {
        Optional<Ksiazka> ksiazka = ksiazkaRepository.findById(ksiazkaId);
        ksiazka.ifPresent(klientZamowienie::add);
        if(ksiazka.isPresent()) {
            model.addAttribute("message", new Message("Dodano", "Do zamówienia dodano: " + ksiazka.get().getTytul()));
        } else {
            model.addAttribute("message", new Message("Nie dodano", "Porano błędne id z menu: " + ksiazkaId));
        }
        return "message";
    }



    @GetMapping("/zamowienie")
    public String getCurrentOrder(Model model) {
        model.addAttribute("zamowienie", klientZamowienie.getOrder());
        model.addAttribute("sum", klientZamowienie
                .getOrder()
                .getKsiazka().stream()
                .mapToDouble(Ksiazka::getCena)
                .sum());
        return "zamowienie";
    }

    @PostMapping("/zamowienie/realizuj")
    public String proceedOrder(@RequestParam String address, @RequestParam String telefon, Model model) {
        Zamowienie zamowienie = klientZamowienie.getOrder();
        zamowienie.setAddress(address);
        zamowienie.setTelefon(telefon);
        zamowienieRepository.save(zamowienie);
        klientZamowienie.clear();
        model.addAttribute("message", new Message("Dziękujemy", "Zamówienie przekazane do realizacji"));
        return "message";
    }



}


