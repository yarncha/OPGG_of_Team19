package org.cnu.realcoding.riot_crawling.riot_crawling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RiotCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiotCrawlerApplication.class, args);
	}

}
