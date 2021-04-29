package algo16;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10451 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			int num[] = new int[N + 1];
			boolean chk[] = new boolean[N + 1];
			int result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int idx = 1;
			while(st.hasMoreTokens()) {
				num[idx++] = Integer.parseInt(st.nextToken());
			}

			Queue<Integer> q = new LinkedList<>();

			for (int i = 1; i < N + 1; i++) {
				if (chk[i])
					continue;
				result++;
				chk[i] = true;
				q.add(i);

				while (q.size() > 0) {
					int now = q.poll();

					int next = num[now];
					if (chk[next])
						continue;
					chk[next] = true;
					q.add(next);

				}

			}

			sb.append(result + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}