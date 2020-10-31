#include <iostream>

using namespace std;

int dx[] = {0,0,0,-1,1};
int dy[] = {0,1,-1,0,0};
int rule[4][3];
int map[20][20];
int main(void) {
	int N, M, x, y, K;
	cin >> N >> M >> x >> y >> K;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	while (K--) {
		int num;
		cin >> num;
	
		int mx = x + dx[num];
		int my = y + dy[num];

		if (mx < 0 || my < 0 || mx > N - 1 || my >M - 1) continue;

		if (num == 1) {
			int temp = rule[3][1];
			rule[3][1] = rule[1][2];
			rule[1][2] = rule[1][1];
			rule[1][1] = rule[1][0];
			rule[1][0] = temp;
 		}

		else if (num == 2) {
			int temp = rule[3][1];
			rule[3][1] = rule[1][0];
			rule[1][0] = rule[1][1];
			rule[1][1] = rule[1][2];
			rule[1][2] = temp;
		}

		else if (num == 3) {
			int temp = rule[0][1];
			for (int i = 0; i < 3; i++) {
				rule[i][1] = rule[i + 1][1];
			}
			rule[3][1] = temp;
		}

		else if (num == 4) {
			int temp = rule[3][1];
			for (int i = 3; i > 0; i--) {
				rule[i][1] = rule[i -1][1];
			}
			rule[0][1] = temp;
		}

		if (map[mx][my] == 0) map[mx][my] = rule[3][1];
		else {
			rule[3][1] = map[mx][my];
			map[mx][my] = 0;
		}
		//cout << " 현재 주사위 현황 " << endl;
		//for (int i = 0; i < 4; i++) {
		//	for (int j = 0; j < 3; j++) {
		//		cout << rule[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << " 현재 맵 현황 " << endl;
		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}

		cout << rule[1][1] << endl;
		x = mx;
		y = my;
	}
}