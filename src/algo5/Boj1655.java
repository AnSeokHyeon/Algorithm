package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		PriorityQueue<Integer> big = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub

				return o1 - o2;
			}
		});
		
		
		small.add(-100000);
		big.add(100000);
		for (int i = 0; i < N; i++) {

			int n = Integer.parseInt(br.readLine());
			
			if(small.size() == big.size()) {
				if(n > big.peek()) {
					small.add(big.poll());
					big.add(n);
				}
				else {
					small.add(n);
				}
				
			}
			else {
				if(n > small.peek()) {
					big.add(n);
				}
				
				else {
					big.add(small.poll());
					small.add(n);
				}
				
			}
			sb.append(small.peek() + "\n");
			
		}

		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
