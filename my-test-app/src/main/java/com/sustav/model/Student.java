package com.sustav.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@Value
@Data
@Builder(toBuilder = true)
public class Student {

    public enum Gender {
        MALE, FEMALE
    }

    String id;
    String name;
    Gender gender;
    int grade;
}
