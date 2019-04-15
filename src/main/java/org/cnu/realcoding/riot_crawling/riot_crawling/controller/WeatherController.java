package org.cnu.realcoding.riot_crawling.riot_crawling.controller;

import org.cnu.realcoding.riot_crawling.riot_crawling.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //controller aloc은 view return, RestController는 view return x
public class WeatherController {

    @Autowired //spring에서 new 대신
    private WeatherService weatherService;
    @GetMapping("/available-cities")
    public List<String> getAvailableCities()
    {
        return weatherService.getAvailableCityNames();
    }

}
