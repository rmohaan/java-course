//package org.mohaan.filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class SimpleResponseHeaderFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
////        HttpServletResponse httpResp = (HttpServletResponse) response;
////
////        // Continue the request chain (reaches controller)
////        chain.doFilter(request, response);
////
////        // After controller processes request
////        httpResp.addHeader("X-Processed-By", "ResponseHeaderFilter");
////        httpResp.setHeader("X-Time", String.valueOf(System.currentTimeMillis()));
//    }
//}
