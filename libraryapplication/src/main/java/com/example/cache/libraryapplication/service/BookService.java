package com.example.cache.libraryapplication.service;

import com.example.cache.libraryapplication.dto.Book;

public interface BookService {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);
}
