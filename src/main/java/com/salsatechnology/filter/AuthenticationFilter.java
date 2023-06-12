package com.salsatechnology.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private static final String TOKEN_HEADER = "X-Token";
    private static final String VALID_TOKEN = "myToken123";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização do filtro
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String token = httpRequest.getHeader(TOKEN_HEADER);

        if (isValidUser(token)) {
            chain.doFilter(request, response); // Permite o acesso à requisição
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    public void destroy() {
        // Liberação de recursos
    }

    private boolean isValidUser(String token) {
        return VALID_TOKEN.equals(token);
    }
}
