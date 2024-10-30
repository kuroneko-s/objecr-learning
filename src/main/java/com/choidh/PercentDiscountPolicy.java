package com.choidh;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        /**
         * 퍼센트로 까주는거는 얼마 까줘야하는지를 알아야하니깐
         * Movie에 가격을 가져와서 거기에 퍼센트로 조져서
         * 할인 해줘야하는 금액을 계산한다음 넘겨주는건데
         */
        return screening.getMovieFee().times(percent);
    }
}
