package algo10;

// 3273 두 수의 합
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int threshold = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int left = 0;
		int right = N-1;
		int result = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(threshold == sum) result++;
			if(sum >= threshold) {
				right--;
			}
			else {
				left++;
			}
		}
		
		
		bw.write(result+ "");
		br.close();
		bw.close();
	}

}