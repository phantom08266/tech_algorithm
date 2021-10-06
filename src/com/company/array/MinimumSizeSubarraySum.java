package com.company.array;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 합이 target보다 크거나 같을때 갯수 최소값
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                result = Math.min(result, i - start  + 1);
                sum -= nums[start];
                start++;
            }

        }
        return result != Integer.MAX_VALUE ? result : 0;
    }
}
