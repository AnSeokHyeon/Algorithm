package algo9;
// 11050 이항계수 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int dp[][] = new int[n+1][n+1];
 		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<=r; j++) {
				if(i == j || j == 0) dp[i][j] = 1;
				else {
					dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%10007;
				}
				
			}
		}
		
		bw.write(dp[n][r] + "");
		br.close();
		bw.close();
	}

}