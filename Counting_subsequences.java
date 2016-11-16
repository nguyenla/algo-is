import java.util.*;

public class Counting_subsequences {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			int[] prefixSum = new int[n];
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += s.nextInt();
				prefixSum[j] = sum;
			}
			
			int count = 0;
			for (int j = 0; j < n; j++) {
				int cur = prefixSum[j];
				if (!map.containsKey(cur)) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(j);
					map.put(cur, list);
				}
				else {
					map.get(cur).add(j);
				}
				
				if (map.containsKey(cur - 47)) {
					count+= map.get(cur - 47).size();
				} 
				if (cur == 47) { 
					count++;
				}
			}
			System.out.println(count);
		}

	}

}
