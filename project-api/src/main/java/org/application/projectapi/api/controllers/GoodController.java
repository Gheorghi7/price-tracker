package org.application.projectapi.api.controllers;

import lombok.AllArgsConstructor;
import org.application.projectapi.api.factories.HTMLGoodFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@Controller
@RequestMapping("/api")
public class GoodController {

    @GetMapping("/getHtml")
    public String mainScreen(Model model) {
        var html = new HTMLGoodFactory();
        String htmlFactory = html.getHtmlFromAPI();
        model.addAttribute("htmlShoppingCart", htmlFactory);
        return "mainScreen";

    }


}
