#include <iostream>

using namespace std;
int R, C;
int map[51][51];
int chk[51][51];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int main(void) {
	int T;
	int cnt = 0;
	int robot[2];
	cin >> R >> C >> T;
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) {
				robot[cnt++] = i;
			}
		}
	}
	int up = robot[0];
	int down = robot[1];
	while (T--) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] < 1) continue;
				int num = map[i][j] / 5;
				int kcnt = 0;
				for (int k =0; k < 4; k++) {
					int mx = i + dx[k];
					int my = j + dy[k];
					if (mx < 1 || my < 1 || mx > R || my > C) continue;
					if (map[mx][my] == -1) continue;
					kcnt++;
					chk[mx][my] += num;
				}
				chk[i][j] = chk[i][j] + map[i][j] - num * kcnt;
			}
		}
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] < 0) continue;
				map[i][j] = chk[i][j];
				chk[i][j] = 0;
			}
		}

		for (int i = up - 1; i > 1; i--) {
			map[i][1] = map[i - 1][1];
		}
		for (int i = down+1; i<R; i++) {
			map[i][1] = map[i + 1][1];
		}

		for (int i = 1; i < C; i++) {
			map[1][i] = map[1][i+1];
			map[R][i] = map[R][i+1];
		}

		for (int i = 1; i < up; i++) {
			map[i][C] = map[i + 1][C];
		}
		for (int i = R; i > down; i--) {
			map[i][C] = map[i - 1][C];
		}


		for (int i = C; i > 1; i--) {
			map[up][i] = map[up][i - 1];
			map[down][i] = map[down][i - 1];
			if (map[up][i] == -1)map[up][i] = 0;
			if (map[down][i] == -1)map[down][i] = 0;
		}
	}
	int result = 0;
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			//if (map[i][j] == -1) cout << "# ";
			//else cout << map[i][j] << " ";
			if (map[i][j] > 0)
				result += map[i][j];
		
		}
		//cout << endl;
	}
	cout << result << endl;
}