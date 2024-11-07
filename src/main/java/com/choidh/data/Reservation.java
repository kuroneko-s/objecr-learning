package com.choidh.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money money;
    private int audienceCount;
}
