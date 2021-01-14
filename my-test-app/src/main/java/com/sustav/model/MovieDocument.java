package com.sustav.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.aerospike.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Value
@Document(collection = "demo-service-movies")
@Builder(toBuilder = true)
@AllArgsConstructor
public class MovieDocument {
    @Id
    String id;
    @Field
    String name;
    @Field("desc")
    String description;
    @Field
    double rating;
    @Version
    @NonFinal
    long version;
}
