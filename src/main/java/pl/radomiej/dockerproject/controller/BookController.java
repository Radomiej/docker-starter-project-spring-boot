package pl.radomiej.dockerproject.controller;

import org.bson.types.ObjectId;
import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.radomiej.dockerproject.model.Book;
import pl.radomiej.dockerproject.repository.BookRepository;
import pl.radomiej.dockerproject.tool.IsoDateTimeHelper;

import java.util.List;

@RestController
@RequestMapping("/api/1/book")
public class BookController {
    @Autowired
    private BookRepository repository;
    RandomNameGenerator rnd = new RandomNameGenerator(0);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") String id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public Book getBookByTitle(@PathVariable("title") String title) {
        return repository.findOneByTitle(title);
    }

    @RequestMapping(value = "/createRandomBook", method = RequestMethod.GET)
    public ResponseEntity<Book> createRandomBook() {
        Book randomBook = new Book();
        randomBook.setAuthor(rnd.next());
        randomBook.setTitle(rnd.next());
        randomBook.setReleaseDate(IsoDateTimeHelper.getStringDateSinceNow(-1 * 24 * 60 * 60 * 1000));
        randomBook = repository.save(randomBook);
        return ResponseEntity.ok(randomBook);
    }
}
