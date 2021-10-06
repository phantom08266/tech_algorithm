package com.company.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * <p>
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors3(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * Arrays.sort는 기본적으로 quick sort를 기반으로 함으로 O(n log(n))의 시간복잡도가 발생한다.
     *
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * 이를 O(n)의 시간복잡도로 풀어보자 각각의 요소의 갯수를 세어 출력한다.
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else if (zero <= i && i < zero + one) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 위 방법 말고 in-place swap을 통해서 처리해보자 point 0과 2를 만날때 swap left 포인터 왼쪽으론 0만 존재, right 포인터 오른쪽에는 2만
     * 존재
     * <p>
     * for문을 쓰면 인덱스가 자동증가하여 관리가 힘듦. 그래서 while문을 사용하여 필요할때만 증가하도록 함.
     *
     * @param nums
     */
    public static void sortColors3(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }


}
