import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int iterations = scan.nextInt();
		
		scan.nextLine();
		
		int[][] source = new int[n][n];
		
		for(int k = 0; k < n; k++) {
			String line = scan.nextLine();
			for(int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '_')
					source[i][k] = 0;
				if (line.charAt(i) == 'X')
					source[i][k] = 1;
			}
		}
		for(int iter = 0; iter < iterations; iter++) {
			int[][] target = new int[n][n];
			
			for(int y = 0; y < n; y++) {
				int y_minus = (((y - 1) % n) + n) % n;
				int y_plus = (y + 1) % n;
				for(int x = 0; x < n; x++) {
					int x_minus = (((x - 1) % n) + n) % n;
					int x_plus = (x + 1) % n;
					int neighbor_sum = source[x_minus][y_minus] + source[x][y_minus] + source[x_plus][y_minus] + source[x_minus][y] + source[x_plus][y] + source[x_minus][y_plus] + source[x][y_plus] + source[x_plus][y_plus];
					if (source[x][y] == 1) {
						if (neighbor_sum < 2) target[x][y] = 0;
						else if (neighbor_sum == 2 || neighbor_sum == 3) target[x][y] = 1;
						else target[x][y] = 0;
					} else {
						if (neighbor_sum == 3) target[x][y] = 1;
						else target[x][y] = 0;
					}
				}
			}
			
			source = target;
		}
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				if (source[x][y] == 1)
					System.out.print('X');
				if (source[x][y] == 0)
					System.out.print('_');
			}
			System.out.println();
		}
		scan.close();
	}

}
