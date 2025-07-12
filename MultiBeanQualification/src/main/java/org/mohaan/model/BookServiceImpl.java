package org.mohaan.model;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book buyBook(String ISBN) {
        return null;
    }

    @Override
    public Book getBookDetails(String ISBN) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String authorName) {
        return List.of();
    }
}
