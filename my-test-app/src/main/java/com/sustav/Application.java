package com.sustav;

import com.sustav.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Anton Sustavov
 * @since 2020/11/05
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JobRepository jobRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        jobRepository.findById(1).ifPresent(x -> System.out.println(x));
    }
}
