package algo12;

//11502 카드 구매하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11502 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<N+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		long dp[] = new long[N+1];
		for(int i = 1; i<N+1; i++) {
			int money = num[i];
			for(int j = i; j<N+1; j++) {
				dp[j] = Math.max(dp[j], dp[j-i] + money);
			}
		}
		
		
		bw.write(dp[N]+ "");
		bw.close();
		br.close();

	}
}