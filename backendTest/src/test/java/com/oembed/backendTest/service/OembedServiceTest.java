package com.oembed.backendTest.service;

import com.oembed.backendTest.vo.OembedResVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class OembedServiceTest {

    @Autowired
    OembedService oembedService;

    @Test
    void webclientTest() {

        OembedResVo YoutubeOembedResVo = oembedService.oembedResponse("https://www.youtube.com/watch?v=dBD54EZIrZo");
        log.info("Youtube: {}", YoutubeOembedResVo);

        OembedResVo TwitterOembedResVo = oembedService.oembedResponse("https://twitter.com/hellopolicy/status/867177144815804416");
        log.info("Twitter: {}", TwitterOembedResVo);

        OembedResVo VimeoOembedResVo = oembedService.oembedResponse("https://vimeo.com/20097015");
        log.info("Vimeo: {}", VimeoOembedResVo);
    }
}