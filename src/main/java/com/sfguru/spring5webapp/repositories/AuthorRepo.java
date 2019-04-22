package com.sfguru.spring5webapp.repositories;

import com.sfguru.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {



}
