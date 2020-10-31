#include <iostream>

using namespace std;
int map[501][501] = {};

int N=0, M=0;
int temp = 0;
int dx[] = {0,-2,-2,-1,-1,-1,-1,0,0,0,0,0,1,1,1,1,2,2,3,-1,-2,1,2 };
int dy[] = {0,-1,0,-1,0,1,2,-2,-1,1,2,3,-2,-1,0,1,0,1,0,-2,1,2,-1 };
int tetris[19][4] = {
	{0,9,10,11},{0,14,16,18}, //----
	{0,9,14,15}, // --**
	{0,14,16,17}, {0,9,10,6}, {0,4,2,1},{0,8,7,12}, //--* 
	{0,14,16,22},{0,8,7,19},{0,4,2,20},{0,9,10,21},
	{0,14,15,17},{0,9,5,6}, //-*
	{0,14,13,22},{0,9,15,21},
	{0,3,4,5}, {0,5,9,15},{0,3,8,13},{0,13,14,15}
};

void solve(int x, int y) {
	for (int i = 0; i < 19; i++) {
		int sum = 0;
		int cnt = 0;
		for (int j = 0; j < 4; j++) {
			int mx = x + dx[tetris[i][j]];
			int my = y + dy[tetris[i][j]];
			if (mx< 1 || my < 1 || mx >N || my >M) break;
			sum += map[mx][my];
			cnt++;
		}
		if (sum > temp && cnt == 4) temp = sum;
	}
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < M + 1; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < M + 1; j++) {
			solve(i, j);
		}
	}
	cout << temp;
}
