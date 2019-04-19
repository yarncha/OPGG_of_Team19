package org.cnu.realcoding.weathercrawler.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableSummonerNameService {
    private String[] summonerNames = {
            "hide on bush"
    };
    public List<String> getAvailableSummonerNames() {
        List<String> collect = Arrays.stream(summonerNames).collect(Collectors.toList());
        return collect;
    }
}
