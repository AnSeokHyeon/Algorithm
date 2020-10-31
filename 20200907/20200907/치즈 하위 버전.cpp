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

int map[100][100];
bool on[100][100];
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};
int main(void) {
	queue<pos> q;
	queue<pos> cheeze;
	queue<pos> air;
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				cheeze.push(pos(i, j));
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
				if (map[i][j] == 1) continue;
				if (on[i][j] == true) continue;
				q.push(pos(i, j));
				on[i][j] = true;
				while (!q.empty()) {
					pos f = q.front();
					q.pop();
					int x = f.x;	
					int y = f.y;
					for (int i = 0; i < 4; i++) {
						int mx = x + dx[i];
						int my = y + dy[i];

						if (mx > N - 1 || my > M - 1 || mx < 0 || my <0) continue;
						if (map[mx][my] == 1) continue;
						if (on[mx][my] == true) continue;

						q.push(pos(mx, my));
						on[mx][my] = true;
					}

				}

			}
		}
	}
	int num = 0;
	int cake = cheeze.size();
	while (1) {
		int size = cheeze.size();
		bool airing = false;
		
		//cout << " 현재 지도  " << endl;
		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;

		//cout << " 공기 체크 공기 체크  " << endl;
		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		if (on[i][j] == true) cout << "# ";
		//		else cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;

		while (size--) {
			pos f = cheeze.front();
			cheeze.pop();
			int x = f.x;
			int y = f.y;

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx > N - 1 || my > M - 1 || mx < 0 || my < 0) continue;
				if (map[mx][my] > 0) continue;
				if (on[mx][my] == false) continue;
				map[x][y]++;
			}
			if (map[x][y] > 1) {
				air.push(pos(x, y));
				airing = true;
			}
			else {
				cheeze.push(pos(x, y));
			}
		}
		if (airing == false) break;
		if (!cheeze.empty() == false) {
			cake = air.size();
		}
		while (!air.empty()) {
			pos f = air.front();
			air.pop();
			int x = f.x;
			int y = f.y;
			map[x][y] = 0;
			on[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];

				if (mx > N - 1 || my > M - 1 || mx < 0 || my < 0) continue;
				if (map[mx][my] > 0) continue;
				if (on[mx][my] == true) continue;

				air.push(pos(mx, my));
				on[mx][my] = true;

			}
		}
		num++;
		if (!cheeze.empty() == false) break;
	}

	cout << num << endl;
	cout << cake << endl;

}