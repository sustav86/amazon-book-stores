package com.sustav.repository;

import com.sustav.model.MovieDocument;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieDocument, String> {
}
