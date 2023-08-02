package com.example.demo.application.feign.config;

import com.example.demo.application.feign.CpfClient;
import feign.Feign;
import feign.gson.GsonDecoder;

public class CpfValidateClientConfig {
    public static CpfClient verifyCpf(String baseUrl) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(CpfClient.class, baseUrl);
    }
}
