package longest_common_subsequence;

import java.util.*;

public class Main {

    public static int lcs(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == t.charAt(0)) {
            return 1 + lcs(s.substring(1), t.substring(1));
        } else {
            int lc1 = lcs(s.substring(1), t);
            int lc2 = lcs(s, t.substring(1));

            return Math.max(lc1, lc2);
        }
    }

    public static int lcs2(String s, String t, int[][] ans) {
        int m = s.length();
        int n = t.length();

        if (ans[m][n] != -1) {
            return ans[m][n];
        }

        if (m == 0 || n == 0) {
            ans[m][n] = 0;
        }

        if (s.charAt(0) == t.charAt(0)) {
            ans[m][n] = 1 + lcs2(s.substring(1), t.substring(1), ans);
        } else {
            int lc1 = lcs2(s.substring(1), t, ans);
            int lc2 = lcs2(s, t.substring(1), ans);

            ans[m][n] = Math.max(lc1, lc2);
        }

        return ans[m][n];
    }

    public static int lcs2(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return 0;

        int ans[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 0; j <= t.length(); ++j) {
                ans[i][j] = -1;
            }
        }
        return lcs2(s, t, ans);

    }

    public static int lcs3(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] ans = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            ans[i][0] = 0;
        }

        for (int i = 0; i <= n; ++i) {
            ans[0][i] = 0;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(m - i) == t.charAt(n - j)) {
                    ans[i][j] = 1 + ans[i - 1][j - 1];
                } else {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]);
                }
            }
        }

        return ans[m][n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();
        String t = scn.nextLine();

        System.out.print(lcs(s, t));
        scn.close();

    }

}
