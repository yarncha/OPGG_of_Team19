package org.cnu.realcoding.riot_crawling.riot_crawling.api;

import org.cnu.realcoding.riot_crawling.riot_crawling.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private String requestUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/hide%20on%20bush?api_key=RGAPI-f8762269-9135-4219-922c-ba67c9d11f48";

    public CurrentWeather getSummonerInfo(String summonerName)
    {
        //웹서버로부터 response가 들어오게 하는 함수
        return restTemplate.exchange(requestUrl, HttpMethod.GET, null, CurrentWeather.class, summonerName)
            .getBody();
    }

}
