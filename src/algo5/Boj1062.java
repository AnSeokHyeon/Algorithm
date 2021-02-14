// 가르침
package algo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1062 {
	static int result = 0;
	static int N, K;
	static String[] S;
	static boolean[] alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		alpha = new boolean[26]; // 알파벳 체크
		S = new String[N]; // 문자 입력

		int T = 0;
		String s = "antatica"; // anta로 시작하고 tica로 끝나므로 antatica 알파벳 체크
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'a'] = true;
		}
		while (T < N) {
			s = br.readLine();
			s = s.replaceAll("anta", "").replaceAll("tica", "");
			s = s.replace("a", "").replace("i", "").replace("t", "").replace("c", "").replace("n", "");
			// anta 와 tica a, i, t, c, n 모두 공백으로 처리해서 문자열 계산시 좀더 빠르게 하고자 한다.
			S[T++] = s;
		}

		dfs(0, 0);
		bw.write(result + "");
		br.close();
		bw.close();
	}

	static void dfs(int n, int m) {
		if (K < 5) { // 애시당초 a, n, t, c, i로만 이루어져도 5개 이상이여야 하므로 모두 리턴 시킨다.
			return;
		}

		if (m == K - 5) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int size = S[i].length();
				if (size == 0) { // size가 영이라는 것은 anta 혹은 tica 혹은 a, n, t, c, i 로 이루어진것이므로 무조건 ++
					cnt++;

					continue;
				}
				boolean chk = true;
				for (int j = 0; j < size; j++) {
					if (alpha[S[i].charAt(j) - 'a'])
						continue;
					chk = false;
					break;
				}
				if (chk)
					cnt++;
			}
			result = Math.max(result, cnt);
			return;
		}
		for (int i = n; i < 26; i++) {
			if (alpha[i])
				continue;
			alpha[i] = true;
			dfs(i + 1, m + 1);
			alpha[i] = false;

		}

	}
}