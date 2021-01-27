package com.example.ksiegarnia.Zamowienie;

public enum WysylkaKsiazek {
    doRealizacji,
    wTrakciePakowania,
    wyslaneDoCzytelnika;

    static WysylkaKsiazek nextStatus(WysylkaKsiazek stan){
        if (stan == doRealizacji)
            return wTrakciePakowania;
        else if (stan == wTrakciePakowania)
            return wyslaneDoCzytelnika;
        else
            throw new IllegalArgumentException("Coś poszło nie tak");
    }
}
