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

    private String requestUrl = "https://api.openweathermap.org/data/2.5/weather?q={cityName}&appid=76c78dc32e3058545c3cfbee13d44e6e";

    public CurrentWeather getCurrentWeather(String cityName)   //도시이름을 받아야됨
    {
        //웹서버로부터 response가 들어오게 하는 함수
        return restTemplate.exchange(requestUrl, HttpMethod.GET, null, CurrentWeather.class, cityName)
            .getBody();
    }

}
