package com.lens.gateway;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callme")
public class CallmeController {

    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    @GetMapping("/ping")
    public String ping() {
        return "Hello!";
    }
}