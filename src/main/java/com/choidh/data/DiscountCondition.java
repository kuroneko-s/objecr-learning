package com.choidh.data;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException("Type is not PERIOD");
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                !this.startTime.isAfter(time) &&
                !this.endTime.isBefore(time);
    }

    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException("Type is not SEQUENCE");
        }

        return this.sequence == sequence;
    }
}
