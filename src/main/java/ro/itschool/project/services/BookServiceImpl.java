package ro.itschool.project.services;

import org.springframework.stereotype.Service;
import ro.itschool.project.models.entities.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> bookList = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        book.setId(UUID.randomUUID());
        book.setCreateAt(LocalDateTime.now());
        bookList.add(book);
        System.out.println("A new book was created: " + book.getTitle());

        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }
}