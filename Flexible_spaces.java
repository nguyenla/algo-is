import java.util.*;

public class Flexible_spaces {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int w = s.nextInt();
		int p = s.nextInt();
		int[] arr = new int[p+2];
		arr[0] = 0;
		arr[p+1] = w;
		for (int i = 1; i < p+1; i++) {
			arr[i] = s.nextInt();
		}
		
		ArrayList<Integer> all = new ArrayList<Integer>();
		for (int i = 0; i < p+1; i++) {
			for (int j = i+1; j < p+2; j++) {
				int temp = arr[j] - arr[i];
				if (!all.contains(temp)) {
					all.add(temp);
				}
			}
		}
		Collections.sort(all);
		int size = all.size();
		for (int i = 0; i < size - 1; i++) {
			System.out.print(all.get(i) + " ");
		}
		System.out.println(all.get(size-1));
		s.close();
	}
 }
