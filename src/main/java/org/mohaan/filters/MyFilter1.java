package org.mohaan.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("This is a Servlet doFilter() Method !");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        ResponseWrapper responseWrapper = new ResponseWrapper(httpResponse);

        filterChain.doFilter(httpRequest, responseWrapper);

        System.out.println("Now the response flow begins in the filter...");

        String originalResponseBody = new String(responseWrapper.toByteArray());
        String modifiedResponseBody = modifyResponseBody(originalResponseBody);

        httpResponse.getOutputStream().write(modifiedResponseBody.getBytes(StandardCharsets.UTF_8));
        System.out.println("This is a Servlet doFilter() Method, while exiting...!" + httpResponse.getOutputStream());
    }

    private String modifyResponseBody(String originalResponseBody){
        // Add your modification logic here.
        return originalResponseBody + " - Modified by Filter";
    }
}
