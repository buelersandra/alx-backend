package com.alx.infoms.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.naming.AuthenticationException;
import javax.security.auth.message.AuthException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)  servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)  servletResponse;

        String bearerToken = httpServletRequest.getHeader("authorization");
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                filterChain.doFilter(httpServletRequest, httpServletResponse);

        } else {
            if(bearerToken == null || !bearerToken.startsWith("Bearer ")){
                throw new ServletException("Invalid token");
            }
        }

        String token = bearerToken.substring(7);
        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();

        httpServletRequest.setAttribute("claims", claims);
        httpServletRequest.setAttribute("blog", servletRequest.getParameter("id"));
        filterChain.doFilter(httpServletRequest, httpServletResponse);


    }
}
