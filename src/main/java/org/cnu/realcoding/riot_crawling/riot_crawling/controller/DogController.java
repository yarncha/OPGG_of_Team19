package org.cnu.realcoding.riot_crawling.riot_crawling.controller;

import org.cnu.realcoding.riot_crawling.riot_crawling.domain.Dog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    private List<Dog> dogList = new ArrayList<>();

    @PostMapping("/dogs") //http

    public void insertDog(@RequestBody Dog dog){
        dogList.add(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> findAllDogs(){
        return dogList;
    }

    @GetMapping("/dogs/{name}")    //http://localhost:8088/dogs?name=ian
    public Dog findDogs(@RequestParam String name)
    {
        for(int i=0;i<dogList.size();i++)
        {
            if(dogList.get(i).getName().equals(name))
                return dogList.get(i);
        }
        return null;

    }
}
