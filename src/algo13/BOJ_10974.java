package algo13;

// 10974 모든 순열
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10974 {
	static StringBuilder sb ;
	static int N;
	static int pick[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		pick = new int[N];
		dfs(0,0);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	private static void dfs(int n, int flag) {
		if(n == N) {
			
			for(int i = 0; i<N;i++) {
				sb.append(pick[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if((flag & 1 << i) > 0) continue;
			pick[n] = i + 1;
			dfs(n + 1, flag | 1 << i);
		}
	}
}