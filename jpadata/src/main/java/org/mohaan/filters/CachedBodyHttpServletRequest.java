package org.mohaan.filters;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.*;

//public class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {

   // private final byte[] cachedBody;

 //   public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
   //     super(request);
        // Cache the body as bytes
//        InputStream requestInputStream = request.getInputStream();
//        this.cachedBody = requestInputStream.readAllBytes();
   // }

//    @Override
//    public ServletInputStream getInputStream() {
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cachedBody);
//
//        return new ServletInputStream() {
//            @Override
//            public boolean isFinished() { return byteArrayInputStream.available() == 0; }
//            @Override
//            public boolean isReady() { return true; }
//            @Override
//            public void setReadListener(ReadListener readListener) {}
//            @Override
//            public int read() { return byteArrayInputStream.read(); }
//        };
//    }
//
//    @Override
//    public BufferedReader getReader() {
//        return new BufferedReader(new InputStreamReader(getInputStream()));
//    }
//
//    public byte[] getCachedBody() {
//        return cachedBody;
//    }
//}
