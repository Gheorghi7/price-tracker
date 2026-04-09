package org.application.projectapi.api.factories;

import org.application.projectapi.api.dto.LaptopDto;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HTMLGoodFactory {

    private final String RESOURCE_OF_WORK_AT = "https://xstore.md/ru/noutbuki?brand=%s&page=%d";


    public String create(LaptopDto filter) {
      return RESOURCE_OF_WORK_AT.formatted(filter.getBrand(), filter.getPage());
    }

    public List getHtmlFromAPI() {
        List<List<String>> json = new ArrayList<>();
        Connection.Response respForCookie = null;
        try {
            respForCookie = Jsoup.connect(RESOURCE_OF_WORK_AT).method(Connection.Method.GET).execute();
            Element doc = Jsoup.connect(RESOURCE_OF_WORK_AT).userAgent("Chrome").cookies(respForCookie.cookies()).get();
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


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

}



