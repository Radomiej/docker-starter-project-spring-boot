package pl.radomiej.dockerproject.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.radomiej.dockerproject.model.Book;
import pl.radomiej.dockerproject.repository.BookRepository;

import java.util.List;

//TODO implement REST Client for ElasticSearch
public class BookServiceElasticsearch implements BookService {

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Book findOne(String id) {
        return null;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }
}
