package com.company.array;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 슬라이딩 문제
 * <p>
 * 피벗을 기준으로 좌우 합이 동일값이 나오는 피벗의 인덱스를 찾는 문제 [1,8,2,9,2,3,6] 일때 9를 기준으로 좌우 합이 11이다. 이때 9의 인덱스 3을 리턴하면됨
 * [2,5,7] 은 없으므로 -1을 리턴한다.
 * <p>
 * 부르트포스 방식으로 하면 O(N 2의제곱) 시간 복잡도가 발생한다.
 */
public class FindPivotIndex {


    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));

    }

    public static int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int rightSum = sum;
        int pastPivot = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            leftSum += pastPivot;
            if (leftSum == rightSum){
                return i;
            }
            pastPivot = nums[i];
        }
        return -1;
    }

}
