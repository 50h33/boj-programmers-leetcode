#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	while (cin >> a >> b >> c) {
        if (a == 0 && b == 0 && c == 0) break;
        int mx = 0;
        mx = max({a, b, c});
        if (mx == a) {
            if (a*a == b*b + c*c) cout << "right\n";
            else cout << "wrong\n";
        } else if (mx == b) {
            if (b*b == a*a + c*c) cout << "right\n";
            else cout << "wrong\n";
        } else {
            if (b*b + a*a == c*c) cout << "right\n";
            else cout << "wrong\n";
        }
    }
}