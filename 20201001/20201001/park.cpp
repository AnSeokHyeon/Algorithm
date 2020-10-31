// [19236] 청소년 상어.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <algorithm>

using namespace std;

typedef struct Shark {
	int x, y, dir;
}S;
typedef struct Fish {
	int x, y, dir;
	bool dead;
}F;

S s;
F f[17];

pair<int, int> board[5][5]; //번호와 방향이 저장
int ans = -1;
int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

void fish() {
	//낮은 번호부터 옮기자
	cout << " 옮기는 중 " << endl;

	cout << " 이동 전 상황 ~!@#!@#@!#@!#@!#@!#@!#!@ " << endl;
	for (int k = 1; k <= 4; k++) {
		for (int j = 1; j <= 4; j++) {
			cout << board[k][j].first << ' ';
		}
		cout << endl;
	}
	for (int i = 1; i <= 16; i++) {
		if (f[i].dead) continue;

		int x = f[i].x;
		int y = f[i].y;
		int dir = f[i].dir;

		for (int k = dir; k < dir + 8; k++) {
			//이동할 수 없는 경우 고려할 필요 없음
			k = k % 8;
			if (k == 0)
				k = 8;

			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 1 || nx> 4 || ny < 1 || ny> 4) continue;   // 경계 넘는 경우
			if (board[nx][ny].first == -1) continue;   // 상어 있는 경우
			//물고기가 있으면
			if (board[nx][ny].first > 0) {
				pair<int, int> change = board[nx][ny];
				board[nx][ny] = { i, k };
				f[i] = { nx, ny, k, false };

				board[x][y] = change;
				f[change.first] = { x, y, change.second, false };
				break;
			}
			//빈칸이면
			else if (board[nx][ny].first == 0) {
				board[nx][ny] = { i, k };
				f[i] = { nx, ny, k ,false };

				board[x][y] = { 0, 0 };
				break;
			}
		}
		cout << i <<"  : "  << " 이동 현황 " << endl;
		for (int k = 1; k <= 4; k++) {
			for (int j = 1; j <= 4; j++) {
				cout << board[k][j].first << ' ';
			}
			cout << endl;
		}
	}
}

void dfs(int feed) {

	//물고기 한번 이동
	fish();

	// 기존 board 저장
	pair<int, int> t_board[5][5];
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			t_board[i][j] = board[i][j];
		}
	}

	//기존 상어 위치, 방향
	int x = s.x;
	int y = s.y;
	int dir = s.dir;

	//방향대로 이동
	for (int k = 1; k <= 3; k++) {
		int nx = s.x + k * dx[s.dir];
		int ny = s.y + k * dy[s.dir];

		//경계범위 넘어가면
		if (nx < 1 || nx>4 || ny < 1 || ny>4) continue;
		if (board[nx][ny].first <= 0) continue; //물고기가 없으면

		//cout << "기존방향: " << s.dir << endl;

		//for (int i = 1; i <= 4; i++) {
		//    for (int j = 1; j <= 4; j++) {
		//        cout << board[i][j].first << ' ';
		//    }
		//    cout << endl;
		//}

		//물고기가 있을때 먹고 위치 최신화하자
		s.x = nx;
		s.y = ny;
		s.dir = board[nx][ny].second;
		int t = board[nx][ny].first;

		f[t].dead = true; //물고기 죽이기
		board[nx][ny] = { -1, s.dir };
		board[x][y] = { 0, 0 };


		/*  cout << t + feed << endl;
		  cout << "바꾼 방향: " << s.dir << endl;
		  for (int i = 1; i <= 4; i++) {
			  for (int j = 1; j <= 4; j++) {
				  cout << board[i][j].first << ' ';
			  }
			  cout << endl;
		  }*/

		  // 기존 먹이 + t
		dfs(feed + t);

		s.x = x;
		s.y = y;
		s.dir = dir;
		f[t].dead = false;

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				board[i][j] = t_board[i][j];
			}
		}
	}

	cout << "최종feed" << feed << endl;
	ans = max(ans, feed);
}

int main()
{
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			int t_n, t_dir;
			cin >> t_n >> t_dir;
			board[i][j] = { t_n, t_dir };
			f[t_n] = { i, j, t_dir, false };
		}
	}
	int now_feed = 0;

	// 상어 출현~!
	f[board[1][1].first].dead = true;
	now_feed += board[1][1].first;

	s = { 1, 1, board[1][1].second };
	board[1][1].first = -1;
	board[1][1].second = s.dir;

	dfs(now_feed);

	cout << ans;
}