package com.syncmesh.springPOCwebApp.repositories;

import com.syncmesh.springPOCwebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book,Long> {
}
