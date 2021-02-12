package algo5;
import java.util.Scanner;

public class Boj1107 {
	static boolean[] numChk;
	static int[] pick;
	static int result, N, size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		size = S.length();
		N = Integer.valueOf(S);
		numChk = new boolean[10];
		pick = new int[size + 1];
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {

			numChk[sc.nextInt()] = true;
		}
		result = Math.abs(N - 100);
		for (int i = 1; i <= size + 1; i++) {
			dfs(0, i);
		}
		System.out.println(result);
		sc.close();

	}

	static void dfs(int n, int end) {
		if (n == end) {
			String S = "";

			for (int i = 0; i < end; i++) {
				S = S + pick[i];
			}
			int num = Integer.valueOf(S);
			int size = Integer.toString(num).length();
			result = Math.min(result, (size + Math.abs(N - num)));
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (numChk[i])
				continue;
			pick[n] = i;
			dfs(n + 1, end);

		}
	}

}
