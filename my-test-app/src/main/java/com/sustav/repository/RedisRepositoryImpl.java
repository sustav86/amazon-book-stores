package com.sustav.repository;

import com.sustav.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Student";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, String> hashOperations;

    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Student student) {
        hashOperations.put(KEY, student.getId(), student.getName());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

//    public Student findMovie(final String id){
//        return (Student) hashOperations.get(KEY, id);
//    }
//
//    public Map<Object, Object> findAllMovies(){
//        return hashOperations.entries(KEY);
//    }
}
