package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Quick {

	static int N = 0;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	static void quickSort(int first, int last) {
		int temp;
		if (first < last) {
			int pivot = first;
			int i = first;
			int j = last;

			while (i < j) {
				while (num[i] <= num[pivot] && i < last) {
					i++;
				}
				while (num[j] > num[pivot]) {
					j--;
				}
				if (i < j) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}

			temp = num[pivot];
			num[pivot] = num[j];
			num[j] = temp;

			quickSort(first, j - 1);
			quickSort(j + 1, last);
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
		for(int i = 0; i<N;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		System.out.println("입력 끝 시작");
		long beforeTime = System.currentTimeMillis(); 
		quickSort(0, N - 1);

		long afterTime = System.currentTimeMillis();		
		long secDiffTime = (afterTime - beforeTime);
		printResult();
		
		bw.write(sb.toString());
		bw.write("시간차이 : " + secDiffTime + "ms");
		bw.close();
		br.close();
	}
}