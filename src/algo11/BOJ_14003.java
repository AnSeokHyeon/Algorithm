package algo11;

//14003 가장 긴 증가하는 부분 수열 5

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		int LIS[] = new int[N];
		int idx[] = new int[N];
		int p[] = new int[N];

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int point = Arrays.binarySearch(LIS, 0, size, num[i]);
			if (point >= 0)
				continue;
			point = Math.abs(point) - 1;

			LIS[point] = num[i];
			idx[point] = i;

			p[i] = (point == 0) ? i : idx[point - 1];

			if (point == size)
				size++;

		}
		sb.append(size + "\n");
		Stack<Integer> stack = new Stack<>();

		int index = idx[size - 1];
		while (true) {
			stack.add(num[index]);
			int preIdx = p[index];
			if (preIdx == index)
				break;
			index = preIdx;
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}