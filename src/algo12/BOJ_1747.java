package algo12;

//1747소수&팰린드롬
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1747 {

	public static boolean[] prime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = 1005000;
		make_prime(N);
		
		int num = Integer.parseInt(br.readLine())-1;
		
		while(true) {
			num++;
			
			if(prime[num]) continue;
			
			String S = String.valueOf(num);
			int size = S.length();
			boolean chk = true;
		
			for(int i = 0; i < size/2; i++) {
				if(S.charAt(i) != S.charAt(size-1-i)) {
					chk = false;
				}
			}
			
			if(chk) break;
		}
		bw.write(num+"");
		br.close();
		bw.close();
	}

	public static void make_prime(int N) {

		prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (prime[i] == true) {
				continue;
			}

			for (int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}
	}

}