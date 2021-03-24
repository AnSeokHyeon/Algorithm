package algo11;

// 2579 계딘 오르기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int stair[] = new int[N+2];
		int dp[] = new int[N+2];
		for(int i = 2; i<=N+1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = stair[0];
		dp[1] = stair[1];
		dp[2] = stair[2]; 
		for(int i = 3; i<=N+1; i++) {
			
			dp[i] = Math.max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
		}
		
		
		bw.write(dp[N+1]+"");
		br.close();
		bw.close();
	}

}