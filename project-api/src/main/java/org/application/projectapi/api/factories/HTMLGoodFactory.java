package org.application.projectapi.api.factories;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HTMLGoodFactory {
    private final String RESOURSE_OF_WORK_AT = "https://xstore.md/ru/noutbuki?gad_source=1&gad_campaignid=17547888846&gbraid=0AAAAABXAcq3-UjJfufTBaJ5sHZu6LFpDi&gclid=CjwKCAjw1tLOBhAMEiwAiPkRHudg5t-4s4J2kWnIu_OzyspkGuPjfnst85rt3xdJ15QQG1zwqSW5UBoCkAUQAvD_BwE";
    private final String CHROME_DRIVER_PATH = "C:\\Users\\48574\\Desktop\\programing_stuff\\TryCodingPeriod\\priceTracker\\project-api\\src\\main\\resources\\static\\chromedriver-win64\\chromedriver.exe";
    private final String LOCATION_OF_USER_DATA_ON_COMPUTER = "C:/Users/48574/AppData/Local/Google/Chrome/User Data";

    public String getHtmlFromAPI() {
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir:%s".formatted(LOCATION_OF_USER_DATA_ON_COMPUTER));
//        options.addArguments("profile-directory=Default");
//        WebDriver driver = new ChromeDriver(options);
//        driver.get(RESOURSE_OF_WORK_AT);
//        String html = driver.getPageSource();
//        return Jsoup.parse(html).select("._2CfekcK7").text();
        String json = "";
        Connection.Response respForCookie = null;
        try {
            respForCookie = Jsoup.connect(RESOURSE_OF_WORK_AT).method(Connection.Method.GET).execute();
            Element doc = Jsoup.connect(RESOURSE_OF_WORK_AT).userAgent("Chrome").cookies(respForCookie.cookies()).get();
            for(var i: doc.select(".card-product")){
                json += "{%s}\n".formatted(i.select(".card-xt").text());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

}



