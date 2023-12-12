package com.cryptrade.service;

import com.cryptrade.controller.CryptocurrencyNotFoundException;
import com.cryptrade.domain.Cryptocurrency;
import com.cryptrade.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    public List<Cryptocurrency> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    public Cryptocurrency getCryptocurrency(Long cryptocurrencyId) {
        try {
            return cryptocurrencyRepository.findById(cryptocurrencyId).orElseThrow(CryptocurrencyNotFoundException::new);
        } catch (CryptocurrencyNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cryptocurrency saveCryptocurrency(Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public void deleteCryptocurrency(Long cryptocurrencyId) {
        cryptocurrencyRepository.deleteCryptocurrencyById(cryptocurrencyId);
    }
}
