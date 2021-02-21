/*
* 题目：
* 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
* 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
* 你可以按任意顺序返回答案。
*
* 示例：
* 输入：nums = [2,7,11,15], target = 9
* 输出：[0,1]
* 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
*
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int [] solution1 = Solution1(nums, target);
        int[] solution2 = Solution2(nums, target);

        System.out.println(Arrays.toString(solution1));
        System.out.println(Arrays.toString(solution2));


    }

    public static int[] Solution1(int[] nums, int target) {
        // 思路1，暴力法
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] Solution2(int[] nums, int target) {
        // 思路2， 使用Hash表
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }


}
