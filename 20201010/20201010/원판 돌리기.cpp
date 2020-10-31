#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};
int map[52][52];
int chk[52][52];
int N, M, T;
int del[2500];

int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };


void erase() {
	bool non_erase = true;
	int sum = 0;
	int count = 0;
	int cnt = 1;
	queue<pos> q;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (map[i][j] == 0) continue;
			if (chk[i][j] > 0) continue;

			sum += map[i][j];
			count++;

			q.push(pos(i, j));
			chk[i][j] = cnt;
			del[cnt]++;

			if (j == 1) {
				q.push(pos(i, M + 1));

				chk[i][M + 1] = cnt;
				del[cnt]++;
			}

			while (!q.empty()) {
				pos f = q.front();
				q.pop();
				int x = f.x;
				int y = f.y;
				int n = map[x][y];

				for (int k = 0; k < 4; k++) {
					int mx = x + dx[k];
					int my = y + dy[k];

					if (mx < 1 || my < 1 || mx >N || my >M+1) continue;
					if (map[mx][my] != n) continue;
					if (chk[mx][my] > 0)continue;

					q.push(pos(mx, my));
					chk[mx][my] = cnt;
					del[cnt]++;
					if (my == M + 1) {
						chk[mx][1] = cnt;
						del[cnt]++;
						q.push(pos(mx, 1));
					}

				}

			}
			cnt++;
		}
	}

	for (int i = 1; i <= N; i++) {
		int temp = chk[i][M + 1];
		if(temp > 0)
			del[temp]--;
	}

	for (int i = 1; i < cnt; i++) {
		if (del[i] > 1) {
			non_erase = false;
			break;
		}
	}
	//for (int i = 1; i <= N; i++) {
	//	for (int j = 1; j <= M + 1; j++) {
	//		printf("%3d", chk[i][j]);
	//	}
	//	cout << endl;
	//}
	//cout << non_erase << endl;

	//for (int i = 1; i < cnt; i++) {
	//	cout << del[i] << " ";
	//}

	float avg = float(sum) / float(count);
	if (non_erase == false) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int index = chk[i][j];
				chk[i][j] = 0;
				if (del[index] < 2) continue;
				map[i][j] = 0;
			}
		}

	}
	else {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) continue;
				float index = map[i][j];
				chk[i][j] = 0;
				if (index > avg) map[i][j]--;
				if (index < avg) map[i][j]++;
			}
		}

	}

	for (int i = 1; i <= N; i++) {
		map[i][M + 1] = map[i][1];
		chk[i][M + 1] = 0;
	}

	for (int i = 1; i < cnt; i++) {
		del[i] = 0;
	}
}

void moving(int n, int x) 
{
	if (n == 0) {
		for (int i = 1; i <= N; i++) {
			if (i % x != 0) continue;
			for (int j = M+1; j > 1; j--) {
				map[i][j] = map[i][j - 1];
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i % x != 0) continue;
			map[i][1] = map[i][M + 1];
		}
	}
	else {

		for (int i = 1; i <= N; i++) {
			if (i % x != 0) continue;
			for (int j = 1; j <= M; j++) {
				map[i][j] = map[i][j + 1];
			}
		}

		for (int i = 1; i <= N; i++) {
			if (i % x != 0) continue;
			map[i][M + 1] = map[i][1];
		}
	}
}

int main(void) {
	cin >> N >> M >> T;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 1; i <= N; i++){
		map[i][M + 1] = map[i][1];
	}
	while (T--) {

		int x, d, k;
		cin >>x >> d >> k;
		while (k--) {
			moving(d, x);
		}/*
		cout << " 변환 후 좌표" << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M + 1; j++) {
				cout << map[i][j] << " ";
			}
			cout << endl;
		}*/
		erase();

		//cout << " 지우고 난 결과 " << endl;

		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= M+1; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
	}

	int result = 0;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			result += map[i][j];
		}
	}
	cout << result << endl;
}