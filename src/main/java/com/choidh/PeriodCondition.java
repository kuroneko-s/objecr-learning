package com.choidh;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 시간에 따른 할인 적용
 */
public class PeriodCondition implements DiscountCondition {
    // 조건에 적용할 요일
    private DayOfWeek dayOfWeek; // 월요일 = 1, 일요일 = 7
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                !startTime.isAfter(screening.getStartTime().toLocalTime()) &&
                !endTime.isBefore(screening.getStartTime().toLocalTime());
    }
}
