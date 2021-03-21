package com.wojtek.bookshelf.service;

import com.wojtek.bookshelf.entity.Author;
import com.wojtek.bookshelf.entity.Book;
import com.wojtek.bookshelf.repository.AuthorRepository;
import com.wojtek.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public DataService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }
}
