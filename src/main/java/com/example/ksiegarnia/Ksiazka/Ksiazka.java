package com.example.ksiegarnia.Ksiazka;
import javax.persistence.*;
@Entity
public class Ksiazka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tytul;
    private String kategoria;
    private String autor;
    private Double cena;
    @Column(length = 2048)
    private String opis;
    @Column(length = 1024)
    private String opis_Short;
    private String ksiazka_Foto;
    public String getKsiazka_Foto() {
        return ksiazka_Foto;
    }

    public void setKsiazka_Foto(String ksiazka_Foto) {
        this.ksiazka_Foto = ksiazka_Foto;
    }
    public String getOpis_Short() { return opis_Short; }
    public void setOpis_Short(String opis_Short) { this.opis_Short = opis_Short; }

    public Long getId() {return id; }
    public void setId(Long id) { this.id = id; }
    public Double getCena() { return cena; }
    public void setCena(Double cena) { this.cena = cena; }
    public String getTytul() { return tytul; }
    public void setTytul(String name) { this.tytul = name; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }
    public String getKategoria() { return kategoria; }
    public void setKategoria(String opis) { this.kategoria = opis; }
}
