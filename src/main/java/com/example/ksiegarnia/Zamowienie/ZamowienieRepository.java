package com.example.ksiegarnia.Zamowienie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Long> {
    List<Zamowienie> findAllByStan(WysylkaKsiazek stan);
}

