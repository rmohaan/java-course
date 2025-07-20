package org.mohaan.controllers;

import org.mohaan.models.AuthorDto;
import org.mohaan.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    // Define methods to handle HTTP requests here
    // For example, you can add methods for CRUD operations like:
    // - Get all authors
    // - Get author by ID
    // - Create a new author
    // - Update an existing author
    // - Delete an author

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/")
    public AuthorDto createAuthor(
            @RequestBody AuthorDto author
    ) {
        return authorService.createAuthor(author);
    }

}
