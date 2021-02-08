package algo4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_D3 {
	static int N, M, result;
	static int pick[];
	static int snack[];

	static void picking(int n, int m) {
		if (n == 2) {
			int sum = 0;
			for(int i = 0; i<2; i++) {
				sum += pick[i];
				
			}
			if(!(sum > M)) {

				result = Math.max(result, sum);
					
			}
			return;
		}

		for (int i = m; i < N; i++) {
			pick[n] = snack[i];
			picking(n+1, i+1);
			
			

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			pick = new int[2];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			result = -1;
			picking(0, 0);

			sb.append("#").append(Tcnt++).append(" ").append(result + "\n");
		}
		

		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
