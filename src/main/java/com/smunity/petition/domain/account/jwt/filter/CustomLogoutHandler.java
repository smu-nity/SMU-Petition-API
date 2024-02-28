package com.smunity.petition.domain.account.jwt.filter;

import com.smunity.petition.domain.account.jwt.exception.SecurityCustomException;
import com.smunity.petition.domain.account.jwt.exception.TokenErrorCode;
import com.smunity.petition.domain.account.jwt.util.JwtUtil;
import com.smunity.petition.domain.account.jwt.util.RedisUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
public class CustomLogoutHandler implements LogoutHandler {

    private final RedisUtil redisUtil;
    private final JwtUtil jwtUtil;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            log.info("[*] Logout Filter");

            String accessToken = jwtUtil.resolveAccessToken(request);

            redisUtil.save(
                    accessToken,
                    "logout",
                    jwtUtil.getExpTime(accessToken),
                    TimeUnit.MILLISECONDS
            );

            redisUtil.delete(
                    jwtUtil.getUsername(accessToken)
            );

        } catch (ExpiredJwtException e) {
            log.warn("[*] case : accessToken expired");
            throw new SecurityCustomException(TokenErrorCode.TOKEN_EXPIRED);
        }
    }
}
