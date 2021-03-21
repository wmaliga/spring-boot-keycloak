package com.wojtek.bookshelf.repository;

import com.wojtek.bookshelf.config.TestConfig;
import com.wojtek.bookshelf.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    public void before() {
        this.authorRepository.saveAll(TestConfig.allAuthors());
    }

    @Test
    public void findAllTest() {
        List<Author> authors = this.authorRepository.findAll();

        assertThat(authors).extracting(Author::getLastName).contains("Tolkien");
    }
}
