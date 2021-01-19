package com.sustav.service;

import com.sustav.dto.StarshipDto;

public interface StarshipService {
    void send(StarshipDto dto);
    void consume(StarshipDto dto);
}
