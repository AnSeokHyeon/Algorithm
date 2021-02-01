package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Insertion {

	static int N = 0;
	static int[] num;
	static StringBuilder sb = new StringBuilder();

	static void insertionSort() {
		for (int i = 1; i < N; i++) {
			int temp = num[i];
			int j = i - 1;

			while ((j >= 0) && (temp < num[j])) {
				num[j + 1] = num[j];
				j = j - 1;
			}
			num[j + 1] = temp;
		}
	}

	static void printResult() {
		for (int i = 0; i < N; i++) {
			
			sb.append(num[i] + "\n");
		}
	}


	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		System.out.println("입력 끝 시작");
		long beforeTime = System.currentTimeMillis();
		insertionSort();

		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		printResult();
		bw.write(sb.toString());
		bw.write("시간차이 : " + secDiffTime + "ms");
		bw.close();
		br.close();
	}
}