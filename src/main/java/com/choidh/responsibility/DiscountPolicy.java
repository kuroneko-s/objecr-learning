package com.choidh.responsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가격 할인 정책
 */

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditionList = new ArrayList<>();

    // 할인 규칙들을 받아옴
    public DiscountPolicy(DiscountCondition... discountConditions) {
        this.conditionList = Arrays.asList(discountConditions);
    }

    // 할인 요금 반환
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition discountCondition : conditionList) {
            // 할인 조건에 해당하는지
            if (discountCondition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    // 할인 요금 계산
    abstract protected Money getDiscountAmount(Screening screening);
}
