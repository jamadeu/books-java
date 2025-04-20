package com.jamadeu.books.application.domain.service;

import com.jamadeu.books.application.ports.output.repository.BookRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    final BookRepositoryPort repository;

    public BookService(BookRepositoryPort repository) {
        this.repository = repository;
    }
}
