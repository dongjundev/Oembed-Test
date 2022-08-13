package com.oembed.backendTest.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class providersConfigTest {

    @Autowired
    ProvidersConfig providersConfig;

    @Test
    void parsing() {
        assertThat(providersConfig.getUrlList().size()).isEqualTo(287);
    }
}