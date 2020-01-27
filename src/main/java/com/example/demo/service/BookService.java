package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Optional<Book> findById(Long id){
        return bookRepo.findById(id);
    }

    public Iterable<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book save(Book book){
        return bookRepo.save(book);
    }

    public void deleteByID(Long id){
        bookRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Book(1L, "Władca Pierścieni", "John Ronald Reuel Tolkien"));
        save(new Book(2L, "Rok 1984", "George Orwell"));
    }
}
