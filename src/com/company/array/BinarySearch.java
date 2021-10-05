package com.company.array;

/**
 * 배열에는 sort문제가 많이 나온다. 시간복잡도는 O(NlogN) 이며 대표적으로 quick sort가 있다.
 * <p>
 * sort알고리즘에는 stable, unstable이 있다. stable : merge sort unstable : quick sort, heap sort
 * <p>
 * stable : 이미 정렬된 순서를 깨트리지않고 정렬을 시킨다. unstable : 이미 정렬된 순서가 깨질 수 있다.
 * <p>
 * search는 시간복잡도가 O(N)이며, 만약 정렬된 배열이라면 binary search를 사용가능하다. 이땐 O(logN)의 시간복잡도가 발생한다.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6, 7, 15, 20};
        System.out.println("target 인덱스 : " + search(nums, 15));
        System.out.println("target 인덱스 : " + search(nums, 16));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (target > nums[pivot]) {
                left = pivot + 1;
            } else if (target < nums[pivot]) {
                right = right - 1;
            } else if (target == nums[pivot]) {
                return pivot;
            }
        }

        return -1;
    }


}
