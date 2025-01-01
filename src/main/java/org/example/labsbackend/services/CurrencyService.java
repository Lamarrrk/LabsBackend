package org.example.labsbackend.services;

import org.example.labsbackend.models.Currency;
import org.example.labsbackend.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency createCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found with id: " + id));
    }

    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }
}

