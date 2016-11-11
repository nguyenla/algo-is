import java.util.Scanner;

public class Settlers_of_Catan {
	public static int catan(int n) {
		int res = 0;
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
			
		}
		return res;
	}
	
	public static int[] nextCircle(int[] cur, int[] freq) {
		int n = cur.length + 6;
		int side = cur.length / 6;
		int[] res = new int[n];
		
		// fill in the first value
		int first = smallestAvailable(freq, cur[cur.length-1], cur[0], -1);
		freq[first - 1]++;
		res[0] = first;
		
		// fill in the rest
		int pos = 1;
		int p = 0;
		for (int i = 0; i < side - 1; i++) {
			int temp = smallestAvailable(freq, res[pos - 1], cur[p], cur[p+1]);
			freq[temp - 1]++;
			res[pos] = temp;
			pos++;
			p++;
		}
		
		for (int k = 0; k < 5; k++) {
			int temp = smallestAvailable(freq, res[pos-1], cur[p], -1);
			freq[temp - 1]++;
			res[pos] = temp;
			pos++;
			p++;
			
			for (int i = 0; i < side; i++) {
				System.out.println(p);
				int temp2 = smallestAvailable(freq, res[pos - 1], cur[p], cur[p+1]);
				freq[temp2 - 1]++;
				res[pos] = temp2;
				pos++;
				p++;
			}
		}
		
		int last = smallestAvailable(freq, res[pos - 1], res[0], cur[p]);
		// freq[last - 1]++;
		res[pos] = last;
		
		return res;
	}
	
	public static int smallestAvailable(int[] freq, int a1, int a2, int a3) {
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != a1 && freq[i] != a2 && freq[i] != a3) {
				return freq[i]+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] x = {2,3,4,5,2,3};
		int[] f = {1,2,2,1,1};
		int[] res = nextCircle(x,f);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i] + " ");
		}
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(catan(i));
		}
	}
}
