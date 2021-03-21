package com.wojtek.bookshelf.config;

import com.wojtek.bookshelf.entity.Author;
import com.wojtek.bookshelf.entity.Book;
import com.wojtek.bookshelf.repository.AuthorRepository;
import com.wojtek.bookshelf.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@Configuration
public class TestConfig {

    public static List<Author> allAuthors() {
        return singletonList(Author.builder().firstName("J. R. R.").lastName("Tolkien").build());
    }

    public static List<Book> allBooks() {
        Author author = allAuthors().get(0);

        Book book1 = Book.builder().author(author).title("Hobbit").year(1937).build();
        Book book2 = Book.builder().author(author).title("The Lord of the Rings: The Fellowship of the Ring").year(1954).build();
        Book book3 = Book.builder().author(author).title("The Lord of the Rings: The Two Towers").year(1954).build();
        Book book4 = Book.builder().author(author).title("The Lord of the Rings: The Return of the King").year(1955).build();

        return Stream.of(book1, book2, book3, book4).collect(toList());
    }

    @Bean
    public CommandLineRunner testData(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            List<Book> books = allBooks();
            List<Author> authors = books.stream().map(Book::getAuthor).collect(toList());
            authorRepository.saveAll(authors);
            bookRepository.saveAll(books);
        };
    }
}
