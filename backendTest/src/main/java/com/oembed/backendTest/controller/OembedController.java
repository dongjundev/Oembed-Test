package com.oembed.backendTest.controller;

import com.oembed.backendTest.service.OembedService;
import com.oembed.backendTest.vo.OembedResVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class OembedController {

    private final OembedService oembedService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/oembedResponse")
    public String oembedResponse(Model model, @RequestParam("userUrlData") String userUrlData) {

        OembedResVo oembedResVo = oembedService.oembedResponse(userUrlData);
        model.addAttribute("oembedRes", oembedResVo);

        return "home :: #content_wrap";
    }

    @ExceptionHandler(Exception.class)
    public String error(Model model, Exception e) {

        log.error("Error: {}", e.getMessage());
        model.addAttribute("error", "error");

        return "home :: #content_wrap";
    }
}
