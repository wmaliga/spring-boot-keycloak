package com.wojtek.bookshelf.repository;

import com.wojtek.bookshelf.config.TestConfig;
import com.wojtek.bookshelf.entity.Author;
import com.wojtek.bookshelf.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    public void before() {
        List<Book> books = TestConfig.allBooks();
        List<Author> authors = books.stream().map(Book::getAuthor).collect(toList());
        this.authorRepository.saveAll(authors);
        this.bookRepository.saveAll(books);
    }

    @Test
    public void findAllTest() {
        List<Book> books = this.bookRepository.findAll();

        assertThat(books).extracting(Book::getTitle).contains(
                "Hobbit",
                "The Lord of the Rings: The Fellowship of the Ring",
                "The Lord of the Rings: The Two Towers",
                "The Lord of the Rings: The Return of the King"
        );
    }
}
