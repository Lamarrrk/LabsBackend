package org.example.labsbackend.services;
import org.example.labsbackend.models.User;
import org.example.labsbackend.models.Currency;
import org.example.labsbackend.repositories.UserRepository;
import org.example.labsbackend.repositories.CurrencyRepository;
import org.example.labsbackend.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public UserService(UserRepository userRepository, CurrencyRepository currencyRepository) {
        this.userRepository = userRepository;
        this.currencyRepository = currencyRepository;
    }

    public User createUser(User user) {
        if (user.getDefaultCurrency() != null) {
            Currency currency = currencyRepository.findById(user.getDefaultCurrency().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Currency not found"));
            user.setDefaultCurrency(currency);
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
