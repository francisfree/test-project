package com.incentro.myservice.application.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incentro.myservice.application.model.AppResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws ServletException {
        String message = authException.getMessage();
        if(message.contains(":")){
            message = message.substring(0, message.indexOf(":"));
        }
        AppResponse appResponse = new AppResponse(401, message);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), appResponse);
        } catch (Exception e) {
            throw new ServletException();
        }
    }

}
