package algo12;

// 1818 책정리

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1818 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int num[] = new int[N + 1];
		int lis[] = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 1; i <= N; i++) {
			int point = Arrays.binarySearch(lis, 0, size, num[i]);

			point = Math.abs(point) - 1;

			lis[point] = num[i];

			if (point == size)
				size++;

		}


		bw.write((N-size)+"\n");
		bw.close();
		br.close();

	}
}