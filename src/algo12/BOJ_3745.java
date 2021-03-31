package algo12;

//3745 오름세

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3745 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int num[] = new int[N + 1];
			int line[] = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				num[i] = sc.nextInt();
			}

			int size = 0;
			for (int i = 1; i < N + 1; i++) {
				int point = Arrays.binarySearch(line, 0, size, num[i]);
				if (point >= 0)
					continue;
				point = Math.abs(point) - 1;
				line[point] = num[i];

				if (size == point)
					size++;

			}
			System.out.println(size);
		}
		sc.close();
		bw.close();
		br.close();

	}
}