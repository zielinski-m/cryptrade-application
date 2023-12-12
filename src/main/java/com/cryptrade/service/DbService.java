package com.cryptrade.service;

import com.cryptrade.controller.CryptocurrencyNotFoundException;
import com.cryptrade.domain.Cryptocurrency;
import com.cryptrade.repository.CryptocurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    public List<Cryptocurrency> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    public Cryptocurrency getCryptocurrency(final Long cryptocurrencyId) throws CryptocurrencyNotFoundException {
        return cryptocurrencyRepository.findById(cryptocurrencyId).orElseThrow(CryptocurrencyNotFoundException::new);
    }

    public Cryptocurrency saveCryptocurrency(final Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public void deleteCryptocurrency(final Long cryptocurrencyId) {
        cryptocurrencyRepository.deleteCryptocurrencyById(cryptocurrencyId);
    }
}
