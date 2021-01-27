package com.example.ksiegarnia.Ksiazka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface KsiazkaRepository extends JpaRepository<Ksiazka, Long> {

    Optional<Ksiazka> findByTytulIgnoreCase(String tytul);
}
