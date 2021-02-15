package algo6;

// 6808. 규영이와 인영이의 카드게임
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임_안석현 {
	static boolean chkCard[];
	static int A[];
	static int B[];
	static int win, lose;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		A = new int[9];
		B = new int[9];
		chkCard = new boolean[19];
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int idx = 0;
			win = lose = 0;
			Arrays.fill(chkCard, false);
			while (st.hasMoreTokens()) {
				A[idx] = Integer.parseInt(st.nextToken());
				chkCard[A[idx++]] = true;
			}
			cardGame(0);

			sb.append("#" + (Tcnt++) + " " + win + " " + lose + "\n");

		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	static void cardGame(int n) {
		if (n == 9) {
			int a = 0;
			int b = 0;
			int total = 0;
			for (int i = 0; i < 9; i++) {
				total = A[i] + B[i];
				if (A[i] > B[i]) {
					a += total;
				} else if (A[i] < B[i]) {
					b += total;
				}

			}
			if (a > b)
				win++;
			else if (b > a)
				lose++;
			return;
		}

		for (int i = 1; i < 19; i++) {
			if (chkCard[i])
				continue;
			B[n] = i;
			chkCard[i] = true;
			cardGame(n + 1);
			chkCard[i] = false;

		}

	}
}