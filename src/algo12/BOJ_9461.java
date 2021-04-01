package algo12;

//9461 파도반 수열

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long dp[] = new long[101];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		for(int i = 5; i<101; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {

			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}