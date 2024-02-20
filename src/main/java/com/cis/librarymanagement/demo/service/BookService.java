package com.cis.librarymanagement.demo.service;

import com.cis.librarymanagement.demo.book.Book;
import com.cis.librarymanagement.demo.member.Member;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service
public class BookService {
    private final Map<Integer, Book> bookMap= new HashMap<>();

    public  Book createBook(Book book) {
        book.setBookID((Math.abs(new Random().nextInt())));
        bookMap.put(book.getBookID(), book);
        return book;
    }
    public Book deleteBook(int bookId) {
        Book book= new Book();
        bookMap.remove(book.getBookID());
        return book;
    }
    public Book getBook(int bookID) {
        return bookMap.get(bookID);

    }
    public Collection<Book> getAllBook() {
        return bookMap.values();
    }

    public Book updateBookData(int bookId, Book updatedBook) {
        System.out.println(bookMap);
        if(bookMap.containsKey(bookId)) {
            Book book = bookMap.get(bookId);
            if(!book.getTitle().isEmpty()) {
                book.setTitle(updatedBook.getTitle());
            }
            if(!book.getAuthor().isEmpty()) {
                book.setAuthor(updatedBook.getAuthor());
            }
            bookMap.put(bookId, book);
            System.out.println("updated successfully");
            return book;
        }
        return null;
    }
}
