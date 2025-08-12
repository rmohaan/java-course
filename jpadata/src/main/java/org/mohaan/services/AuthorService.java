package org.mohaan.services;

import org.mohaan.mappers.AuthorMapper;
import org.mohaan.models.AuthorDto;
import org.mohaan.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toModel)
                .collect(Collectors.toList());
    }

    public AuthorDto getAuthorByEmail(String email) {
        var author = authorRepository.findByEmail(email);
        return author != null ? authorMapper.toModel(author) : null;
    }

    public AuthorDto createAuthor(AuthorDto authorDto) {
        var author = authorMapper.toEntity(authorDto);
        return authorMapper.toModel(
                authorRepository.save(author)
        );
    }
}
