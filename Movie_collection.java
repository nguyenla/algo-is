import java.util.*;

public class Movie_collection {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for (int i = 0; i < n; i++) {
			int m = s.nextInt();
			int r = s.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = m; j > 0; j--) {
				list.add(j);
			}
			
			StringBuilder res = new StringBuilder("");
			for (int j = 0; j < r; j++) {
				int temp = s.nextInt();
				int index = list.indexOf(temp);
				int pos = m - index - 1;
				res.append(pos + " ");
				list.remove(index);
				list.add(temp);
			}
			String str = res.toString();
			System.out.println(str.substring(0, str.length() - 1));
		}
	}
}
