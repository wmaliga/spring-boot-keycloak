package com.wojtek.bookshelf.config;

import com.wojtek.bookshelf.entity.Author;
import com.wojtek.bookshelf.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
public class TestConfig {

    public static List<Author> allAuthors() {
        return singletonList(Author.builder().firstName("J. R. R.").lastName("Tolkien").build());
    }

    @Bean
    public CommandLineRunner testData(AuthorRepository authorRepository) {
        return args -> authorRepository.saveAll(allAuthors());
    }
}
