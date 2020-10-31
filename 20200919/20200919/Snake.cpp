#include <iostream>

using namespace std;

struct pos {
	int x;
	int y;
	pos() {
		this->x = 1;
		this->y = 1;
	}
};

pos snake[10001];

int map[101][101];
int dy[] = { 1,0,-1,0 };
int dx[] = { 0,1,0,-1 };
int turn[10001] = { 0 };
 

int main(void) {
	int N;
	cin >> N;
	int apple;
	cin >> apple;
	for (int i = 0; i < apple; i++) {
		int x;
		int y;
		cin >> x >> y;
		map[x][y] = 2;
	}
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int n;
		char d;
		cin >> n >> d;
		if (d == 'D') turn[n] = 1;
		if (d == 'L') turn[n] = -1;
	}
	int t = 0;
	int dir = 0;
	int len = 1;
	map[snake[1].x][snake[1].y] = 1;
	while (1) {
		if (turn[t] != 0) {
			dir = dir + turn[t];
			if (dir < 0) dir = dir + 4;
			if (dir > 3) dir = dir % 4;
		}

		int mx = snake[1].x + dx[dir];
		int my = snake[1].y + dy[dir];

		if (mx < 1 || my < 1 || mx > N || my > N) break;
		if (map[mx][my] == 1) break;
		
		int tempx = snake[len].x;
		int tempy = snake[len].y;

		for (int i = len; i > 1; i--) {
			snake[i].x = snake[i-1].x;
			snake[i].y = snake[i - 1].y;
		}
		snake[1].x = mx;
		snake[1].y = my;

		if (map[mx][my] == 2) {
			len++;
			snake[len].x = tempx;
			snake[len].y = tempy;
		}
		else {
			map[tempx][tempy] = 0;
		}

		map[mx][my] = 1;
		t++;
		//cout << " Áö··ÀÌ@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
	}
	cout << t  +1 << endl;
}