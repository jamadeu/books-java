package com.jamadeu.books.adapter.input;

import com.jamadeu.books.application.domain.service.BookService;
import com.jamadeu.books.application.ports.input.BookControllerPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookControllerAdapter implements BookControllerPort {

    final BookService service;

    public BookControllerAdapter(BookService service) {
        this.service = service;
    }
}
