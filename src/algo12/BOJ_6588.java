package algo12;

//6588 골드바흐의 추측
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_6588 {
	public static boolean[] prime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> arr = new ArrayList<>();
		make_prime(1000000);
		for (int i = 3; i < 1000001; i++) {
			if (prime[i])
				continue;
			arr.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while (true) {

			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int left = 0;
			int right = Collections.binarySearch(arr, N);
			right = Math.abs(right) -2;
			int lnum = 0, rnum = 0, sum = 0;
			boolean chk = false;
			while (left <= right) {
				lnum = arr.get(left);
				rnum = arr.get(right);
				sum = lnum + rnum;
				if (sum > N) {
					right--;
				} else if (sum < N) {
					left++;

				} else {
					chk = true;
					sb.append(N + " = " + lnum + " + " + rnum + "\n");
					break;
				}
			}

			if (!chk)
				sb.append("Goldbach's conjecture is wrong.\n");

		}
		bw.write(sb.toString());
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