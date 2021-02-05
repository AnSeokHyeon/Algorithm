
	// 3499. 퍼펙트 셔플 D3package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Test = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();

		while (Test-- > 0) {
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String[] S = new String[size];
			for (int i = 0; i < size; i++) {
				S[i] = st.nextToken();
			}
			int limit = 0;
			if (size % 2 == 1) {
				limit = size / 2 + 1;
			} else {
				limit = size / 2;
			}
			sb.append("#").append(Tcnt++).append(" ");
			for (int i = 0; i < limit; i++) {
				sb.append(S[i] + " ");
				if (i + limit < size)
					sb.append(S[i + limit] + " ");
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
