package org.cnu.realcoding.weathercrawler.domain;

import lombok.Data;

@Data
public class CurrentRiot {
    private String leagueId;
    private String leagueName;

    @Data
    public static class Main {
        private String position;
        private String tier;
        private String rank;
    }

    @Data
    public static class info {
        private String queueType;
        private String summonerId;
    }
}
