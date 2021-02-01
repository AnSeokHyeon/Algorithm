package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Counting {

	static final int MAX_N = 1000000;
	static final int MAX_DIGIT = 1000000;

	static int N; // # of data set
	static int arr[];
	static int cnt[] = new int[MAX_DIGIT];
	static int sortedArr[];

	static StringBuilder sb = new StringBuilder();

	static void calculateDigitNumber() {
		for (int i = 0; i < N; i++) {
			cnt[arr[i]]++;
		}

		for (int i = 1; i < MAX_DIGIT; i++) {
			cnt[i] = cnt[i - 1] + cnt[i];
		}
	}

	static void executeCountingSort() {
		for (int i = N - 1; i >= 0; i--) {
			sortedArr[--cnt[arr[i]]] = arr[i];
		}
	}
	static void printResult() {
		for (int i = 0; i < N; i++) {
			
			sb.append(sortedArr[i] + "\n");
		}
	}


	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		sortedArr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// initialize
		for (int i = 1; i < MAX_DIGIT; i++) {
			cnt[i] = 0;
		}
		long beforeTime = System.currentTimeMillis();

		calculateDigitNumber();
		executeCountingSort();

		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		// print the sorted digits
		bw.write(sb.toString());
		bw.write("시간차이 : " + secDiffTime + "ms");
		bw.close();
		br.close();
	}
}