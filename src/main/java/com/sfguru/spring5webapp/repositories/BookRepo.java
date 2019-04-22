package com.sfguru.spring5webapp.repositories;

import com.sfguru.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
