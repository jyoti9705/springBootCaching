package com.example.cache.libraryapplication.serviceImpl;

import com.example.cache.libraryapplication.dto.Book;
import com.example.cache.libraryapplication.repository.BookRepository;
import com.example.cache.libraryapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @CachePut(cacheNames = "book", key = "#book.id")
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Cacheable(cacheNames = "book", key = "#id")
    public Book getBook(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    @CacheEvict(cacheNames = "book", key = "#id")
    public String deleteBook(long id) {
        bookRepository.deleteById(id);
        return "Book Deleted";
    }
}
