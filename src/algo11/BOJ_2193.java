package algo11;

// 2193 이친수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[N+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i<=N; i++) {
			
			dp[i] = dp[i-1]+ dp[i-2];
		}
		
		
		bw.write(dp[N]+"");
		br.close();
		bw.close();
	}

}