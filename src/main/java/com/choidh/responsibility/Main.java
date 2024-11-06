package com.choidh.responsibility;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("아바타", Duration.ofMinutes(120), Money.wons(15000), new AmountDiscountPolicy(
                Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(8, 0), LocalTime.of(10, 0))
                ));
    }
}