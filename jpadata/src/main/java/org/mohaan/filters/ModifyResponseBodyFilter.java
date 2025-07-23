//package org.mohaan.filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class ModifyResponseBodyFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
////        HttpServletResponse httpResp = (HttpServletResponse) response;
////        BufferedResponseWrapper wrappedResp = new BufferedResponseWrapper(httpResp);
////
////        chain.doFilter(request, wrappedResp);
////
////        // Get original response body
////        byte[] originalBody = wrappedResp.getBufferedContent();
////        String bodyStr = new String(originalBody, StandardCharsets.UTF_8);
////
////        // Modify it (e.g., wrap it in JSON)
////        String modified = "{\"status\":\"success\",\"data\":" + bodyStr + "}";
////
////        // Set headers and write new body
////        httpResp.setContentLength(modified.getBytes(StandardCharsets.UTF_8).length);
////        httpResp.setContentType("application/json");
////        httpResp.getWriter().write(modified);
//    }
//}
