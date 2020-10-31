#include <iostream>

using namespace std;

int map[20][20];
int rule[5][5];
int dx[] = { 0,0,0,-1,1 };
int dy[] = { 0,1,-1,0,0 };

void roll(int n) {
	if (n == 1) {
		for (int i = 4; i > 0; i--) {
			rule[2][i] = rule[2][i - 1];
		}
		rule[2][0] = rule[2][4];
		rule[0][2] = rule[2][4];
		rule[4][2] = rule[2][4];
	}
	else if (n == 2) {
		for (int i =0; i <4; i++) {
			rule[2][i] = rule[2][i +1];
		}
		rule[2][4] = rule[2][0];
		rule[0][2] = rule[2][0];
		rule[4][2] = rule[2][0];

	}
	else if (n == 3) {

		for (int i = 0; i < 4; i++) {
			rule[i][2] = rule[i+1][2];
		}
		rule[2][4] = rule[0][2];
		rule[2][0] = rule[0][2];
		rule[4][2] = rule[0][2];

	}
	else {

		for (int i = 4; i > 0; i--) {
			rule[i][2] = rule[i -1][2];
		}
		rule[2][4] = rule[4][2];
		rule[2][0] = rule[4][2];
		rule[0][2] = rule[4][2];

	}


}

int main(void) {
	int N, M, x, y, K;
	cin >> N >> M >> x >> y >> K;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}

	while (K--) {
		int dir;
		cin >> dir;
		int mx = x + dx[dir];
		int my = y + dy[dir];
		if (mx < 0 || my < 0 || mx >N - 1 || my > M - 1) continue;

		roll(dir);

		cout<< rule[2][2] << endl;

		if (map[mx][my] == 0) {
			map[mx][my] = rule[2][0];
		}
		else {
			rule[2][0] = map[mx][my];
			rule[2][4] = map[mx][my];
			rule[0][2] = map[mx][my];
			rule[4][2] = map[mx][my];
			map[mx][my] = 0;
		}
		x = mx;
		y = my;
	/*	cout << "주사위 현황" << endl;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cout << rule[i][j] << " ";
			}
			cout << endl;
		}
		cout << "지도현황" << endl;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cout << map[i][j] << " ";
			}
			cout << endl;
		}*/

	}


}