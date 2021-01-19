package com.sustav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StarshipDto extends AbstractDto {
    String name;
    String model;

    public StarshipDto() {
    }
}
