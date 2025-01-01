package org.example.labsbackend.repositories;
import org.example.labsbackend.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
