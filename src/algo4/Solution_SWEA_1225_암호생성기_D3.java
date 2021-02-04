package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Test = 10;
		StringBuilder sb = new StringBuilder();

		while (Test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(N).append(" ");
			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Integer> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			while (st.hasMoreTokens()) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int cycle = 1;
			while (!q.isEmpty()) {
				int a = q.poll();
				a = a - (cycle++);
				if (a < 1) {
					q.add(0);
					break;
				}
				q.add(a);
				if (cycle > 5)
					cycle = 1;
			}

			while (!q.isEmpty()) {
				sb.append(q.poll() + " ");
			}
			
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
