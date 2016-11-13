import java.util.Scanner;

public class Secret_message {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++) {
			String message = s.nextLine();
			int l = message.length();
			int j = 1;
			while (j*j < l) {
				j++;
			}
			int p = 0;
			char[][] square = new char[j][j];
			for (int a = 0; a < j; a++) {
				for (int b = 0; b < j; b++) {
					if (p < l) {
						square[a][b] = message.charAt(p);
						p++;
					}
					else {
						square[a][b] = '*';
					}
				}
			}
			StringBuilder res = new StringBuilder("");
			for (int a = 0; a < j; a++) {
				for (int b = j-1; b >=0; b--) {
					if (square[b][a] != '*') {
						res.append(square[b][a]);
					}
				}
			}
			System.out.println(res.toString());
		}
	}
}
