package com.sustav.store.config;

import com.sustav.store.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anton Sustavov
 * @since 2020/10/26
 */
@Configuration
public class SpringConfig {

    @Bean
    public Book book() {
        return new Book();
    }
}
