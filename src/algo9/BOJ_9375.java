package algo9;

// 9375 패션왕 신해빈
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String s[] = new String[50];
			int cnt[] = new int[50];
			int idx = 0;
			long result = 0;
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				st.nextToken();
				String tempString = st.nextToken();
				boolean same = false;
				for (int i = 0; i < idx; i++) {
					if (s[i].equals(tempString)) {
						same = true;
						cnt[i]++;
						break;
					}
				}
				if (!same) {
					cnt[idx]++;
					s[idx++] = tempString;
				}

			}

			long temp = 1;
			for (int i = 0; i < idx; i++) {
				temp *= (cnt[i] + 1);
			}
			result = temp - 1;

			sb.append(result + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}