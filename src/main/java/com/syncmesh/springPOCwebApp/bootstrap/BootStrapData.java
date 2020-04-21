package com.syncmesh.springPOCwebApp.bootstrap;

import com.syncmesh.springPOCwebApp.domain.Author;
import com.syncmesh.springPOCwebApp.domain.Book;
import com.syncmesh.springPOCwebApp.domain.Publisher;
import com.syncmesh.springPOCwebApp.repositories.AuthorRepository;
import com.syncmesh.springPOCwebApp.repositories.BookRepository;
import com.syncmesh.springPOCwebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap...");

        Publisher publisher = new Publisher();
        publisher.setName("SyncMesh Publishing");
        publisher.setCity("Rishon LeZion");
        publisher.setState("Israel");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());


        Author uri = new Author("Uri", "Pap");
        Book linux = new Book("Linux Infrastructure", "000000");
        uri.getBooks().add(linux);
        linux.getAuthors().add(uri);

        linux.setPublisher(publisher);
        publisher.getBooks().add(linux);

        authorRepository.save(uri);
        bookRepository.save(linux);
        publisherRepository.save(publisher);

//        Author arik = new Author("Arik", "Regev");
//        Book bdida = new Book("Discrete mathematics", "000001");
//        arik.getBooks().add(bdida);
//        bdida.getAuthors().add(arik);
//
//        authorRepository.save(arik);
//        bookRepository.save(bdida);

        Author daniel = new Author("Daniel", "Elias");
        Book aws = new Book("Amazon Web Services", "000002");
        daniel.getBooks().add(aws);
        aws.getAuthors().add(daniel);

        aws.setPublisher(publisher);
        publisher.getBooks().add(aws);

        authorRepository.save(daniel);
        bookRepository.save(aws);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());


    }
}
