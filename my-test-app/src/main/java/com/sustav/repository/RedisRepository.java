package com.sustav.repository;

import com.sustav.model.Student;

public interface RedisRepository {
//    Map<Object, Object> findAllMovies();
    void add(Student movie);
    void delete(String id);
//    Student findMovie(String id);
}
