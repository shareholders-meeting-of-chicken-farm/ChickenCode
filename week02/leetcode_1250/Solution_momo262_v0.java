package leetcode_1250;

/*
   1.suppose two numbers:x and y,with their gcd n.we have ax + by = n * (ax/n + by/n)
     for x/n and y/n are relatively prime,there exists a&b,so that ax/n + by/n = 1
     so we can have conclusion:ax + by = gcd(x,y) has solution

   2.in the array,if two numbers are relatively prime,the sum themselves can be 1,return true
     otherwise,with sum(x,y,a,b) = gcd(x,y)*k,we choose k=1,and get gcd(x,y) as newNumber,to compare to next number in array
     among all possible sum,gcd(x,y) is most likely to be relatively prime with next number
     reason1:k can be 1 based on the conclusion above,other values are not sure
     reason2:if gcd(x,y)*k is relatively prime to next number z,gcd(x,y) must also be the same，
             but gcd(gcd(x,y),z) = 1 can not prove gcd(gcd(x,y)*k,z) = 1
 */
public class Solution_momo262_v0 {

    public boolean isGoodArray(int[] nums) {
        int currentGcd = nums[0];
        //special condition
        if (nums.length == 1) {
            return currentGcd == 1;
        }

        for (int i=1;i<nums.length;i++) {
            int gcd = gcd(currentGcd,nums[i]);
            //if two numbers are relatively prime,
            if (gcd == 1) {
                return true;
            } else {
                currentGcd = gcd;
            }
        }
        return false;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

}
