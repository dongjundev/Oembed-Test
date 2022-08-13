package com.oembed.backendTest.service;

import com.oembed.backendTest.config.ProvidersConfig;
import com.oembed.backendTest.vo.OembedResVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OembedService {

    private final ProvidersConfig providersConfig;

    public OembedResVo oembedResponse(String userUrlData) {

        List<String> urlList = providersConfig.getUrlList();
        String host = findhost(userUrlData);
        String oembedUrl = createUrl(userUrlData, urlList, host);;

        WebClient webClient = WebClient.builder()
                .baseUrl(oembedUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        OembedResVo result = webClient.get()
                .retrieve()
                .bodyToMono(OembedResVo.class)
                .block();

        return result;
    }

    private String createUrl(String userUrlData, List<String> urlList, String host) {

        String oembedUrl="";

        for (String url : urlList) {
            if (url.contains(host)) {
                if (url.contains("oembed.{format}")) {
                    url = url.replace("{format}", "json");
                    oembedUrl = url + "?url=" + userUrlData;
                } else {
                    oembedUrl = url + "?url=" + userUrlData + "&format=json";
                }
                break;
            }
        }

        return oembedUrl;
    }

    private String findhost(String userUrlData) {

        String[] split = userUrlData.split("\\.");
        String host = "";

        if (split.length == 2) {
            host = split[0];
            if (host.contains("//")) {
                String[] split2 = split[0].split("//");
                host = split2[1];
            }
        } else if (split.length == 3) {
            host = split[1];
        }

        return host;
    }
}
