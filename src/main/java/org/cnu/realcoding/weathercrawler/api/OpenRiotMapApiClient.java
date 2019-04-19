package org.cnu.realcoding.weathercrawler.api;

import org.cnu.realcoding.weathercrawler.domain.CurrentRiot;
import org.cnu.realcoding.weathercrawler.domain.CurrentSummoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenRiotMapApiClient {
    @Autowired
    private RestTemplate restTemplate;
    private final ParameterizedTypeReference<List<CurrentRiot>> responseType = new ParameterizedTypeReference<List<CurrentRiot>>() {};

    private String apiKey = "RGAPI-1278f60b-3252-46e3-bab2-2b0219f38212";
    private String requestUrlOfName = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}";
    private String requestUrlOfRiot = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/[encryptedSummonerId]?api_key={apiKey}";

    public List<CurrentRiot> getCurrentRiot(String summonerName) {
        List<CurrentRiot> currentRiotList = restTemplate.exchange(requestUrlOfRiot, HttpMethod.GET, null, responseType, summonerName, apiKey).getBody();
        return currentRiotList;
    }

    public CurrentSummoner getCurrentName(String summonerName) {
        CurrentSummoner currentName = restTemplate.exchange(requestUrlOfName, HttpMethod.GET, null, CurrentSummoner.class, summonerName, apiKey)
                .getBody();
        return currentName;

    }
}
