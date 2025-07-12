package org.mohaan.model;

import java.util.List;

public interface BookService {
    Book buyBook(String ISBN);
    Book getBookDetails(String ISBN);
    List<Book> getAllBooks();
    List<Book> getAllBooksByAuthor(String authorName);
}

