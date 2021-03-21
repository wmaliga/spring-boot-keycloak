package com.wojtek.bookshelf.controller;

import com.wojtek.bookshelf.entity.Author;
import com.wojtek.bookshelf.entity.Book;
import com.wojtek.bookshelf.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    private final DataService dataService;

    @Autowired
    public WebController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/authors")
    public String authors(Model model) {
        List<Author> authors = this.dataService.findAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/books")
    public String books(Model model) {
        List<Book> books = this.dataService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
