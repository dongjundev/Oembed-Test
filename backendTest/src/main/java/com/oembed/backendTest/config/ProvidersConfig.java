package com.oembed.backendTest.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.oembed.backendTest.vo.ProviderVo;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ProvidersConfig {

    private final List<String> urlList = new ArrayList<>();

    @PostConstruct
    private void init() throws IOException {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        ClassPathResource resource = new ClassPathResource("providers.json");
        JsonReader jr = new JsonReader(new FileReader(resource.getFile()));

        ProviderVo[] providerVos = gson.fromJson(jr, ProviderVo[].class);

        for (ProviderVo providerVo : providerVos) {

            String url = providerVo.getEndpoints().get(0).getUrl();
            urlList.add(url);
        }
    }
}
