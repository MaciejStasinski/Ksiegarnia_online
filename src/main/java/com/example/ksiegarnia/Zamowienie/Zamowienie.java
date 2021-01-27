package com.example.ksiegarnia.Zamowienie;

import com.example.ksiegarnia.Ksiazka.Ksiazka;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zamowieniaKlienta")
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "ZamowioneKsiazki",
            joinColumns = @JoinColumn(name = "zamowienie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ksiazka_id", referencedColumnName = "id")
    )
    private List<Ksiazka> ksiazka = new ArrayList<>();
    private String address;
    private String telefon;
    @Enumerated(EnumType.STRING)
    private WysylkaKsiazek stan;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<Ksiazka> getKsiazka() { return ksiazka; }
    public void setKsiazka(List<Ksiazka> ksiazka) { this.ksiazka = ksiazka; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public WysylkaKsiazek getStan() { return stan; }
    public void setStan(WysylkaKsiazek stan) { this.stan = stan; }
}


