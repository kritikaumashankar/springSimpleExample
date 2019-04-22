package com.sfguru.spring5webapp.bootstrap;

import com.sfguru.spring5webapp.model.Author;
import com.sfguru.spring5webapp.model.Book;
import com.sfguru.spring5webapp.repositories.AuthorRepo;
import com.sfguru.spring5webapp.repositories.BookRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepo ar;
    private BookRepo br;

    public DevBootstrap(AuthorRepo ar, BookRepo br) {
        this.ar = ar;
        this.br = br;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Kritika
        Author kritika = new Author("Kritika","Umashankar");
        Book hp = new Book("Harry Potter", "1234", "Abc");
        kritika.getBooks().add(hp);
        hp.getAuthors().add(kritika);

        ar.save(kritika);
        br.save(hp);
        //Shiv
        Author shiv = new Author("Shiv","Kumar");
        Book golf = new Book("Golf for Beginners", "3456", "Def");
        shiv.getBooks().add(golf);
        golf.getAuthors().add(shiv);

        ar.save(shiv);
        br.save(golf);
    }
}
