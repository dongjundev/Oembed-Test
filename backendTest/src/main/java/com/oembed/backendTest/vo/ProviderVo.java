package com.oembed.backendTest.vo;

import lombok.Data;

import java.util.List;

@Data
public class ProviderVo {

    private String providerName;
    private String providerUrl;

    private List<Endpoint> endpoints;

    @Data
    public class Endpoint {
        private List<String> schemes;
        private String url;
    }
}
