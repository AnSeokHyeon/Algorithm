#include <iostream>

using namespace std;

int N, M;
int joon[10];
//int chk[10];
void baek(int m) {
	if (m == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", joon[i]);
		}
		printf("\n");
		return;
	}
	for (int i = 1; i <= N; i++) {
		//if (chk[i] == 1) continue;
		joon[m] = i; 
		//chk[i] = 1;
		baek(  m + 1);
		//chk[i] = 0;
	}
}


int main(void) {
	cin >> N >> M;
	baek(0);
}