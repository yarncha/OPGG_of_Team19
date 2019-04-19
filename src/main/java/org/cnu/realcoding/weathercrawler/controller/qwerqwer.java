package org.cnu.realcoding.weathercrawler.controller;

import org.cnu.realcoding.weathercrawler.domain.CurrentRiot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class qwerqwer {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/test")
    public void test() {
        ParameterizedTypeReference<List<CurrentRiot>> responseType = new ParameterizedTypeReference<List<CurrentRiot>>() {};
        String requestUrlOfRiot = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apiKey}";
        String hideOnBushEncryptedSummonerId = "6gdgEWQLkHs3CZEaCnvqpMkUcsERnbz0rThdUf3i54G8xw";
        List<CurrentRiot> currentRiotList = restTemplate.exchange(requestUrlOfRiot, HttpMethod.GET, null, responseType, hideOnBushEncryptedSummonerId, "RGAPI-1278f60b-3252-46e3-bab2-2b0219f38212")
                .getBody();
        System.out.println(currentRiotList);
    }
}
