import java.util.HashMap;

public class Q1TwoSum {

    public static void main(String[] args) {

    }

    //这个故事告诉我们，在需要搜索的时候一定要考虑一下hashmap。
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[] {nums[i], map.get(gap)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
