package com.vanguard.vp.portal.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanguard.vp.portal.data.entity.Book;
import com.vanguard.vp.portal.data.repository.BookRepository;
import com.vanguard.vp.portal.model.BookRequest;


@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book create(BookRequest request) {
        Book entity = new Book();
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());

        return repository.save(entity);

    }

    public Book read(UUID id) {
        return repository.findOne(id);
    }
}
