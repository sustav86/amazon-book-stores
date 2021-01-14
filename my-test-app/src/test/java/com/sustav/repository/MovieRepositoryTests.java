package com.sustav.repository;

import com.sustav.model.MovieDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class MovieRepositoryTests {

    private String id;
    private MovieDocument movie;
    @Autowired
    private MovieRepository repository;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID().toString();
        movie = new MovieDocument(id, "Inception", "Origin of an idea", 8.8, 0L);
    }

    @Test
    public void save_savesMovie() {
        repository.save(movie);
        assertThat(repository.findById(id)).hasValue(movie);
    }

    @Test
    public void exists_returnsTrueIfMovieIsPresent() {
        repository.save(movie);
        assertThat(repository.existsById(id)).isTrue();
    }

    @Test
    public void deleteById_deletesExistingMovie() {
        repository.save(movie);
        repository.deleteById(id);
        assertThat(repository.findById(id)).isNotPresent();
    }

    @Test
    void deleteById_doesNothingForNonexistingMovie() {
        repository.deleteById(id);
    }
}
