// 소수의 부분합
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1644 {
	public static boolean[] prime;
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int p = 5000000;
		make_prime(p);
		int idx = 0;
		arr = new int[348513];
		for (int i = 0; i < p; i++) {
			if (!prime[i + 1]) {
				arr[idx++] = i + 1;

			}
		}

		N = Integer.parseInt(br.readLine());
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while (true) {
			if (sum < N) {
				sum += arr[end++];
			} else if (sum == N) {
				sum += arr[end++];
				cnt++;
			} else {
				sum -= arr[start++];
			}
			if (arr[end - 1] > N)
				break;

		}
		bw.write(cnt + "");

		br.close();
		bw.close();
	}

	public static void make_prime(int p) {

		prime = new boolean[p + 1];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (prime[i] == true) {
				continue;
			}

			for (int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}

	}

}