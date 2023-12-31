package com.alx.infoms.service;

import com.alx.infoms.common.ApiPaths;
import com.alx.infoms.dto.JWTTokenDTO;
import com.alx.infoms.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TokenGeneratorServiceImpl implements TokenGeneratorService {



    @Value("${jwt.secret}")
    String secret;

    @Override
    public JWTTokenDTO generateToken(User user) {
        String token = Jwts.builder().setSubject(user.getEmailAddress())
                        .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,
                        secret)
                                        .compact();



        return new JWTTokenDTO(token, ApiPaths.SUCCESS_MSG);
    }


    public User validateToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            User u = new User();
            u.setEmailAddress(body.getSubject());
            return u;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }
}
