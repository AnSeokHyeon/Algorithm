#include <iostream>

using namespace std;

int map[51][51];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
int main(void) {
	int N, M;
	int r, c, d;
	cin >> N >> M;
	cin >> r >> c >> d;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	int x = r;
	int y = c;
	int dir = d+3;
	int cnt = 0;
	map[x][y] = 2;
	int turn=0, mx, my;

	while (1) {

		if (map[x + dx[turn % 4]][y + dy[turn % 4]] > 0 && map[x + dx[(turn + 1) % 4]][y + dy[(turn + 1) % 4]] > 0 && map[x + dx[(turn + 2) % 4]][y + dy[(turn + 2) % 4]] == 1 && map[x + dx[(turn + 3) % 4]][y + dy[(turn + 3) % 4]] > 0 ) {
			break;
		}
		if (map[x + dx[turn % 4]][y + dy[turn % 4]] > 0 && map[x + dx[(turn + 1) % 4]][y + dy[(turn + 1) % 4]] > 0 && map[x + dx[(turn + 2) % 4]][y + dy[(turn + 2) % 4]] == 2 && map[x + dx[(turn + 3) % 4]][y + dy[(turn + 3) % 4]] > 0 ) {
			x = x - dx[turn];
			y = y - dy[turn];
			continue;
		}


		turn = dir % 4;
		mx = x + dx[turn];
		my = y + dy[turn];

		if (map[mx][my] > 0) {
			dir += 3;
			continue;
		}

		dir += 3;
		map[mx][my] = 2; 
		x = mx;
		y = my;


		//cout << "@@@@@@@@@@@@@" << endl;
		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		cout << map[i][j];
		//	}
		//	cout << endl;
		//}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			//cout << map[i][j];
			if (map[i][j] == 2) cnt++;
		}
		//cout << endl;
	}

	cout << cnt << endl;
	
}