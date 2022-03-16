package com.springehcache.controller;

import com.springehcache.service.NumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
@RequiredArgsConstructor
@Slf4j
public class NumberController {

    private final NumberService numberService;

    @GetMapping(path = "/nocache/{number}")
    public String getNoCacheSquare(@PathVariable Integer number) {
        long start = System.currentTimeMillis();
        String result = String.format("{\"square\": %s}", numberService.noCacheSquare(number));
        long end = System.currentTimeMillis();

        log.info("NoCache 수행시간: " + (end - start));

        return result;
    }

    @GetMapping(path = "/cache/{number}")
    public String getCacheSquare(@PathVariable Integer number) {
        long start = System.currentTimeMillis();
        String result = String.format("{\"square\": %s}", numberService.cacheSquare(number));
        long end = System.currentTimeMillis();

        log.info("Cache 수행시간: " + (end - start));

        return result;
    }

}
