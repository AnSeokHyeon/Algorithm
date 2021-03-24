package algo11;

// 1463 1로 만들기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 1; i <= N; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] +1 , dp[i]);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i/2] +1, dp[i]);
			}
			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
		}

		bw.write(dp[N] + "");
		br.close();
		bw.close();
	}

}