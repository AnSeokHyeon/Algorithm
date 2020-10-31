#include <string>
#include <vector>
#include <iostream>

using namespace std;
struct pos {
	int x;
	int y;
	int a;
	int b;
	int t;
	pos() {
		this->x = 0;
		this->y = 0;
		this->a = 0;
		this->b = 0;
		this->t = 0;
	}
};
pos build[1001];
int map[1001][1001][3];
vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
	vector<vector<int>> answer;
	int N = n + 1;
	int size = build_frame.size();
	for (int i = 0; i < size; i++) {
		build[i].x = build_frame[i][0];
		build[i].y = build_frame[i][1];
		build[i].a = build_frame[i][2];
		build[i].b = build_frame[i][3];

	}
	int T = size;
	int n = 0;
	while (T--) {
		int x = N - 1 - build[n].x;
		int y = N - 1 - build[n].y;
		int a = build[n].a;
		int b = build[n].b;
		//설치
		if (b == 1) {
			// 기둥 설치
			if (a == 0) {

				if (x == n) {
					map[x][y][1] = 1;
				}
				else if (map[x - 1][y][1] == 1 && x < n) {
					map[x][y][1] = 1;
				}
				else if ((map[x][y - 1][2] == 1 && map[x][y][2] == 1)) {
					continue;
				}
				else if ((map[x][y - 1][2] == 0 && map[x][y][2] == 0)) {
					continue;
				}
				else {
					map[x][y][1] = 1;
				}

			}

			// 보 설치
			else {



			}
		}
		//삭제
		else {


		}

		n++;

	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 1; k < 3; k++) {
				if (map[i][j][k] == 1) {
					cout << i + 1 - N << " / " << j + 1 - N << " / " << k - 1 << endl;
				}
			}
		}
	}

	return answer;
}