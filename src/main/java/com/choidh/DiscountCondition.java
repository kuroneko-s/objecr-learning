package com.choidh;

public interface DiscountCondition {
    // 할인 조건에 해당하는지 검증
    boolean isSatisfiedBy(Screening screening);
}
