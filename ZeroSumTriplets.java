import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroSumTriplets {

    public static List<List<Integer>> findTriplets(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // Skip duplicates
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];

                while (left < right) {
                    int sum = nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

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
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> triplets = findTriplets(nums);

        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}