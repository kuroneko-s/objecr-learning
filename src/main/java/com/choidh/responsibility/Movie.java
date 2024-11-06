package com.choidh.responsibility;

import java.time.Duration;

public class Movie {
    private String title; // 영화 제목
    private Duration duration; // 영화 상영 일시
    private Money fee; // 영화 가격
    private DiscountPolicy discountPolicy; // 영화의 가격 할인 정책

    public Movie(String title, Duration duration, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
