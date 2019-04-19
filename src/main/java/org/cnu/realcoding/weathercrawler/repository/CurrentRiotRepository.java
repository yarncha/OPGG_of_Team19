package org.cnu.realcoding.weathercrawler.repository;

import org.cnu.realcoding.weathercrawler.domain.CurrentRiot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrentRiotRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CurrentRiot> insertCurrentRiot(List<CurrentRiot> currentRiot) {
        return mongoTemplate.insert(currentRiot);
    }

    public CurrentRiot findRecentCurrentRiotBySummoner(String cityName) {
        Query query = new Query();

        query.addCriteria(Criteria.where("name").is(cityName));
        query.with(Sort.by(Sort.Order.desc("_id")));

        return mongoTemplate.findOne(query, CurrentRiot.class);
    }
}
