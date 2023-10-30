package com.example.controller;

import com.example.model.Child;
import com.example.model.UserDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class StartAppTest implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Garik");

        UserDetails.DrawDataJson drawDataJson = new UserDetails.DrawDataJson();
        UserDetails.PrizePayoutsJson e1 = new UserDetails.PrizePayoutsJson();
        e1.setAmount("E1 Amount");
        e1.setMatches("E1 Matches");
        e1.setWinners("E1 Winners");
        e1.setLevel("E1 Level");
        UserDetails.PrizePayoutsJson e2 = new UserDetails.PrizePayoutsJson();

        e2.setAmount("E2 Amount");
        e2.setMatches("E2 Matches");
        e2.setWinners("E2 Winners");
        e2.setLevel("E2 Level");

        drawDataJson.setPrizePayouts(List.of(e1, e2));
        userDetails.setDrawDataJson(drawDataJson);
        entityManager.persist(userDetails);

        Child child = new Child();
        child.setName("AAAAAAAAAAA");
    }


}
