#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

struct pos {
	int x;
	int y;
	int idx; // 섬 인덱스
	int d; // 방향
	int n; // 몇번 왔냐

	pos() {
		this->x = 0;
		this->y = 0;
		this->idx = 0;
		this->d = 0;
		this->n = 0;
	}
	pos(int x, int y, int idx, int d, int n) {
		this->x = x;
		this->y = y;
		this->idx = idx;
		this->d = d;
		this->n = n;
	}

};

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
int N, M;

vector<vector<int>> map;
int mv[11][11];
vector<pos> chk[11][11];
int arr[7][7];
int dis[7][7] = { 0 };
bool islandchk[7] = { false };
int cnt = 0;
void bfs(int n) {
	queue<int> q;
	q.push(n);

	islandchk[n] = true;
	while (!q.empty()) {
		int index = q.front();
		q.pop();
		for (int i = 1; i <= cnt; i++) {
			if (islandchk[i] == true) continue;
			if (arr[index][i] == 0) continue;
			islandchk[i] = true;
			arr[n][i] = 1;
			arr[i][n] = 1;
			q.push(i);
		}
	}
	for (int i = 1; i <= cnt; i++) {
		islandchk[i] = false;
	}

}


int main(void) {
	cin >> N >> M;
	map.resize(N + 1, vector<int>(M + 1));
	queue<pos> q;
	queue<pos> q2;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				mv[i][j] = 9;
			}
		}
	}


	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (mv[i][j] != 9) continue;
			q.push(pos(i, j, cnt + 1, 0, 0));
			mv[i][j] = cnt + 1;
			map[i][j] = cnt + 1;
			while (!q.empty()) {
				pos f = q.front();
				q2.push(pos(f.x, f.y, f.idx, -1, 0));
				q.pop();

				int x = f.x;
				int y = f.y;
				int d = f.d;
				int idx = f.idx;

				for (int k = 0; k < 4; k++) {

					int mx = x + dx[k];
					int my = y + dy[k];

					if (mx < 1 || my < 1 || mx > N || my > M) continue;
					if (mv[mx][my] != 9) continue;

					q.push(pos(mx, my, idx, 0, 0));
					map[mx][my] = idx;
					mv[mx][my] = idx;
				}
			}
			cnt++;
		}
	}

	cout << "분할 성공 " << endl;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cout << mv[i][j] << " ";
		}
		cout << endl;
	}

	int t = 1;
	
	int ans = 0;
	while (1) {
		//cout << " 들어옴 " << endl;
		bool result = false;
		int size = q2.size();
		//cout << " 사이즈 : "<< size << endl;
		while (size--) {
			pos f = q2.front();
			q2.pop();
			int x = f.x;
			int y = f.y;
			int n = f.n;
			int d = f.d;
			int idx = f.idx;
			//cout << x<< " , " << y  << " -> " << idx << " 방향 " << d << " 번호 : "  << n << endl;
			for (int i = 0; i < 4; i++) {
				if (d > -1 && d != i) continue;
				int mx = x + dx[i];
				int my = y + dy[i];
				//cout << " 다음 좌표 : " << mx << " , " << my << endl;
				if (mx < 1 || my < 1 || mx > N || my > M) continue;
				if (map[mx][my] > 0) continue;
				if (mv[mx][my] == 0) {
					//cout << " 비었음 " << endl;
					mv[mx][my]++;
					chk[mx][my].push_back(pos{ mx, my, idx, i, n + 1 });
					q2.push(pos(mx, my, idx, i, n + 1));

					int tempx = mx + dx[i];
					int tempy = my + dy[i];
					if (tempx < 1 || tempy < 1 || tempx > N || tempy > M) continue;
					if (map[tempx][tempy] == 0 && mv[tempx][tempy] != 0) {
						int index = 0;
						bool reverse = false;
						for (int j = 0; j < chk[tempx][tempy].size(); j++) {
							if (chk[tempx][tempy][j].d % 2 == i % 2) {
								if (chk[tempx][tempy][j].idx == idx) continue;
								index = j;
								reverse = true;
							}
						}
						if (reverse == true) {
							int temp = chk[tempx][tempy][index].n + n +1 ;
							if (arr[idx][chk[tempx][tempy][index].idx] == 0) {
								arr[idx][chk[tempx][tempy][index].idx] = 1;
								arr[chk[tempx][tempy][index].idx][idx] = 1;
								dis[idx][chk[tempx][tempy][index].idx] = temp;
								dis[chk[tempx][tempy][index].idx][idx] = temp;
								for (int j = 1; j <= cnt; j++) {
									bfs(j);
								}
								bool tempresult = true;
								for (int j = 1; j <= cnt; j++) {
									for (int k = 1; k <= cnt; k++) {
										if (j == k)continue;
										if (arr[j][k] == 0) {
											tempresult = false;
											break;
										}
									}
								}
								if (tempresult == true) {
									result = true;
									break;
								}
							}
						}
					}

				}
				else  {
					//cout << " 있더라 " << endl;
					bool reverse = false;
					int index = 0;
					for (int j = 0; j < chk[mx][my].size(); j++) {
						if (chk[mx][my][j].d % 2 == i % 2) {
							if (chk[mx][my][j].idx == idx) continue;
							index = j;
							reverse = true;
						}
					}
					if (reverse == false) {
						mv[mx][my]++;
						chk[mx][my].push_back({ mx, my, idx, i, n + 1 });
						q2.push(pos(mx, my, idx, i, n + 1));
					}
					else {

						int temp = chk[mx][my][index].n + n;
			.			if (temp < 2) continue;
						if (arr[idx][chk[mx][my][index].idx] == 0) {
							arr[idx][chk[mx][my][index].idx] = 1;
							arr[chk[mx][my][index].idx][idx] = 1; 
							dis[idx][chk[mx][my][index].idx] = temp;
							dis[chk[mx][my][index].idx][idx] = temp;
							for (int j = 1; j <= cnt; j++) {
								bfs(j);
							}
							bool tempresult = true;
							for (int j = 1; j <= cnt; j++) {
								for (int k = 1; k <= cnt; k++) {
									if (j == k) continue;
									if (arr[j][k] == 0) {
										tempresult = false;
										break;
									}
								}
							}
							if (tempresult == true) {
								result = true;
								break;
							}
						}
						else {

							if ( dis[idx][chk[mx][my][index].idx] > temp) {
								dis[idx][chk[mx][my][index].idx] = temp;
								dis[chk[mx][my][index].idx][idx] = temp;
							}
						}
					}
				}
			}
			if (result == true) break;
		}

		cout << " 현재상황 " << endl;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] > 0) cout << "# ";
				else cout << mv[i][j] << " ";
			}
			cout << endl;
		}
		cout << " 방문 횟수 " << endl;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cout << chk[i][j].size() << " ";
			}
			cout << endl;
		}

		cout << "거리 확인 " << endl;
		for (int i = 1; i <= cnt; i++) {
			for (int j = 1; j <= cnt; j++) {
				cout << dis[i][j] << " ";
			}
			cout << endl;
		}
		t++;
		if (result == true) {
			for (int i = 1; i < cnt; i++) {
				for (int j = i+1; j <= cnt; j++) {
					ans += dis[i][j];
				}
			}
			break;
		}
		if (!q2.empty() == false) {
			ans = -1;
			break;
		}
	}
	cout << ans;
}