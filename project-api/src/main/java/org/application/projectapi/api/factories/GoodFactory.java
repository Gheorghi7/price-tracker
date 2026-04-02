package org.application.projectapi.api.factories;


import org.application.projectapi.api.dto.GoodDto;
import org.application.projectapi.store.entities.Good;
import org.springframework.stereotype.Component;

@Component
public class GoodFactory {
    public GoodDto createGoodDto(Good good) {
        return GoodDto.builder().name(good.getName()).build();
    }
}