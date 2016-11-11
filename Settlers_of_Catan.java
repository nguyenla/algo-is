import java.util.Scanner;

public class Settlers_of_Catan {
	public static int catan(int n) {
		switch (n) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		case 5:
			return 5;
		case 6:
			return 2;
		case 7:
			return 3;
		default:
			int total = 7;
			int[] start = {2, 3, 4, 5, 2, 3};
			int[] freq = {1, 2, 2, 1, 1};
			int[] next = nextCircle(start, freq.clone());
			while (total + next.length < n) {
				total += next.length;
				for (int i = 0; i < next.length; i++) {
					freq[next[i] - 1]++;
				}
				next = nextCircle(next, freq.clone());
			}
			return next[n-total-1];
		}
	}
	
	public static int[] nextCircle(int[] cur, int[] freq) {
		int n = cur.length + 6;
		int side = cur.length / 6;
		int[] res = new int[n];
		
		// fill in the first value
		int first = smallestAvailable(freq.clone(), cur[cur.length-1], cur[0], -1);
		freq[first-1]++;
		res[0] = first;
		
		// fill in the rest
		int pos = 1;
		int p = 0;
		for (int i = 0; i < side - 1; i++) {
			int temp = smallestAvailable(freq.clone(), res[pos - 1], cur[p], cur[p+1]);
			freq[temp-1]++;
			res[pos] = temp;
			pos++;
			p++;
		}
		
		for (int k = 0; k < 5; k++) {
			int temp = smallestAvailable(freq.clone(), res[pos-1], cur[p], -1);
			freq[temp-1]++;
			res[pos] = temp;
			pos++;
			
			for (int i = 0; i < side; i++) {
				int temp2 = smallestAvailable(freq.clone(), res[pos - 1], cur[p], cur[p+1]);
				freq[temp2-1]++;
				res[pos] = temp2;
				pos++;
				p++;
			}
		}
		
		int last = smallestAvailable(freq.clone(), res[pos - 1], res[0], cur[p]);
		freq[last - 1]++;
		res[pos] = last;
		
		return res;
	}
	
	public static int smallestAvailable(int[] freq, int a1, int a2, int a3) {
		int res = -1;
//		System.out.println(a1 + " " + a2 + " " + a3);
		for (int i = 0; i < freq.length; i++) {
			if (i+1 != a1 && i+1 != a2 && i+1 != a3) {
				if (res == -1) {
					res = i;
				}
				else if (freq[i] < freq[res]) {
					res = i;
				}
			}
		}
		return res+1;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int next = s.nextInt();
			System.out.println(catan(next));
		}
		s.close();
	}
}
