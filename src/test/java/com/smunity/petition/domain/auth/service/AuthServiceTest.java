package com.smunity.petition.domain.auth.service;

import com.smunity.petition.domain.auth.dto.AuthRequestDto;
import com.smunity.petition.domain.auth.dto.AuthResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    public void authenticateTest() throws Exception {
        //given
        AuthRequestDto requestDto = new AuthRequestDto("201911019", "1q2w3e4r^^");

        //when
        AuthResponseDto response = authService.authenticate(requestDto);

        //then
        System.out.println(response);
    }
}
