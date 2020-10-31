#include <iostream>
#include <queue>

using namespace std;
struct pos {
	int x;
	int y;
	int t;
	pos(int x, int y, int t) {
		this->x = x;
		this->y = y;
		this->t = t;
	}
};

int map[100][100];
bool on[100][100];
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

int main(void) {

	queue <pos> air;
	queue <pos> cheeze;
	queue<pos> aircheeze;
	int N, M;
	cin >> N >> M;
	int aircount = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				cheeze.push(pos(i, j, 0));
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (i > 0 && i < N - 1) {
				if (j > 0 && j < M - 1) continue;
			}
			if (on[i][j] == true) continue;
			air.push(pos(i, j, 0));
			while (!air.empty()) {
				pos f = air.front();
				air.pop();
				int x = f.x;
				int y = f.y;
				for (int k = 0; k < 4; k++) {
					int mx = x + dx[k];
					int my = y + dy[k];
					if (mx > N - 1 || my > M - 1 || mx < 0 || my < 0) continue;
					if (on[mx][my] == true) continue;
					if (map[mx][my] == 1) continue;

					on[mx][my] = true;
					air.push(pos(mx, my, 0));
				}
			}
		}
	}

	int result = 0;
	while (1) {


		bool airing = false;
		
		//cout << " È£ÀÌ " << endl;

		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;

		//cout << " bool " << endl;

		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		if (on[i][j] == true) cout << "# ";
		//		else if (map[i][j] == 1) cout << "@ ";
		//		else cout << "0 ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;
		int size = cheeze.size();
		while (size--) {
			pos f = cheeze.front();
			cheeze.pop();
			int x = f.x;
			int y = f.y;
			int t = f.t;
			result = t;

			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx > N - 1 || my > M - 1 || mx < 0 || my < 0) continue;
				if (map[mx][my] > 0) continue;
				if (on[mx][my] == false) continue;
				map[x][y]++;
			}

			if (map[x][y] > 2) {
				aircheeze.push(pos(x, y, 0));
				airing = true;
			}
			else {
				map[x][y] = 1;
				cheeze.push(pos(x, y, t + 1));
			}

		}
		while (!aircheeze.empty()) {
			pos f = aircheeze.front();
			aircheeze.pop();

			map[f.x][f.y] = 0;
			on[f.x][f.y] = true;

			for (int i = 0; i < 4; i++) {
				int mx = f.x + dx[i];
				int my = f.y + dy[i];


				if (mx > N - 1 || my > M - 1 || mx < 0 || my < 0) continue;
				if (map[mx][my] > 0) continue;
				if (on[mx][my] == true) continue;

				on[mx][my] = true;
				aircheeze.push(pos(mx, my, 0));


			}

		}
		if (!cheeze.empty() == false) break;
		if (airing == false) break;
	}
	cout << result +1 << endl;
}