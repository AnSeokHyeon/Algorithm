#include <iostream>

using namespace std;
struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
};
int home[11][11];
int N, M, C;
pos A[5] = {};
pos B[5] = {};
int beeA[5];
int beeB[5];
int chk[5];
int chk2[5];
int sumA = 0, sumB = 0;
int result = 0;

void dfs (int a[],int x , int n, int m, int l) {
	if (n == m) {
		int tempSum = 0;
		for (int i = 0; i < m; i++) {
			tempSum += chk[i];
		}
		if (tempSum <= C) {
			int tempSum2 = 0;
			for (int i = 0; i < m; i++) {
				tempSum2 = tempSum2 + chk[i] * chk[i];
			}
			if (l == 0) {
				if(tempSum2 > sumA) sumA = tempSum2;
			}
			else {
				if(tempSum2 > sumB) sumB = tempSum2;
			}
		}
		return;
	}
	for (int i = x; i < M; i++) {
		if (chk2[i] != 0) continue;
		chk[n] = a[i];
		chk2[i] = 1;
		dfs(a, i,n+1 ,m,l);
		chk2[i] = 0;
	}
}

void print() {
	int ax = A[0].x;
	int bx = B[0].x;
	int ay = A[0].y;
	int by = B[0].y;
	for (int i = 0; i < M; i++) {
		beeA[i] = home[ax][ay + i];
	}
	sumA = 0;
	for (int i = 1; i <= M; i++) {

		dfs(beeA, 0, 0,i,0);
	}

	for (int i = 0; i < M; i++) {
		beeB[i] = home[bx][by + i];
	}

	sumB = 0; 
	for (int i = 1; i <= M; i++) {

		dfs(beeB, 0, 0, i, 1);
	}

	int tempSum = sumA + sumB;
	//cout << tempSum << endl;
	if (tempSum > result) result = tempSum;
}


int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> N >> M >> C;
		//cout << N << " " << M << " " << C << endl;
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> home[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N + 1 - M; j++) {
				A[0].x = i;
				A[0].y = j;
				for (int k = i; k < N; k++) {
					for (int l = 0; l < N + 1 - M; l++) {
						if (k == i && l < j+M-1) l = j + M;
						if (l + M - 1 > N-1) {
							l = N;
							continue;
						}
						B[0].x = k;
						B[0].y = l;
						//cout << i<< " , " << j << " / " << k << " , " << l << endl;
						print();
					}
				}

			}
		}
		cout << "#" << Tcnt++ << " "<< result  << endl;
	}
}