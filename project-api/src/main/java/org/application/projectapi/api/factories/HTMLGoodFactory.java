package org.application.projectapi.api.factories;

import org.application.projectapi.api.dto.LaptopDto;
import org.application.projectapi.api.exeptions.CheckUrl;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Scope("prototype")
@Service
public class HTMLGoodFactory {

    private final String RESOURCE_OF_WORK_AT = "https://xstore.md/ru/noutbuki?brand=%s&page=%d";

    public List getHtmlFromAPI(LaptopDto filter) {
        String url = RESOURCE_OF_WORK_AT.formatted(filter.getBrand(), filter.getPage());
        List<List<String>> json = new ArrayList<>();
        Connection.Response respForCookie = null;
        try {
            respForCookie = Jsoup.connect(url).method(Connection.Method.GET).execute();
            Element doc = Jsoup.connect(url).userAgent("Chrome").cookies(respForCookie.cookies()).get();
            for (var i : doc.select(".card-product")) {
                String[] tempList = i.select(".info-wrap > a").text().split(" ");
                List<String> tempAttr = Arrays.asList(i.select(".xp-attr").text().split("/"));
                json.add(List.of(
                        "%s\n".formatted(tempList[0]),
                        "%s\n".formatted(String.join(" ", Arrays.asList(tempList).subList(1, tempList.length))),
                        "%s\n".formatted(tempAttr.get(0)),
                        "%s\n".formatted(tempAttr.get(1)),
                        "%s\n".formatted(tempAttr.get(2)),
                        "%s\n".formatted(tempAttr.get(3)),
                        "%s\n".formatted(i.select(".xprice-old > span").text()),
                        "%s\n".formatted(i.select(".xprice").text())));

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return json;
    }




}






