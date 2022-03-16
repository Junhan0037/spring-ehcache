package com.springehcache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class NumberService {

    public BigDecimal noCacheSquare(int number) {
        slowQuery(1000);
        return BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
    }

    @Cacheable(value = "squareCache", key = "#number", condition = "#number > 10")
    public BigDecimal cacheSquare(int number) {
        slowQuery(1000);
        return BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
    }

    private void slowQuery(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
