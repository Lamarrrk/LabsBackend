package org.example.labsbackend.controllers;

import org.example.labsbackend.models.Currency;
import org.example.labsbackend.services.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public ResponseEntity<Currency> createCurrency(@Valid @RequestBody Currency currency) {
        Currency createdCurrency = currencyService.createCurrency(currency);
        return ResponseEntity.ok(createdCurrency);
    }

    @GetMapping
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id) {
        Currency currency = currencyService.getCurrencyById(id);
        return ResponseEntity.ok(currency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
        return ResponseEntity.noContent().build();
    }
}

