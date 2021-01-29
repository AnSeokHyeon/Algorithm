// 수 정렬하기 2
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj2751 {
	/* Arrays.sort() 함수를 이용 => 32%에서 시간초과
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] array = new int[N];
		for(int i = 0; i<N;i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		for(int i = 0; i<N;i++) {
			sb.append(array[i] + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	*/
	/* Quick Sort 사용 -> 71% 시간초과
	static int partition(int[] array, int start, int end) {
		int pivot = array[(start + end) / 2];
		while (start <= end) {
			while (array[start] < pivot)
				start++;
			while (array[end] > pivot)
				end--;
			if (start <= end) {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
				start++;
				end--;
			}
		}
		return start;
	}

	static int[] quickSort(int[] array, int start, int end) {
		int p = partition(array, start, end);
		if (start < p - 1)
			quickSort(array, start, p - 1);
		if (p < end)
			quickSort(array, p, end);
		return array;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] array = new int[N];
		for(int i = 0; i<N;i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		
		array = quickSort(array, 0, array.length - 1);

		for(int i = 0; i<N;i++) {
			bw.write(String.valueOf(array[i])+"\n");
		}
		bw.close();
		br.close();
	}
	*/
	// 카운팅 소트 이용 => 맞음
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] count = new int[2000001];
		
		for(int i = 0; i<n;i++) {
			count[Integer.parseInt(br.readLine())+1000000]++;
		}	

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<2000001;i++) {
			while(count[i] > 0)
			{
				sb.append(i-1000000).append('\n');
				count[i]--;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
