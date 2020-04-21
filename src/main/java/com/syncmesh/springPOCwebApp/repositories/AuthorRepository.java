package com.syncmesh.springPOCwebApp.repositories;

import com.syncmesh.springPOCwebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
