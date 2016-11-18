import java.util.*;

public class Virtual_friends {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			s.nextLine();
			String[] data = new String[n];
			Set<String> names = new HashSet<String>();
			for (int j = 0; j < n; j++) {
				data[j] = s.nextLine();
				String[] temp = data[j].split(" ");
				names.add(temp[0]);
				names.add(temp[1]);
			}

			int num = names.size();
			int x = 0;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (String name: names) {
				map.put(name, x);
				x++;
			}

			int[][] graph = new int[num][num];
			for (int j = 0; j < num; j++) {
				Arrays.fill(graph[j], 0);
			}

			for (int j = 0; j < n; j++) {
				String[] temp = data[j].split(" ");
				int p1 = map.get(temp[0]);
				int p2 = map.get(temp[1]);
				graph[p1][p2] = 1;
				graph[p2][p1] = 1;

				// BFS
				boolean[] visited = new boolean[num];
				Arrays.fill(visited, false);
				System.out.println(bfs(graph, p1, visited));
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
						System.out.print(graph[k][l] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}

	public static int bfs(int[][] graph, int s, boolean[] visited) {

		int n = graph.length;

		int count = 1;
		for (int i = 0; i < n; i++) {
			if (graph[s][i] == 1 && !visited[i]) {
				count++;
				visited[i] = true;
				count+= bfs(graph, i, visited);
			}
		}
		return count;
	}
}
