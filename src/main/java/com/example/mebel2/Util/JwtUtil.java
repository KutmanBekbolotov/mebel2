package com.example.mebel2.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtil {
//        @Value("${jwt_secret}")
        private final String secret = "tariel";

        public String generateToken(String username) {
            Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(120).toInstant());
            return JWT.create()
                    .withSubject("User details")
                    .withClaim("username", username)
                    .withIssuedAt(new Date())
                    .withIssuer("Tariel")
                    .withExpiresAt(expirationDate)
//                    .sign(Algorithm.HMAC384(secret));
                    .sign(Algorithm.HMAC256(secret));
        }

        public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withSubject("User details")
                    .withIssuer("Tariel")
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("username").asString();
        }
    }
