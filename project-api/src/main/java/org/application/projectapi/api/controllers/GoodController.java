package org.application.projectapi.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.application.projectapi.api.dto.LaptopDto;
import org.application.projectapi.api.factories.HTMLGoodFactory;
import org.hibernate.query.Page;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Transactional
@AllArgsConstructor
@Controller
public class GoodController {

    private final HTMLGoodFactory htmlGoodFactory;


    @GetMapping(value = "/api", params = {"brand", "page"})
    public String laptopCollection(Model model,
                                   @RequestParam(value = "brand") String brand,
                                   @RequestParam(value = "page") Integer page) {
            var filter = LaptopDto.builder()
                    .brand(brand)
                    .page(page)
                    .build();
            model.addAttribute("filter", filter);
            model.addAttribute("source", htmlGoodFactory.getHtmlFromAPI(filter));

        return "mainScreen";
    }

}

