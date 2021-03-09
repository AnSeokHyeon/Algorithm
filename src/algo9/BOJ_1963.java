package algo9;
// 1963 소수경로
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
	public static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int p = 10000;
		make_prime(p); // 소수이면 FALSE 아니면 true

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int min[] = new int[10000];
			Arrays.fill(min, Integer.MAX_VALUE);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Queue<Point> q = new LinkedList<>();
			q.add(new Point(start, 0));
			min[start] = 0;

			while (!q.isEmpty()) {
				Point point = q.poll();
				int num = point.x;
				int d =  point.y;
				String s = String.valueOf(num);
				for(int i = 0; i<4; i++) {
					int number = s.charAt(i)-'0';
					int numTemp = num - number*(int)Math.pow(10, 3-i); 
					for(int j = 0; j<10; j++) {
						if(i == 0 && j == 0) continue;
						if(number == j) continue;
						int nextNum = numTemp + j*(int)Math.pow(10, 3-i);
						int md = d + 1;
						if(prime[nextNum]) continue;
						if(md >= min[nextNum]) continue;
						min[nextNum] = md;
						q.add(new Point(nextNum, md ));
					}
				}
			}
			int result = min[end];
			if(result == Integer.MAX_VALUE) sb.append("Impossible\n");
			else sb.append(result+"\n");
		}
		bw.write(sb.toString());
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