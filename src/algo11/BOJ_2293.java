package algo11;

// 2293 동전 1
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[N+1];
		for(int i = 0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int dp[] = new int[M+1];
		dp[0] = 1;
		for(int i = 0; i<N; i++) {
			int num = coin[i];
			for(int j = num; j <= M; j++ ) {
				dp[j] = dp[j] + dp[j-num];
			}
			
		}
		
		bw.write(dp[M]+"");
		br.close();
		bw.close();
	}

}