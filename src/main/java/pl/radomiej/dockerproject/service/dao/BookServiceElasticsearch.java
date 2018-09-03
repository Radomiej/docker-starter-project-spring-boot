package pl.radomiej.dockerproject.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.radomiej.dockerproject.model.Book;
import pl.radomiej.dockerproject.repository.BookRepository;

import java.util.List;

public class BookServiceElasticsearch implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public Book findOne(String id) {
        return bookRepository.findById(id).get();
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
