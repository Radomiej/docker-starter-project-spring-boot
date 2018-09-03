package pl.radomiej.dockerproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.radomiej.dockerproject.model.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

    Book findOneByTitle(String title);
}
