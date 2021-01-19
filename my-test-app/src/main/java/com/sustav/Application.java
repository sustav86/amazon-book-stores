package com.sustav;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sustav.config.KafkaConsumerConfig;
import com.sustav.dto.StarshipDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

/**
 * @author Anton Sustavov
 * @since 2020/11/05
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {KafkaConsumerConfig.class})
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private KafkaConsumerConfig kafkaConsumerConfig;
    @Autowired
    private KafkaTemplate<Long, StarshipDto> kafkaStarshipTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public void run(String... args) throws Exception {
//        System.out.println(kafkaConsumerConfig.getServer());
        StarshipDto dto = createDto();
        log.info("<= sending {}", writeValueAsString(dto));
        kafkaStarshipTemplate.send("server.starship", dto);
    }

    private StarshipDto createDto() {
        return new StarshipDto("Starship " + (LocalTime.now().toNanoOfDay() / 1000), "dfv");
    }

    public String writeValueAsString(StarshipDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }

}
