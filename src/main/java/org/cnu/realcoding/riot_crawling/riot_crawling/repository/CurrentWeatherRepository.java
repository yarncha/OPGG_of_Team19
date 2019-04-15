package org.cnu.realcoding.riot_crawling.riot_crawling.repository;

import org.cnu.realcoding.riot_crawling.riot_crawling.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertCurrentWeather(CurrentWeather currentWeather)
    {
        mongoTemplate.insert(currentWeather);
    }
}
