package com.sustav.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder(toBuilder = true)
@Entity(name = "job")
public class Job {

    @Id
    @Column(name = "job_id")
    private Integer id;
    private String name;
    private String vendor;
    private String description;

    @Tolerate
    public Job() {
    }
}
