package com.example.ksiegarnia.Zamowienie;

import com.example.ksiegarnia.Ksiazka.Ksiazka;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class KlientZamowienie {

    private Zamowienie zamowienie;

    public KlientZamowienie() {
        clear();
    }

    Zamowienie getOrder() {
        return zamowienie;
    }

    void add(Ksiazka ksiazka) {
        zamowienie.getKsiazka().add(ksiazka);
    }

    void clear() {
        zamowienie = new Zamowienie();
        zamowienie.setStan(WysylkaKsiazek.doRealizacji);
    }
}