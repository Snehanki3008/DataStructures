import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumPairs {

    public static List<List<Integer>> findSumPairs(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order
        List<List<Integer>> result = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));

                // Skip duplicates
                while (left < right && nums[left] == nums[left + 1])
                    left++;
                while (left < right && nums[right] == nums[right - 1])
                    right--;

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        int targetSum = 0;
        List<List<Integer>> pairs = findSumPairs(nums, targetSum);

        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
