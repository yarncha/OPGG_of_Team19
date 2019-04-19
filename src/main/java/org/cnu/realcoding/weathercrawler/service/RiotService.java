package org.cnu.realcoding.weathercrawler.service;

import lombok.extern.slf4j.Slf4j;
import org.cnu.realcoding.weathercrawler.api.OpenRiotMapApiClient;
import org.cnu.realcoding.weathercrawler.domain.CurrentRiot;
import org.cnu.realcoding.weathercrawler.domain.CurrentSummoner;
import org.cnu.realcoding.weathercrawler.repository.CurrentRiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class RiotService {
    @Autowired
    private AvailableSummonerNameService availableSummonerNameService;
    @Autowired
    private OpenRiotMapApiClient openRiotMapApiClient;
    @Autowired
    private CurrentRiotRepository currentRiotRepository;

    private LinkedList<String> queue = new LinkedList<>();

    public List<String> getSummonerNames() {
        return availableSummonerNameService.getAvailableSummonerNames();
    }

//    public CurrentWeather getCurrentWeatherByCityName(String cityName) {
//        return currentRiotRepository.findRecentCurrentRiotBySummoner(cityName);
//    }

    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getCurrentWeatherPeriodicallyByCityName() {
        if (queue.isEmpty()) {
            List<String> availableCityNames = this.getSummonerNames();
            queue.addAll(availableCityNames);
        }

        String target = queue.pop();
        queue.add(target);

        System.out.println(target);

        CurrentSummoner currentSummoner = openRiotMapApiClient.getCurrentName(target);
        System.out.println(currentSummoner.getId());
        String get_id=currentSummoner.getId();

        List<CurrentRiot> currentRiot = openRiotMapApiClient.getCurrentRiot(get_id);
        List<CurrentRiot> insertedCurrentRiot = currentRiotRepository.insertCurrentRiot(currentRiot);

        log.info("CurrentRiot has inserted successfully. CurrentRiot : {}", insertedCurrentRiot);
    }
    public CurrentRiot getCurrentWeatherByCityName(String str) {
        return currentRiotRepository.findRecentCurrentRiotBySummoner(str);
    }
}