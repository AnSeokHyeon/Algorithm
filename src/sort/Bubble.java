package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Bubble {
	static int N = 0;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("정렬 시작");
		long beforeTime = System.currentTimeMillis(); 
		/*
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				if (num[j] > num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
		*/
		Arrays.sort(num);
		
			
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);

		System.out.println("정렬 종료");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {

			sb.append(num[i] + "\n");
		}
		bw.write(sb.toString());
		bw.write("시간차이 : " + secDiffTime + "ms");
		bw.close();
		br.close();

	}
}