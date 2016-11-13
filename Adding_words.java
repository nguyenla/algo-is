import java.util.*;

public class Adding_words {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		String[] line;
		while (s.hasNextLine()) {
			line = s.nextLine().split(" ");
			if (line[0].equals("clear")) {
				map = new HashMap<String, Integer>();
				map2 = new HashMap<Integer, String>();
			}
			else if (line[0].equals("def")) {
				if (map.containsKey(line[1])) {
					int temp = map.get(line[1]);
					map.remove(line[1]);
					map2.remove(temp);
				}
				map.put(line[1], new Integer(line[2]));
				map2.put(new Integer(line[2]), line[1]);
			}
			else if (line[0].equals("calc")) {
				StringBuilder res = new StringBuilder("");
				for (int i = 1; i < line.length; i++) {
					res.append(line[i] + " ");
				}
				boolean defined = true;
				int sum = 0;
				if (map.containsKey(line[1])) {
					sum = new Integer(map.get(line[1]));
				}
				else {
					defined = false;
				}
				int p = 2;
				while (p < line.length) {
					if (line[p].equals("-")) {
						p++;
						if (map.containsKey(line[p])) {
							sum -= map.get(line[p]);
						}
						else {
							defined = false;
						}
						p++;
					}
					else if (line[p].equals("+")) {
						p++;
						if (map.containsKey(line[p])) {
							sum += map.get(line[p]);
						}
						else {
							defined = false;
						}
						p++;
					}
					else {
						p++;
					}
				}
				if (!defined) {
					res.append("unknown");
				}
				else if (!map.containsValue(sum)) {
					res.append("unknown");
				}
				else {
					res.append(map2.get(sum));
				}
				System.out.println(res.toString());
			}
		}
		s.close();
	}
}
