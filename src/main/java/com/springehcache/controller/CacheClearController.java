package com.springehcache.controller;

import com.springehcache.utils.EhcacheManagerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clear")
@RequiredArgsConstructor
public class CacheClearController {

    private final EhcacheManagerUtil util;

    @DeleteMapping("/cache/{cache_name}")
    public ResponseEntity<Void> clearCacheByName(@PathVariable(name = "cache_name") String cacheName) {
        util.clearCache(cacheName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cache/all")
    public ResponseEntity<String> clearCacheAll() {
        util.clearCacheAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
