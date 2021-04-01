package algo12;

// 11727 2xN 타일링 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11727 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+2];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i<N+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
		
		bw.write(dp[N] + "");
		bw.close();
		br.close();

	}
}