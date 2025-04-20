package com.jamadeu.books.adapter.output.repository;

import com.jamadeu.books.application.domain.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataRepository extends ReactiveCrudRepository<Book, Long> {
}
