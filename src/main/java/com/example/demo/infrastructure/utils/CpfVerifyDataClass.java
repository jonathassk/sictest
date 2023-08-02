package com.example.demo.infrastructure.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CpfVerifyDataClass {
    private String taxNumber;
    private boolean valid;
    private boolean exists;
}
