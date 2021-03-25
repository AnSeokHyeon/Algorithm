package algo11;

// 1208 부분수열의 합 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1208 {
	static int N, M;
	static int num[];
	static int chk[];
	static HashMap<Integer, Integer> upper = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> lower = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		chk = new int[N];
		down(0, N / 2, 0);
		ArrayList<Integer> lowerKey = new ArrayList<>(lower.keySet());
		ArrayList<Integer> lowerValue = new ArrayList<>(lower.values());
		up(N / 2, N, 0);
		int downSize = lowerKey.size();
		long result = 0;
		if(M == 0) result--;
		for (int i = 0; i < downSize; i++) {
			int sum = M - lowerKey.get(i);
			if(upper.containsKey(sum)) {
				
				result +=  (long)lowerValue.get(i) * upper.get(sum);
			}
		}
		
		bw.write(result + "");
		br.close();
		bw.close();
	}

	private static void up(int i, int j, int sum) {
		// TODO Auto-generated method stub
		if (i == j) {
			if (upper.containsKey(sum)) {
				int cnt = upper.get(sum) + 1;
				upper.put(sum, cnt);
			} else {
				upper.put(sum, 1);
			}
			return;
		}

		for (int a = 0; a < 2; a++) {
			up(i + 1, j, sum + a * num[i]);
		}

	}

	private static void down(int i, int j, int sum) {
		// TODO Auto-generated method stub
		if (i == j) {
				if (lower.containsKey(sum)) {
					int cnt = lower.get(sum) + 1;
					lower.put(sum, cnt);
				} else {
					lower.put(sum, 1);
				}
			return;
		}

		for (int a = 0; a < 2; a++) {
			down(i + 1, j, sum + a * num[i]);
		}
	}

}