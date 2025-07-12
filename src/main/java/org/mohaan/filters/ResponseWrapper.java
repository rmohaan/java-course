package org.mohaan.filters;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ResponseWrapper extends HttpServletResponseWrapper {
    private ByteArrayOutputStream outputStream;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        System.out.println("Calling Response wrapper constructor...");
        outputStream = new ByteArrayOutputStream();
    }

//    @Override
//    public ServletOutputStream getOutputStream() throws IOException {
//        return new ServletOutputStream() {
//            @Override
//            public void write(int b) throws IOException {
//                outputStream.write(b);
//            }
//
//            @Override
//            public boolean isReady() {
//                return true;
//            }
//
//            @Override
//            public void setWriteListener(WriteListener listener) {
//            }
//        };
//    }

    public byte[] toByteArray() {
        return outputStream.toByteArray();
    }
}
