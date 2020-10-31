#include <string>
#include <iostream>
#include <vector>

using namespace std;
int chk[60][60];
int lmap[60][60];
int kmap[20][20];

bool answer = false;
int find(int n, int m, int k, int l) {

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < k; j++) {
			chk[n + i][m + j] = kmap[i][j];
		}
	}
	int cnt = 0;
	for (int i = 0; i < k + l; i++) {
		for (int j = 0; j < k + l; j++) {
			if (i > k - 1 && j > k - 1) 
			{
				int temp = chk[i][j] + lmap[i][j];
				if (temp == 1) cnt++;
			}
			chk[i][j] = 0;
		}
	}
	return cnt;
}
void findplus(int n, int m, int map[][20], int N) {

	for (int i = 0; i < N && i >=n - N +1; i++) {
		for (int j = 0; j < N && j>= m - N+1; j++) {
			chk[n - N+1 + i][m - N+1 + j] = kmap[i][j];
		}
	}
}

void findminus(int n, int m, int map[][20], int N) {
	
	for (int i = 0; i + n < N; i++) {
		for (int j = 0; j + m < N; j++) {
			chk[n + i][m + j] = kmap[i][j];
		}
	}
}

void turn(int map[][20], int N) {
	int copy[20][20];
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			copy[i][j] = 0;
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			copy[j][N - i - 1] = map[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
	       kmap[i][j] = copy[i][j];
	    }
	}
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
	int size = key.size();
	int lsize = lock.size();
	int maxsize = lsize * lsize;
	for (int i = 0; i < key.size(); i++) {
		for (int j = 0; j < key.size(); j++) {
			kmap[i][j] = key[i][j];
		}
	}

	for (int i = 0; i < lsize; i++) {
		for (int j = 0; j < lsize; j++) {
			lmap[size + i][size + j] = lock[i][j];
		}
	}

	for (int i = 0; i < size + lsize; i++) {
		for (int j = 0; j < size + lsize; j++) {
			int temp = find(i, j, size, lsize);
			if (temp == maxsize) answer = true;
		}
	}
	turn(kmap, size);

	for (int i = 0; i < size + lsize; i++) {
		for (int j = 0; j < size + lsize; j++) {
			int temp = find(i, j, size, lsize);
			if (temp == maxsize) answer = true;
		}
	}

	turn(kmap, size);

	for (int i = 0; i < size + lsize; i++) {
		for (int j = 0; j < size + lsize; j++) {
			int temp = find(i, j, size, lsize);
			if (temp == maxsize) answer = true;
		}
	}

	turn(kmap, size);

	for (int i = 0; i < size + lsize; i++) {
		for (int j = 0; j < size + lsize; j++) {
			int temp = find(i, j, size, lsize);
			if (temp == maxsize) answer = true;
		}
	}

	return answer;
}
