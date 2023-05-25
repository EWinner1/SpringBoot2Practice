package com.ewinner.QuickStart.Controllers;

import com.ewinner.QuickStart.Common.Models.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    @PutMapping
    public String saveBooks(@RequestBody Book book) {
        return "Book " + book + " has been saved";
    }

    @DeleteMapping("/{id}")
    public String deleteBooks(@PathVariable Integer id) {
        return "Book " + id + " has been deleted";
    }

    @PostMapping
    public String updateBooks(@RequestBody Book book) {
        return "Book " + book + " has been updated";
    }

    @GetMapping("/{id}")
    public String getBooks(@PathVariable Integer id) {
        return "Book " + id + " has been got";
    }

    @GetMapping
    public String getAllBooks() {
        return "Books has been got";
    }
}
