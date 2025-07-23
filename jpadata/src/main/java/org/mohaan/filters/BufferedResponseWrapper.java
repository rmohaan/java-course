package org.mohaan.filters;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

//public class BufferedResponseWrapper  extends HttpServletResponseWrapper {
//    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//    private final PrintWriter writer;
//
//    public BufferedResponseWrapper(HttpServletResponse response) {
//        super(response);
       // this.writer = new PrintWriter(new OutputStreamWriter(buffer, StandardCharsets.UTF_8));
//    }
//
//    @Override
//    public PrintWriter getWriter() {
//        return writer;
//    }
//
//    public byte[] getBufferedContent() throws IOException {
//        writer.flush();  // Important!
//        return buffer.toByteArray();
//    }
//}
