package com.example.demo.application.feign;

import com.example.demo.infrastructure.utils.CpfVerifyDataClass;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface CpfClient {
    @RequestLine("GET /{cpf}")
    @Headers("Content-Type: application/json")
    CpfVerifyDataClass validateCpf(@Param("cpf") String cpf);
}
