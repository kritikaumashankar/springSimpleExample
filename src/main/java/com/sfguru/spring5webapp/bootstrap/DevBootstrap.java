package com.sfguru.spring5webapp.bootstrap;

import com.sfguru.spring5webapp.model.Author;
import com.sfguru.spring5webapp.model.Book;
import com.sfguru.spring5webapp.model.Publisher;
import com.sfguru.spring5webapp.repositories.AuthorRepo;
import com.sfguru.spring5webapp.repositories.BookRepo;
import com.sfguru.spring5webapp.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepo ar;
    private BookRepo br;
    private PublisherRepo publisher;

    public DevBootstrap(AuthorRepo ar, BookRepo br, PublisherRepo publisher) {
        this.ar = ar;
        this.br = br;
        this.publisher = publisher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Kritika
        Author kritika = new Author("Kritika","Umashankar");
        Publisher abc = new Publisher("Abc","Sandy");
        Book hp = new Book("Harry Potter", "1234",abc);
        kritika.getBooks().add(hp);
        hp.getAuthors().add(kritika);

        publisher.save(abc);
        ar.save(kritika);
        br.save(hp);

        //Shiv
        Author shiv = new Author("Shiv","Kumar");
        Publisher def = new Publisher("Def","Sandy");
        Book golf = new Book("Golf for Beginners", "3456",def);
        shiv.getBooks().add(golf);
        golf.getAuthors().add(shiv);

        publisher.save(def);
        ar.save(shiv);
        br.save(golf);

    }
}
