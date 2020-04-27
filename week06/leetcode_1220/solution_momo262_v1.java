package leetcode_1220;

public class solution_momo262_v1 {

    int mod = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for (int j=1;j<n;j++) {
            int currentA = ((e + i )%mod + u)%mod;
            int currentE = (a + i )%mod;
            int currentI = (e + o )%mod;
            int currentO = i;
            int currentU = (i + o)%mod;
            a = currentA;
            e = currentE;
            i = currentI;
            o = currentO;
            u = currentU;
        }
        return ((((a + e)%mod + i)%mod + o)%mod + u)%mod;
    }

}
