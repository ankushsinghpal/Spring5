package guru.springframework.Spring5webApp.bootstrap;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publisher;
import guru.springframework.Spring5webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.repositories.BookRepository;


@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started In BootStrap");
        Publisher publisher=new Publisher();
        publisher.setName("Ankush pal singh");
        publisher.setCity("Gurdaspur");
        publisher.setState("Punjab");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count : "+ publisherRepository.count());


        Author author=new Author("Ankush","Pal");
        Book book=new Book("Data Structure with Java","12345");
        author.getBooks().add(book);
        book.getAuthors().add(author);


        book.setPublisher(publisher);
        publisher.getBooks().add(book);


        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author author2=new Author("Soorma","Singh");
        Book book2=new Book("Java Programs","123");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);


        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started In BootStrap");
        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Publisher Count : "+ publisher.getBooks().size());






    }
}
