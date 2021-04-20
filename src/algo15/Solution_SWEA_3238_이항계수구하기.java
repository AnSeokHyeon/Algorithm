package algo15;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_3238_이항계수구하기 {
	static int NUM = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			NUM = Integer.parseInt(st.nextToken());

			long fact[] = new long[NUM + 1];
			
			fact[0] = 1;
			
			for(int i = 1; i< NUM; i++) {
				fact[i] = (fact[i-1] * i) % NUM;
			}
			
			long result = 1;
			while(N > 0 || K > 0) {
				
				long a = N % NUM, b = K %NUM;
				if(a < b) result = 0;
				if(result == 0) break;
				result *= fact[(int) a];
				result %= NUM;
				result *= pow((fact[(int) b] * fact[(int) (a-b)]) %NUM, NUM-2);
				result %= NUM;
				N/=NUM; 
				K/=NUM;
			}
			sb.append("#" + (Tcnt++) + " " + result + "\n");
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