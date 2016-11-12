import java.util.Scanner;
import java.util.Stack;

public class Collatz_conjecture {
	public static long getNext(long n) {
		if (n%2 == 0) {
			return n/2;
		}
		else {
			return n*3 + 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long a = s.nextLong();
		long b = s.nextLong();
		while (a!= 0 && b!= 0) {
			long x = a;
			long y = b;
			Stack<Long> s1 = new Stack<Long>();
			Stack<Long> s2 = new Stack<Long>();
			
			while (x!= 1) {
				s1.push(x);
				x = getNext(x);
			}
			while (y!= 1) {
				s2.push(y);
				y = getNext(y);
			}
			s1.push(((long)1));
			s2.push((long) 1);
			long pop1 = s1.pop();
			long pop2 = s2.pop();
			long prev = pop1;
			boolean stop1 = false;
			boolean stop2 = false;
			while (pop1 == pop2 && !(stop1 && stop2)) {
				prev = pop1;
				if (!s1.isEmpty()) {
					pop1 = s1.pop();
				}
				else {
					stop1 = true;
				}
				if (!s2.isEmpty()) {
					pop2 = s2.pop();
				}
				else {
					stop2 = true;
				}
			}
			int countA, countB;
			if (!stop1) {
				countA = s1.size() + 1;
			}
			else {
				countA = 0;
			}
			if (!stop2) {
				countB = s2.size() + 1;
			}
			else {
				countB = 0;
			}
			
			System.out.println(a + " needs " + countA + " steps, " 
								+ b + " needs " + countB + " steps, they meet at " + prev);
			
			a = s.nextInt();
			b = s.nextInt();
		}
		s.close();
	}
}