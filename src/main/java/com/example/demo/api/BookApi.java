package com.example.demo.api;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookApi {

//    List<Book> books;

//    public BookApi() {
//        this.books = new ArrayList<>();
//        this.books.add(new Book(1L, "Władca Pierścieni", "John Ronald Reuel Tolkien"));
//        this.books.add(new Book(2L, "Rok 1984", "George Orwell"));
//    }

    private BookService bookService;

    @Autowired
    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll(){
//        return books;
        return bookService.findAll();
    }

    @GetMapping
    public Optional<Book> getBook(@RequestParam Long id){
//        Optional<Book> first = books.stream().filter(element -> element.getId() == id).findFirst();
//        return first.get();
        return bookService.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
//        return books.add(book);
        return bookService.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
//        return books.add(book);
        return bookService.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long id){
//        return books.removeIf(element -> element.getId() == id);
        bookService.deleteByID(id);
    }


}
