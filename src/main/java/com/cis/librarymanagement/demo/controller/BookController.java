package com.cis.librarymanagement.demo.controller;

import com.cis.librarymanagement.demo.book.Book;
import com.cis.librarymanagement.demo.member.Member;
import com.cis.librarymanagement.demo.service.BookService;
import com.cis.librarymanagement.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book create(@RequestBody Book book){

        return bookService.createBook(book);
    }
    @RequestMapping(value = "/book", method = RequestMethod.DELETE)
    public Book delete(@RequestParam int bookID){

        return bookService.deleteBook(bookID);

    }
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Book getBook(@RequestParam int bookID){

        return bookService.getBook(bookID);

    }

    @RequestMapping(value = "/allBook", method = RequestMethod.GET)
    public Collection<Book> getAllBook() {
        return bookService.getAllBook();
    }
    @RequestMapping(value = "/book/update", method = RequestMethod.PUT)
    public Book update(@RequestParam int bookID,
                         @RequestBody Book book) {
        return bookService.updateBookData(bookID, book);
    }

}
