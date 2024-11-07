package com.choidh.data;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;

    private List<DiscountCondition> discountConditions;
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                return condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime());
            } else {
                return condition.isDiscountable(sequence);
            }
        }

        return false;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException("Movie type is not AMOUNT_DISCOUNT");
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscount() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException("Movie type is not PERCENT_DISCOUNT");
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountAmount() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException("Movie type is not NONE_DISCOUNT");
        }

        return fee;
    }
}
