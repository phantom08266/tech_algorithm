package com.company.array;

import java.util.Arrays;

/**
 * 배열을 바라보는 기본적인 시각을 기를 수 있다. [0,5,0,7,6,3] => [5,7,6,3,0,0] 즉 0을 맨뒤로 보내고 사이에있는 숫자는 순서를 깨트리면 안된다.
 * <p>
 * 이 문제는 0을 기준으로 생각해보자. 그럼 0을 뒤로 보낼려면 무조건 bubble swap을 해야한다. 그러면 너무많은 operation이 발생한다. 그래서 0이아닌 숫자를
 * 기준으로 0과 swap을 한다는 개념으로 생각하면 된다.
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Arrays.stream(nums).forEach(System.out::println);
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        // i는 0이 아닌 숫자를 찾는다.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
       int temp = nums[a];
       nums[a]= nums[b];
       nums[b] = temp;
    }
}
