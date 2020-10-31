#include <iostream>
#include <math.h>
using namespace std;
struct position {
	int x;
	int y; 
	int d;
	int g;
	position() {
		this->x = 0;
		this->y = 0;
		this->d = 0;
		this->g = 0;
	}
};

position pos[20];
int map[101][101];
int dir[1024];
int dx[] = {0,-1,0,1};
int dy[] = {1,0,-1,0};
void curving(int n, int m, int x, int y) {
	if (m > pos[n].g) {
		//cout << " 방향 확인 " << endl;
		//for (int i = 0; i < pow(2, m-1); i++) {
		//	cout << dir[i] << " ";
		//}
		//cout << endl;

		return;
	}
	int num1 = pow(2, m-1);
	int num2 = pow(2, m);
	int num3 = 1;
	for (int i = num1; i < num2; i++) {
		dir[i] = dir[num1 - num3]+1;
		if (dir[i] == 4) dir[i] = 0;
		num3++;
	}
	for (int i = num1; i < num2; i++) {
		int mx = x + dx[dir[i]];
		int my = y + dy[dir[i]];
		map[mx][my] = n + 1;
		x = mx, y = my;
	}

	curving(n, m + 1, x, y);
}

int main(void) {
	int N, cnt = 0;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> pos[i].y;
		cin >> pos[i].x;
		cin >> pos[i].d;
		cin >> pos[i].g;
	}
	for (int i = 0; i < N; i++) {
		dir[0] = pos[i].d;
		int x = pos[i].x; int y = pos[i].y;
		int mx = x + dx[dir[0]]; int my = y + dy[dir[0]];
		map[x][y] = i + 1;
		map[mx][my] = i + 1;
		if (pos[i].g > 0) {
			curving(i, 1, mx, my);
		}
	}
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (map[i][j] != 0 && map[i + 1][j] != 0 && map[i][j + 1] != 0 && map[i + 1][j + 1] != 0) cnt++;
		}
	}
	//cout <<"차 @@@@@@@@ " << endl;
	//for (int i = 0; i < 10; i++) {
	//	for (int j = 0; j < 10; j++) {
	//		cout << map[i][j] << " ";
	//	}
	//	cout << endl;
	//}
	//cout << endl;
	cout << cnt;
}