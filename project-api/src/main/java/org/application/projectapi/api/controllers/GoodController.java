package org.application.projectapi.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.application.projectapi.api.factories.HTMLGoodFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Transactional
@AllArgsConstructor
@Controller
public class GoodController {

    private final HTMLGoodFactory htmlGoodFactory;

    @GetMapping("/api")
    public String laptopCollection(Model model) {
        model.addAttribute(
                "htmlShoppingCart",
                htmlGoodFactory.getHtmlFromAPI());

        System.out.println(model.getAttribute("htmlShoppingCart"));
        return "mainScreen";

    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }


}

