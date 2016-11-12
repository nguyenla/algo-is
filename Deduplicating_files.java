import java.util.Scanner;

public class Deduplicating_files {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		while (n!= 0) {
			String[] files = new String[n];
			byte[] hash = new byte[n];
			for (int i = 0; i < n; i++) {
				files[i] = s.nextLine();
				int l = files[i].length();
				
				char first = files[i].charAt(0);
				byte b1 = (byte) (first & 0xFF);
				byte b2 = (byte) ((first >> 8) & 0xFF);
				byte res = (byte) (b1^ b2);
				
				for (int j = 1; j < l; j++) {
					char cur = files[i].charAt(j);
					b1 = (byte) (cur & 0xFF);
					b2 = (byte) ((cur >> 8) & 0xFF);
					res = (byte) (res ^ b1);
					res = (byte) (res ^ b2);
				}
				hash[i] = res;
			}
			
			int collisions = 0;
			int unique = 0;
			for (int i = 0; i < n-1; i++) {
				boolean isUnique = true;
				for (int j = i+1; j < n; j++) {
					if (hash[j] == hash[i]) {
						if (files[j].equals(files[i])) {
							isUnique = false;
						}
						else {
							collisions++;
						}
					}
				}
				if (isUnique) {
					unique++;
				}
			}
			unique++; // for the last line
			System.out.println(unique + " " + collisions);
			n = s.nextInt();
			s.nextLine();
		}
	}
}
