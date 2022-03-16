package com.springehcache.controller;

import com.springehcache.utils.EhcacheManagerUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NumberControllerTest {

    @Autowired private MockMvc mockMvc;
    @Mock EhcacheManagerUtil ehcacheManagerUtil;

    long start;
    long end;

    @BeforeEach
    void setUp() {
        ehcacheManagerUtil.clearCacheAll();
        start = System.currentTimeMillis();
    }

    @AfterEach
    void checkTime() {
        end = System.currentTimeMillis();
        System.out.println("총 수행시간: " + (end-start));
    }

    @Test
    @DisplayName("캐시를 안탔을 경우 속도 테스트")
    void no_cache_Test() throws Exception {
        for (int i = 1; i < 5; i++) {
            mockMvc.perform(get("/number/nocache/" + 30))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.square").exists());
        }
    }

    @Test
    @DisplayName("캐시를 탔을 경우 속도 테스트")
    void cache_Test() throws Exception {
        for (int i = 1; i < 5; i++) {
            mockMvc.perform(get("/number/cache/" + 30))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.square").exists());
        }
    }

}