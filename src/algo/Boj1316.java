// 그룹단어체커
package algo;

import java.util.Scanner;

public class Boj1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 0;
		
		while((T--)>0) {

			String s = sc.next();
			boolean[] chk = new boolean[26]; // 알파벳 나왔었는지 체크 용도
			boolean chk2 = true; // 그룹단어 체크 용도
			
			for (int i = 0; i < s.length(); i++) 
			{
				int n = s.charAt(i) - 'a';
				
				if (chk[n]) 
				{
					if (!(s.charAt(i - 1) == s.charAt(i))) 
					{
						chk2 = false;
						break;
					}
				} 
				else{
					chk[n] = true;	
				}
			}
			if(chk2) cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
