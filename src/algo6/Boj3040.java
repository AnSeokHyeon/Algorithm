package algo6;
// 백설 공주와 일곱 난쟁이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj3040 {
	static int dwarf[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = 9;
		dwarf = new int[size];

		for (int i = 0; i < size; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		pick(0, 0, 0, 0);

		bw.write(sb.toString());
		br.close();
		bw.close();

	}

	static void pick(int n, int m, int flag, int sum) {
		if (n == 7) {
			if (sum != 100)
				return;
			for (int i = 0; i < 9; i++) {
				if ((flag & 1 << i) == 0)
					continue;
				sb.append(dwarf[i] + "\n");
			}

			return;
		}

		for (int i = m; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			if (sum + dwarf[i] > 100)
				continue;
			pick(n + 1, i + 1, flag | 1 << i, sum + dwarf[i]);
		}
	}
}