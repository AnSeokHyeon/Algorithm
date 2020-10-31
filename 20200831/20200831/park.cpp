// [1차] 추석 트래픽.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include<math.h>
#include <map>
using namespace std;

map<int, int> m;
vector<int> start_point;
vector<int> finish_point;

bool cmp(pair<int, int> a, pair<int, int> b) {
    return a.second > b.second;
}
bool cmp1(pair<int, int> a, pair<int, int> b) {
    return a.first < b.first;
}

void calc_sec(int n, vector<string> lines) {
    float stt_t = 0;
    float fns_t = 0;
    float rsp_t = 0;

    // 끝난시간 초로 바꾸자
    for (int i = 11; i <= 17; i += 3) {
        int temp = 0;
        if (lines[n][i] != '0') {
            temp += (lines[n][i] - '0') * 10;
        }
        temp += (lines[n][i + 1] - '0');

        if (i == 11) {
            temp *= 3600;
        }
        if (i == 14) {
            temp *= 60;
        }
        fns_t += temp;
    }

    // 끝난시간에 ms도 더한다(소숫점)
    fns_t += (lines[n][20] - '0') * 0.1;
    fns_t += (lines[n][21] - '0') * 0.01;
    fns_t += (lines[n][22] - '0') * 0.001;


    //응답시간 계산해서 시작시간 구하자
    int l = lines[n].size();
    int point = -1;

    for (int i = 24; i < l - 1; i++) {
        if (lines[n][i] == '.')
            point = i;
    }

    // 소수점이 없으면
    if (point == -1) {
        int p = 0;
        for (int i = l - 2; i >= 24; i--) {
            rsp_t += (lines[n][i] - '0') * pow(10, p);
            p++;
        }
    }

    // 소수점이 있으면
    else {
        int p = 0;
        for (int i = point - 1; i >= 24; i--) {
            rsp_t += (lines[n][i] - '0') * pow(10, p);
            p++;
        }
        p = 0;
        for (int i = point + 1; i < l - 1; i++) {
            rsp_t += (lines[n][i] - '0') * pow(0.1, p);
            p++;
        }
    }

    stt_t = fns_t - rsp_t;

    int s = stt_t*1000;
    int f = fns_t*1000;
    cout << s << endl;
    cout << f - s << endl;
    cout << f << endl;

    start_point.push_back(s);
    finish_point.push_back(f);
}


int solution(vector<string> lines) {
    for (int i = 0; i < lines.size(); i++) {
        calc_sec(i, lines);
    }

    int ans = 0;

    for (int i = 0; i < finish_point.size(); i++) {
        int st = finish_point[i];
        int tt = 0;
        for (int j = st; j <= st + 1000; j++) {
            int t = 1;
            for (int k = i + 1; k < start_point.size(); k++) {
                if (j < start_point[k]) {
                    continue;
                }
                t++;
            }
            tt = max(tt, t);
        }
        ans = max(tt, ans);
    }


    return ans;
}
int main(void) {

    vector<string> v = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
    cout << solution(v);
}