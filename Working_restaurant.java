import java.util.*;

public class Working_restaurant {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		while (n!= 0) {
			Queue<String> queue = new ArrayDeque<String>();
			for (int i = 0; i < n; i++) {
				queue.add(s.nextLine());
			}
			process(queue);
			
			n = s.nextInt();
			s.nextLine();
			if (n!= 0) {
				System.out.println();
			}
		}
	}
	
	public static void process(Queue<String> input) {
		int stack1 = 0;
		int stack2 = 0;
		
		ArrayList<String> res = new ArrayList<String>();
		while (!input.isEmpty()) {
			while (!input.isEmpty() && input.peek().substring(0,4).equals(("DROP"))) {
				String temp = input.remove();
				int num = new Integer(temp.substring(5));
				res.add("DROP 2 " + num);
				stack2+= num;
			}
			if (input.isEmpty()) {
				break;
			}
			String take;
			while (!input.isEmpty() && input.peek().substring(0,4).equals(("TAKE"))) {
				take = input.remove();
				int num = new Integer(take.substring(5));
				if (stack1 == 0) {
					res.add("MOVE 2->1 " + stack2);
					stack1 += stack2;
					stack2 = 0;
					res.add("TAKE 1 " + num);
					stack1 -= num; // Take num from stack 1
				}
				else {
					if (stack1 < num) {
						num -= stack1;
						res.add("TAKE 1 " + stack1);
						stack1 = 0;
						res.add("MOVE 2->1 " + stack2);
						stack1 += stack2;
						stack2 = 0;
						res.add("TAKE 1 " + num);
						stack1 -= num;
					}
					else {
						res.add("TAKE 1 " + num);
						stack1 -= num;
					}
				}
			}
		}
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
