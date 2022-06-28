package leetcode;

public class S2261_S_TAKEN {
    public static void main(String[] args) {
        System.out.println(new S2261_S_TAKEN().countDistinct(new int[]{173, 21, 127, 154, 93, 44, 130, 102, 186, 200, 197, 29,
                85, 13, 16, 179, 34, 156, 128, 60, 2, 1, 11, 116, 174, 52, 185, 154, 127, 155, 24, 59, 103}, 15, 113));
    }

    //take two fast solutions from leetcode, update it
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int[] dc = new int[n+1];
        int c=0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % p == 0) c++;
            dc[i + 1] = c;
        }
        int[] pref = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int q = 0;
                while (j+q < n && nums[i+q] == nums[j+q] && dc[i+q+1]-dc[i]<=k)
                    q++;
                pref[j] = Math.max(pref[j], q);
            }
        }

        int[] suf = new int[nums.length];
        for(int i = n-1, j = n - 1; i >= 0; i--){
            k -= nums[i] % p == 0?1:0;
            while(k < 0) {k += nums[j--] % p == 0?1:0;}
            suf[i] = j+1-i;
        }

        int res = 0;
        for (int i = 0; i < suf.length; i++) {
            res+=suf[i]-pref[i];
        }

        return res;
    }
}
