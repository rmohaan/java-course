//package org.mohaan.filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletRequestWrapper;
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class RequestBodyAlteringFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
////        HttpServletRequest httpRequest = (HttpServletRequest) request;
////
////        // Only wrap for POST/PUT with body content
////        if ("POST".equalsIgnoreCase(httpRequest.getMethod()) ||
////                "PUT".equalsIgnoreCase(httpRequest.getMethod())) {
////
////            CachedBodyHttpServletRequest wrappedRequest = new CachedBodyHttpServletRequest(httpRequest);
////
////            // Read and log original body
////            String originalBody = new String(wrappedRequest.getCachedBody(), StandardCharsets.UTF_8);
////            System.out.println("📥 Original Request Body: " + originalBody);
////
////            // Optional: Modify body (e.g., inject a field)
////            String modifiedBody = originalBody.replace("foo", "bar");
////
////            // Replace body in wrapper
////            CachedBodyHttpServletRequest modifiedRequest = new CachedBodyHttpServletRequest(
////                    new HttpServletRequestWrapper(httpRequest) {
////                        @Override
////                        public ServletInputStream getInputStream() {
////                            return new ServletInputStream() {
////                                private final ByteArrayInputStream in =
////                                        new ByteArrayInputStream(modifiedBody.getBytes(StandardCharsets.UTF_8));
////                                public boolean isFinished() { return in.available() == 0; }
////                                public boolean isReady() { return true; }
////                                public void setReadListener(ReadListener listener) {}
////                                public int read() { return in.read(); }
////                            };
////                        }
////
////                        @Override
////                        public BufferedReader getReader() {
////                            return new BufferedReader(new InputStreamReader(getInputStream()));
////                        }
////                    }
////            );
////
////            chain.doFilter(modifiedRequest, response);
////        } else {
////            // Continue for other HTTP methods
////            chain.doFilter(request, response);
////        }
//    }
//}
