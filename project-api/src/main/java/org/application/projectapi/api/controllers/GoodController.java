package org.application.projectapi.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.application.projectapi.api.dto.LaptopDto;
import org.application.projectapi.api.factories.HTMLGoodFactory;
import org.hibernate.query.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Transactional
@AllArgsConstructor
@Controller
public class GoodController {

    private final HTMLGoodFactory htmlGoodFactory;


    @GetMapping("/api")
    public String laptopCollection(Model model,
                                   @RequestParam(value = "brand", defaultValue = "hp") String brand,
                                   @RequestParam(value = "page", defaultValue = "1") Integer page) {
        var filter = LaptopDto.builder()
                .brand(brand)
                .page(page)
                .build();
        htmlGoodFactory.create(filter);
        model.addAttribute("filter", filter);
        model.addAttribute("source", htmlGoodFactory.getHtmlFromAPI());
        return "mainScreen";
    }

}

