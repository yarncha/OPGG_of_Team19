package org.cnu.realcoding.riot_crawling.riot_crawling.service;

import org.cnu.realcoding.riot_crawling.riot_crawling.repository.CurrentWeatherRepository;
import org.cnu.realcoding.riot_crawling.riot_crawling.api.OpenWeatherMapApiClient;
import org.cnu.realcoding.riot_crawling.riot_crawling.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private AvailableCityNameService availableCityNameService;
    @Autowired
    private OpenWeatherMapApiClient openWeatherMapApiClient;

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;
    private LinkedList<String> queue = new LinkedList();

    public List<String> getAvailableCityNames()
    {
        return availableCityNameService.getAvailableCityNames();
    }
    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getCurrentWeatherPeriodically()
    {
        if(queue.isEmpty())
        {
            queue.addAll(this.getAvailableCityNames());
        }
        String target = queue.pop();
        queue.add(target);

        CurrentWeather currentWeather = openWeatherMapApiClient.getSummonerInfo(target);
        currentWeatherRepository.insertCurrentWeather(currentWeather);

    }


}
