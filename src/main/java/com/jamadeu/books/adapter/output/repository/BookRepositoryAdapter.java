package com.jamadeu.books.adapter.output.repository;

import org.springframework.stereotype.Component;

@Component
public class BookRepositoryAdapter {

    final SpringDataRepository repository;

    public BookRepositoryAdapter(SpringDataRepository repository) {
        this.repository = repository;
    }
}
