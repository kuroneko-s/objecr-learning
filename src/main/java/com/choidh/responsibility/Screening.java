package com.choidh.responsibility;

import java.time.LocalDateTime;

public class Screening {
    private int sequence;
    private LocalDateTime startTime;
    private Movie movie;

    public boolean isSequence(int sequence) {
        return sequence == this.sequence;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    // 예매
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    // 요금 계산
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
