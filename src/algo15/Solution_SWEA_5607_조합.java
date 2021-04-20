package algo15;
// 5607 조합
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_5607_조합 {
	static final long NUM = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		long fact[] = new long[1000001];
		long fact2[] = new long[1000001];
		fact[1] = 1;
		for(int i = 2; i <= 1000000; i++) {
			fact[i] = (fact[i-1] * i) % NUM;
		}
		fact2[1000000] = pow(fact[1000000],  NUM-2);
		for(int i = 1000000-1; i>0; i--) {
			fact2[i] = (fact2[i+1] * (i+1)) % NUM;
		}
		int T= Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			if (N == K || K == 0)
				sb.append("#" + (Tcnt++) + " " + 1 + "\n");
			else {

				long result = (fact[N] * fact2[N - K]) % NUM;
				result = (result * fact2[K]) % NUM;
				sb.append("#" + (Tcnt++) + " " + result + "\n");
			}

		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	private static long pow(long x, long y) {
		long result = 1;
		while( y > 0) {
			if(y %2 == 1) {
				result *= x;
				result %= NUM;
			}
			
			x *= x;
			x %= NUM;
			y /= 2;
		}
		return result;
	}
}