package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
