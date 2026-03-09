#include <bits/stdc++.h>
using namespace std;
int a, b, c, ans[14];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
    cin >> a >> b >> c;
	int num = a * b * c;
    string s = to_string(num);
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '0') ans[0]++;
        else if (s[i] == '1') ans[1]++;
        else if (s[i] == '2') ans[2]++;
        else if (s[i] == '3') ans[3]++;
        else if (s[i] == '4') ans[4]++;
        else if (s[i] == '5') ans[5]++;
        else if (s[i] == '6') ans[6]++;
        else if (s[i] == '7') ans[7]++;
        else if (s[i] == '8') ans[8]++;
        else if (s[i] == '9') ans[9]++;
    }

    for (int i = 0; i <= 9; i++) {
        cout << ans[i] << "\n";
    }
}