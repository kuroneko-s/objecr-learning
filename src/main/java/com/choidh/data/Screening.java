package com.choidh.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return movie.isDiscountable(whenScreened, sequence) ?
                        movie.calculateAmountDiscountedFee().times(audienceCount) :
                        Money.ZERO;
            case PERCENT_DISCOUNT:
                return movie.isDiscountable(whenScreened, sequence) ?
                        movie.calculatePercentDiscount().times(audienceCount) :
                        Money.ZERO;
            case NONE_DISCOUNT:
                return movie.calculateNoneDiscountAmount().times(audienceCount);
            default:
                throw new IllegalArgumentException("Movie type not supported");
        }
    }
}
