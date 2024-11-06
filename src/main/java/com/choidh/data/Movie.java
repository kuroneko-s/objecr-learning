package com.choidh.data;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;

    private List<DiscountCondition> discountConditions;
    private MovieType movieType;
    private Money discounyAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public Money getDiscounyAmount() {
        return discounyAmount;
    }

    public void setDiscounyAmount(Money discounyAmount) {
        this.discounyAmount = discounyAmount;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
