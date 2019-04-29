package org.cnu.realcoding.weathercrawler.domain;

import lombok.Data;

@Data
public class CurrentRiot {

    private String summonerName;
    private String position;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean freshBlood;
    private boolean hotStreak;

}
