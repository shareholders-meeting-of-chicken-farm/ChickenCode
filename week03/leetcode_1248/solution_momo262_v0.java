package leetcode_1248;

public class solution_momo262_v0 {

    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int start = 0;
        int end = 0;
        int current = 0;

        for (int i=0;i<nums.length;i++) {
            nums[i] = nums[i]%2;
        }

       for (int i=start;i<nums.length;i++) {
           boolean hasResult = false;

           for (int j=end;j<nums.length;j++) {
               current = current + nums[j];
               if (current < k) {
                   end++;
               }
               else if (current == k) {
                   result++;
                   hasResult = true;
               }
               else if (current > k) {
                   current = current - 1;
                   break;
               }
           }

           if (!hasResult) {
               return result;
           }
           current = current - nums[i] - 1;
       }
       return result;
    }

}
