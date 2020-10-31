#include <iostream>

using namespace std;

int num[10];
int temp[10];

void sol(int n) {
	if (n == 0) {
		for (int i = 0; i < 4; i++) {
			cout << temp[i] << " ";
		}
		cout << endl;
		return;

	}
	for (int i = 0; i < 4; i++) {
		for (int j = i + 1; j < 4; j++) {
			temp[i] = num[j];
			temp[j] = num[i];
			sol(n - 1);
		}
	}

}

int main(void) {
	int n = 1;
	
	for (int i = 0; i < 4; i++) {
		num[i] = i + 1;
		temp[i] = num[i];
	}

	sol(n);
}