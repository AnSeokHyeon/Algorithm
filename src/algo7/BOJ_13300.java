package algo7;

// 13300 방배정
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer; // 입력을 쪼개서 받으려고 임포트

public class BOJ_13300 { // 클래스명 Boj13300

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 학생수와 방 최대 인원 수 입력 쪼개서 받기
		int N = Integer.parseInt(st.nextToken()); // 학생 수 N 입력
		int K = Integer.parseInt(st.nextToken()); // 한 방에 배정 될 수 있는 최대 인원수 입력
		int boy[] = new int[7]; // 1학년부터 6학년까지 소년 배열
		int girl[] = new int[7]; // 1학년 부터 6학년까지 소녀 배열
		while(N-- > 0) {
			 st = new StringTokenizer(br.readLine(), " "); // 학생의 성별과 학년을 쪼개서 입력 받기 위해 사용
			 int gender = Integer.parseInt(st.nextToken()); // 성별 입력
			 int grade = Integer.parseInt(st.nextToken()); // 학년 입력
			 if(gender == 0) { // 성별이 여성이면
				 girl[grade]++; // 소녀의 학년 한명 늘리기
			 }// 성별이 여성이 아닌
			 else { // 남성이면
				 boy[grade]++; // 소년의 학년 한명 늘리기
			 }// 끝
		} // N만큼 while문 돌기
		int cnt = 0; // 방 갯수 카운트하기
		for(int i = 1; i<7; i++) { // 1학년부터 6학년까지 for문 돌려보기
			int girlrm = girl[i] / K; // 일단 i학년 소녀들의 인원수를 K로 나눠주고
			if(girl[i]%K != 0) girlrm++; // 나머지가 0이아니면 방 1개가 더 필요하므로 ++

			int boyrm = boy[i] / K;  // 일단 i학년 소년들의 인원수를 K로 나눠주고
			if(boy[i]%K != 0) boyrm++; // 나머지가 0이아니면 방 1개가 더 필요하므로 ++
			
			cnt += girlrm + boyrm; // 1학년 소녀들과 소년들의 방의 갯수를 더해준다.
		} // for문 종료
		bw.write(cnt +""); // 결과값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
