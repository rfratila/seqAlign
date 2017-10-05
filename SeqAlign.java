import java.util.HashMap;
import java.util.Map;

public class SeqAlign {
	public static int[][] m = new int[][]{
		{ 1,-2,-1,-2},
		{-2,1,-2,-1},
		{-1,-2,1,-2},
		{-2,-1,-2,1}};

	public static int posInfinity = Integer.MAX_VALUE;
	public static int negInfinity = Integer.MIN_VALUE;

	public static int getMatchScore(char a, char b){
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('A', 0);
		hm.put('C', 1);
		hm.put('G', 2);
		hm.put('T', 3);
		return m[(int)hm.get(a)][(int)hm.get(b)];
	}

	public static void printMatrix(int[][] m){
		for (int i =0; i < m.length; i++){
			for (int j = 0; j < m[i].length; j++){
				System.out.print(m[i][j] + "|");
			}
			System.out.println("\n_");
		}
		System.out.println("************************");
	}

	public static int max(int f, int... r){
		int ret = f;
		for (int value : r){
			ret = Math.max(ret, value);
		}
		return ret;
	}

	public static int min(int f, int... r){
		int ret = f;
		for (int value : r){
			ret = Math.min(ret, value);
		}
		return ret;
	}

	public static int extract(int[][] matrix, int i, int j){
		try {
			return matrix[i][j];
		}
		catch (ArrayIndexOutOfBoundsException e){
			return 0;
		}
	}

	public static void main(String[] args){
		int a = -1;
		int b = -5;
		String s = "ATGGATTTATCTGCTCTTCGCGTTGAAGAAGTACAAAATGTCATTAATGCTATGCAGAAAATCTTAGAGTGTCCCATCTGTCTGGAGTTGATCAAGGAACCTGTCTCCACAAAGTGTGACCACATATTTTGCAAATTTTGCATGCTGAAACTTCTCAACCAGAAGAAAGGGCCTTCACAGTGTCCTTTATGTAAGAATGATATAACCAAAAGGAGCCTACAAGAAAGTACGAGATTTAGTCAACTTGTTGAAGAGCTATTGAAAATCATTTGTGCTTTTCAGCTTGACACAGGTTTGGAGTATGCAAACAGCTATAATTTTGCAAAAAAGGAAAATAACTCTCCTGAACATCTAAAAGATGAAGTTTCTATCATCCAAAGTATGGGCTACAGAAACCGTGCCAAAAGACTTCTACAGAGTGAACCCGAAAATCCTTCCTTGCAGGAAACCAGTCTCAGTGTCCAACTCTCTAACCTTGGAACTGTGAGAACTCTGAGGACAAAGCAGCGGATACAACCTCAAAAGACGTCTGTCTACATTGAATTGGGATCTGATTCTTCTGAAGATACCGTTAATAAGGCAACTTATTGCAGTGTGGGAGATCAAGAATTGTTACAAATCACCCCTCAAGGAACCAGGGATGAAATCAGTTTGGATTCTGCAAAAAAGGCTGCTTGTGAATTTTCTGAGACGGATGTAACAAATACTGAACATCATCAACCCAGTAATAATGATTTGAACACCACTGAGAAGCGTGCAGCTGAGAGGCATCCAGAAAAGTATCAGGGTAGTTCTGTTTCAAACTTGCATGTGGAGCCATGTGGCACAAATACTCATGCCAGCTCATTACAGCATGAGAACAGCAGTTTATTACTCACTAAAGACAGAATGAATGTAGAAAAGGCTGAATTCTGTAATAAAAGCAAACAGCCTGGCTTAGCAAGGAGCCAACATAACAGATGGGCTGGAAGTAAGGAAACATGTAATGATAGGCGGACTCCCAGCACAGAAAAAAAGGTAGATCTGAATGCTGATCCCCTGTGTGAGAGAAAAGAATGGAATAAGCAGAAACTGCCATGCTCAGAGAATCCTAGAGATACTGAAGATGTTCCTTGGATAACACTAAATAGCAGCATTCAGAAAGTTAATGAGTGGTTTTCCAGAAGTGATGAACTGTTAGGTTCTGATGACTCACATGATGGGGAGTCTGAATCAAATGCCAAAGTAGCTGATGTATTGGACGTTCTAAATGAGGTAGATGAATATTCTGGTTCTTCAGAGAAAATAGACTTACTGGCCAGTGATCCTCATGAGGCTTTAATATGTAAAAGTGAAAGAGTTCACTCCAAATCAGTAGAGAGTAATATTGAAGACAAAATATTTGGGAAAACCTATCGGAAGAAGGCAAGCCTCCCCAACTTAAGCCATGTAACTGAAAATCTAATTATAGGAGCATTTGTTACTGAGCCACAGATAATACAAGAGCGTCCCCTCACAAATAAATTAAAGCGTAAAAGGAGACCTACATCAGGCCTTCATCCTGAGGATTTTATCAAGAAAGCAGATTTGGCAGTTCAAAAGACTCCTGAAATGATAAATCAGGGAACTAACCAAACGGAGCAGAATGGTCAAGTGATGAATATTACTAATAGTGGTCATGAGAATAAAACAAAAGGTGATTCTATTCAGAATGAGAAAAATCCTAACCCAATAGAATCACTCGAAAAAGAATCTGCTTTCAAAACGAAAGCTGAACCTATAAGCAGCAGTATAAGCAATATGGAACTCGAATTAAATATCCACAATTCAAAAGCACCTAAAAAGAATAGGCTGAGGAGGAAGTCTTCTACCAGGCATATTCATGCGCTTGAACTAGTAGTCAGTAGAAATCTAAGCCCACCTAATTGTACTGAATTGCAAATTGATAGTTGTTCTAGCAGTGAAGAGATAAAGAAAAAAAAGTACAACCAAATGCCAGTCAGGCACAGCAGAAACCTACAACTCATGGAAGGTAAAGAACCTGCAACTGGAGCCAAGAAGAGTAACAAGCCAAATGAACAGACAAGTAAAAGACATGACAGCGATACTTTCCCAGAGCTGAAGTTAACAAATGCACCTGGTTCTTTTACTAAGTGTTCAAATACCAGTGAACTTAAAGAATTTGTCAATCCTAGCCTTCCAAGAGAAGAAAAAGAAGAGAAACTAGAAACAGTTAAAGTGTCTAATAATGCTGAAGACCCCAAAGATCTCATGTTAAGTGGAGAAAGGGTTTTGCAAACTGAAAGATCTGTAGAGAGTAGCAGTATTTCATTGGTACCTGGTACTGATTATGGCACTCAGGAAAGTATCTCGTTACTGGAAGTTAGCACTCTAGGGAAGGCAAAAACAGAACCAAATAAATGTGTGAGTCAGTGTGCAGCATTTGAAAACCCCAAGGGACTAATTCATGGTTGTTCCAAAGATAATAGAAATGACACAGAAGGCTTTAAGTATCCATTGGGACATGAAGTTAACCACAGTCGGGAAACAAGCATAGAAATGGAAGAAAGTGAACTTGATGCTCAGTATTTGCAGAATACATTCAAGGTTTCAAAGCGCCAGTCATTTGCTCCGTTTTCAAATCCAGGAAATGCAGAAGAGGAATGTGCAACATTCTCTGCCCACTCTGGGTCCTTAAAGAAACAAAGTCCAAAAGTCACTTTTGAATGTGAACAAAAGGAAGAAAATCAAGGAAAGAATGAGTCTAATATCAAGCCTGTACAGACAGTTAATATCACTGCAGGCTTTCCTGTGGTTGGTCAGAAAGATAAGCCAGTTGATAATGCCAAATGTAGTATCAAAGGAGGCTCTAGGTTTTGTCTATCATCTCAGTTCAGAGGCAACGAAACTGGACTCATTACTCCAAATAAACATGGACTTTTACAAAACCCATATCGTATACCACCACTTTTTCCCATCAAGTCATTTGTTAAAACTAAATGTAAGAAAAATCTGCTAGAGGAAAACTTTGAGGAACATTCAATGTCACCTGAAAGAGAAATGGGAAATGAGAACATTCCAAGTACAGTGAGCACAATTAGCCGTAATAACATTAGAGAAAATGTTTTTAAAGAAGCCAGCTCAAGCAATATTAATGAAGTAGGTTCCAGTACTAATGAAGTGGGCTCCAGTATTAATGAAATAGGTTCCAGTGATGAAAACATTCAAGCAGAACTAGGTAGAAACAGAGGGCCAAAATTGAATGCTATGCTTAGATTAGGGGTTTTGCAACCTGAGGTCTATAAACAAAGTCTTCCTGGAAGTAATTGTAAGCATCCTGAAATAAAAAAGCAAGAATATGAAGAAGTAGTTCAGACTGTTAATACAGATTTCTCTCCATATCTGATTTCAGATAACTTAGAACAGCCTATGGGAAGTAGTCATGCATCTCAGGTTTGTTCTGAGACACCTGATGACCTGTTAGATGATGGTGAAATAAAGGAAGATACTAGTTTTGCTGAAAATGACATTAAGGAAAGTTCTGCTGTTTTTAGCAAAAGCGTCCAGAAAGGAGAGCTTAGCAGGAGTCCTAGCCCTTTCACCCATACACATTTGGCTCAGGGTTACCGAAGAGGGGCCAAGAAATTAGAGTCCTCAGAAGAGAACTTATCTAGTGAGGATGAAGAGCTTCCCTGCTTCCAACACTTGTTATTTGGTAAAGTAAACAATATACCTTCTCAGTCTACTAGGCATAGCACCGTTGCTACCGAGTGTCTGTCTAAGAACACAGAGGAGAATTTATTATCATTGAAGAATAGCTTAAATGACTGCAGTAACCAGGTAATATTGGCAAAGGCATCTCAGGAACATCACCTTAGTGAGGAAACAAAATGTTCTGCTAGCTTGTTTTCTTCACAGTGCAGTGAATTGGAAGACTTGACTGCAAATACAAACACCCAGGATCCTTTCTTGATTGGTTCTTCCAAACAAATGAGGCATCAGTCTGAAAGCCAGGGAGTTGGTCTGAGTGACAAGGAATTGGTTTCAGATGATGAAGAAAGAGGAACGGGCTTGGAAGAAAATAATCAAGAAGAGCAAAGCATGGATTCAAACTTAGGTGAAGCAGCATCTGGGTGTGAGAGTGAAACAAGCGTCTCTGAAGACTGCTCAGGGCTATCCTCTCAGAGTGACATTTTAACCACTCAGCAGAGGGATACCATGCAACATAACCTGATAAAGCTCCAGCAGGAAATGGCTGAACTAGAAGCTGTGTTAGAACAGCATGGGAGCCAGCCTTCTAACAGCTACCCTTCCATCATAAGTGACTCTTCTGCCCTTGAGGACCTGCGAAATCCAGAACAAAGCACATCAGAAAAAGCAGTATTAACTTCACAGAAAAGTAGTGAATACCCTATAAGCCAGAATCCAGAAGGCCTTTCTGCTGACAAGTTTGAGGTGTCTGCAGATAGTTCTACCAGTAAAAATAAAGAACCAGGAGTGGAAAGGTCATCCCCTTCTAAATGCCCATCATTAGATGATAGGTGGTACATGCACAGTTGCTCTGGGAGTCTTCAGAATAGAAACTACCCATCTCAAGAGGAGCTCATTAAGGTTGTTGATGTGGAGGAGCAACAGCTGGAAGAGTCTGGGCCACACGATTTGACGGAAACATCTTACTTGCCAAGGCAAGATCTAGAGGGAACCCCTTACCTGGAATCTGGAATCAGCCTCTTCTCTGATGACCCTGAATCTGATCCTTCTGAAGACAGAGCCCCAGAGTCAGCTCGTGTTGGCAACATACCATCTTCAACCTCTGCATTGAAAGTTCCCCAATTGAAAGTTGCAGAATCTGCCCAGAGTCCAGCTGCTGCTCATACTACTGATACTGCTGGGTATAATGCAATGGAAGAAAGTGTGAGCAGGGAGAAGCCAGAATTGACAGCTTCAACAGAAAGGGTCAACAAAAGAATGTCCATGGTGGTGTCTGGCCTGACCCCAGAAGAATTTATGCTCGTGTACAAGTTTGCCAGAAAACACCACATCACTTTAACTAATCTAATTACTGAAGAGACTACTCATGTTGTTATGAAAACAGATGCTGAGTTTGTGTGTGAACGGACACTGAAATATTTTCTAGGAATTGCGGGAGGAAAATGGGTAGTTAGCTATTTCTGGGTGACCCAGTCTATTAAAGAAAGAAAAATGCTGAATGAGCATGATTTTGAAGTCAGAGGAGATGTGGTCAATGGAAGAAACCACCAAGGTCCAAAGCGAGCAAGAGAATCCCAGGACAGAAAGATCTTCAGGGGGCTAGAAATCTGTTGCTATGGGCCCTTCACCAACATGCCCACAGATCAACTGGAATGGATGGTACAGCTGTGTGGTGCTTCTGTGGTGAAGGAGCTTTCATCATTCACCCTTGGCACAGGTGTCCACCCAATTGTGGTTGTGCAGCCAGATGCCTGGACAGAGGACAATGGCTTCCATGCAATTGGGCAGATGTGTGAGGCACCTGTGGTGACCCGAGAGTGGGTGTTGGACAGTGTAGCACTCTACCAGTGCCAGGAGCTGGACACCTACCTGATACCCCAGATCCCCCACAGCCACTACTGA";
		String t = "ATGGATTTATCTGCCGTCCAAATTCAAGAAGTACAAAATGTCCTTCATGCTATGCAGAAAATCTTAGAGTGTCCGATCTGTTTGGAACTGATCAAAGAACCTGTTTCCACAAAGTGTGACCACATATTTTGCAAATTTTGTATGCTGAAACTTCTTAACCAGAAGAAAGGGCCTTCACAATGTCCTTTGTGTAAGAATGAGATAACCAAAAGGAGCCTACAGGGAAGCACAAGGTTTAGTCAGCTTGCTGAAGAGCTGCTGAGAATAATGGCTGCTTTTGAGCTTGACACGGGAATGCAGCTTACAAATGGTTTTAGTTTTTCAAAAAAGAGAAATAATTCTTGTGAGCGTTTGAATGAGGAGGCGTCGATCATCCAGAGCGTGGGCTACCGGAACCGTGTCAGAAGGCTTCCCCAGGTCGAACCTGGAAATGCCACCTTGAAGGACAGCCTAGGTGTCCAGCTGTCTAACCTTGGAATCGTGAGATCAGTGAAGAAAAACAGGCAGACCCAACCTCGAAAGAAATCTGTCTACATTGAACTAGACTCTGATTCTTCTGAAGAGACAGTAACTAAGCCAGGTGATTGCAGTGTGAGAGACCAGGAATTGTTACAGACCGCCCCTCAAGAAGCTGGAGATGAAGGCAAGCTGCACTCTGCAGAAGAGGCTGCTTGTGAGTTTTCTGAGGGCATAAGAAACATTGAACATCATCAATGCAGTGATGATTTAAACCCTACTGAGAATCATGCAACTGAAAGGCATCCAGAAAAATGTCAGAGTATTTCTATTTCAAATGTGTGTGTGGAGCCATGTGGCACAGATGCTCATGCCAGCTCATTACAGCCTGAGACCAGCAGTTTATTGCTCATTGAAGACAGAATGAATGCAGAAAAGGCTGAATTCTGTAATAAAAGCAAACAGCCTGGCATAGCAGTGAGCCAGCAGAGCAGATGGGCTGCAAGTAAAGGAACATGTAACGACAGGCAGGTTCCCAGCACTGGGGAAAAGGTAGGTCCAAACGCTGACTCCCTTAGTGATAGAGAGAAGTGGACTCACCCGCAAAGTCTGTGCCCTGAGAATTCTGGAGCTACCACCGATGTTCCTTGGATAACACTAAATAGCAGCGTTCAGAAAGTTAATGAGTGGTTTTCCAGAACTGGTGAAATGTTAACTTCTGACAGCGCATCTGCCAGGAGGCACGAGTCAAATGCTGAAGCAGCTGTTGTGTTGGAAGTTTCAAACGAAGTGGATGGGGGTTTTAGTTCTTCAAGGAAAACAGACTTAGTAACCCCCGACCCCCATCATACTTTAATGTGTAAAAGTGGAAGAGACTTCTCCAAACCAGTAGAGGATAATATCAGTGATAAAATATTTGGGAAATCCTATCAGAGAAAGGGAAGCCGCCCTCACCTGAACCATGTGACTGAAATTATAGGCACATTTATTACAGAACCACAGATAACACAAGAGCAGCCCTTCACAAATAAATTAAAACGTAAGAGAAGTACATCCCTTCAACCTGAGGACTTCATCAAGAAAGCAGATTCAGCAGGTGTTCAAAGGACTCCTGACAACATAAATCAGGGAACTGACCTAATGGAGCCAAATGAGCAAGCAGTGAGTACTACCAGTAACTGTCAGGAGAACAAAATAGCAGGTAGTAATCTCCAGAAAGAGAAAAGCGCTCATCCAACTGAATCATTGAGAAAGGAACCTGCTTCCACAGCAGGAGCCAAATCTATAAGCAACAGTGTAAGTGATTTGGAGGTAGAATTAAACGTCCACAGTTCAAAAGCACCTAAGAAAAATAGGCTGAGGAGGAAGTCTTCTATCAGGTGTGCTCTTCCACTTGAACCAATCAGTAGAAATCCAAGCCCACCTACTTGTGCTGAGCTTCAAATCGATAGTTGTGGTAGCAGTGAAGAAACAAAGAAAAACCATTCCAACCAACAGCCAGCCGGGCACCTTAGAGAGCCTCAACTCATCGAAGACACTGAACCTGCAGCGGATGCCAAGAAGAACGAGCCAAATGAACACATAAGGAAGAGACGTGCCAGCGATGCTTTCCCAGAAGAGAAATTAATGAACAAAGCTGGTTTATTAACTAGCTGTTCAAGTCCTAGAAAATCTCAAGGGCCTGTCAATCCCAGCCCTCAGAGAACAGGAACAGAGCAACTTGAAACACGCCAAATGTCTGACAGTGCCAAAGAACTCGGGGATCGGGTCCTAGGAGGAGAGCCCAGTGGCAAAACCACTGACCGATCTGAGGAGAGCACCAGCGTATCCTTGGTATCTGACACTGACTACGACACTCAGAACAGTGTCTCAGTCCTGGACGCTCACACTGTCAGATATGCAAGAACAGGATCCGCTCAGTGTATGACTCAGTTTGTAGCAAGCGAAAACCCCAAGGAACTCGTCCATGGCTCTAACAATGCTGGGAGTGGCACAGAGGGTCTCAAGCCCCCCTTGAGACACGCGCTTAACCTCAGTCAGGAGAAAGTAGAAATGGAAGACAGTGAACTTGATACTCAGTATTTGCAGAATACATTTCAAGTTTCAAAGCGTCAGTCATTTGCTTTATTTTCAAAACCTAGAAGTCCCCAAAAGGACTGTGCTCACTCTGTGCCCTCAAAGGAACTGAGTCCAAAGGTGACAGCTAAAGGTAAACAAAAAGAACGTCAGGGACAGGAAGAATTTGAAATCAGTCACGTACAAGCAGTTGCGGCCACAGTGGGCTTACCTGTGCCCTGTCAAGAAGGTAAGCTAGCTGCTGATACAATGTGTGATAGAGGTTGTAGGCTTTGTCCATCATCTCATTACAGAAGCGGGGAGAATGGACTCAGCGCCACAGGTAAATCAGGAATTTCACAAAACTCACATTTTAAACAATCAGTTTCTCCCATCAGGTCATCTATAAAAACTGACAATAGGAAACCTCTGACAGAGGGACGATTTGAGAGACATACATCATCAACTGAGATGGCGGTGGGAAATGAGAACATTCTTCAGAGTACAGTGCACACAGTTAGCCTGAATAACAGAGGAAATGCTTGTCAAGAAGCCGGCTCGGGCAGTATTCATGAAGTATGTTCCACTGGTGACTCCTTCCCAGGACAACTAGGTAGAAACAGAGGGCCTAAGGTGAACACTGTGCCTCCATTAGATAGTATGCAGCCTGGTGTCTGTCAGCAAAGTGTTCCTGTAAGTGATAAGTATCTTGAAATAAAAAAGCAGGAGGGTGAGGCTGTCTGTGCAGACTTCTCTCCATGTCTATTCTCAGACCATCTTGAGCAATCTATGAGTGGTAAGGTTTTTCAGGTTTGCTCTGAGACACCTGATGACCTGCTGGATGATGTTGAAATACAGGGACATACTAGCTTTGGTGAAGGTGACATAATGGAGAGATCTGCTGTCTTTAACGGAAGCATCCTGAGAAGGGAGTCCAGTAGGAGCCCTAGTCCTGTAACCCATGCATCGAAGTCTCAGAGTCTCCACAGAGCGTCTAGGAAATTAGAATCGTCAGAAGAGAGCGACTCCACTGAGGATGAAGATCTTCCCTGCTTCCAACACTTACTGAGCAGAATAAGCAACACACCTGAGCTTACCAGATGCAGCAGTGCTGTGACACAGCGTATGCCAGAGAAAGCGGAGGGGACCCAAGCACCATGGAAGGGTAGCAGCAGTGACTGCAATAATGAGGTGATCATGATAGAGGCATCTCAGGAGCATCAGTTTAGTGAGGATCCAAGATGCTCTGGCAGCATGTTCTCTTCACAGCACAGTGCTGCCCAAGGGTCAACTGCAAATGCAAACTCCCAGGATTCCAATTTTATTCCACCTTCCAAACAGAGGAGTCACCAGTGTGGGAATGAGGAAGCTTTCCTAAGTGACAAGGAATTGATTTCAGATAACGAGGAAATGGCAACTTGCCTAGAAGAGGATAATGACCAAGAAGAGGATAGTATAATCCCAGATTCAGAGGCATCCGGATACGAGAGTGAAACAAACCTTTCTGAAGACTGCTCGCAGAGTGATATTTTAACCACTCAGCAGCGGGCGACCATGAAGTATAACCTGATAAAGCTGCAGCAGGAAATGGCTCACCTGGAAGCTGTGCTGGAGCAGCGTGGGAACCAGCCTTCTGGCCACTCCCCTTCCCTCCTAGCGGACCCTTGTGCCCTGGAAGACCTGCCAGATCTGGAACCAAACATGTCAGGAGCAGCAATTTTAACTTCAAAGAACATTAATGAGAATCCTGTAAGCCAAAATTTGAAGAGCGCTTGTGATGACAAATTCCAACTACAACATCTGGAGGGTCCCACCAGTGGAGATGACGAGTCAGGGATGGGAAGGCCTTCCCCTTTTAAATCTCCGTTGGCAGGCAGTAGGGGCTCTGCACATGGCTGCTCTAGGCATCTTCAAAAGAGAAACTCCCCCTCTCAGGAGGAGCTCCTCCAGCCTGCTGGATCAGAGGCGTCATCTGAGCCACACAATTCAACAGGGCAGTCTTGCCTGCCAAGGCGAGAGCTAGAAGGAACCCCATACCTGGGATCTGGAATCAGCCTTTTCTCTAGTAGAGACCCCGAATCTGAGTCCCCTAAAGAGCCAGCCCACATTGGCACCACACCAGCTTCAACCTCTGCACTGAAAATACCCCAAGGTCAAGTTGCTTTCCGGAGTGCAGCTGCTGCTGGTGCTGATAAAGCAGTGGTAGGAATTGTGAGCAAGATAAAGCCGGAATTGACATCTTCAGAAGAAAGAGCGGATAGAGACATATCCATGGTGGTGTCAGGCTTGACCCCCAAAGAAGTAATGACCGTGCAAAAGTTTGCTGAAAAATACCGCCTCACTTTAACTGACGCAATTACTGAGGAGACTACACATGTAATTATAAAAACAGATGCGGAGTTTGTGTGTGAGCGGACACTGAAATATTTTCTGGGCATTGCAGGAGGAAAGTGGATAGTTAGCTATTCATGGGTGGTCCGGTCTATCCAAGAAAGAAGACTTCTGAATGTGCATGAATTTGAAGTCAAAGGAGATGTTGTGACTGGAAGAAATCACCAAGGTCCAAGGCGATCCAGAGAATCCCGGGAAAAGCTCTTCAAGGGCCTACAGGTCTATTGTTGTGAGCCCTTCACCAACATGCCCAAAGATGAGCTGGAGAGGATGCTGCAGCTGTGTGGGGCTTCCGTGGTGAAGGAGCTTCCATCGCTCACCCATGACACAGGTGCTCATCTAGTTGTGATCGTGCAGCCAAGCGCCTGGACAGAAGACAGCAACTGCCCAGATATTGGGCAGCTGTGCAAGGCACGTCTTGTGATGTGGGACTGGGTGTTGGACAGTCTATCCAGCTACCGGTGTCGGGATCTGGATGCCTACCTGGTACAGAATATCACCTGTGACAGTAGTGAGCCACAAGACTCCAATGATTAA";

		// String s = "AAAAAA";
		// String t = "ATAAA";
		align(s, t, a, b);
	}

	public static void align(String s, String t, int a, int b){
		s = "-" + s; // 1-indexed later on
		t = "-" + t;

		//instantiation
		// System.out.println("|"+s+"|");
		// System.out.println("|"+t+"|");
		int sLength = s.length();
		int tLength = t.length();
		int[][] X = new int[sLength][tLength];
		int[][] X0 = new int[sLength][tLength];
		int[][] X1 = new int[sLength][tLength];
		int[][] X2 = new int[sLength][tLength];
		int[][] Y0 = new int[sLength][tLength];
		int[][] Y1 = new int[sLength][tLength];
		int[][] Y2 = new int[sLength][tLength];

		// initialization
		int limit = 0;
		X[0][0] = 0;
		for (int i = 1; i < sLength; i++){
			X[i][0] = limit; // + infinity
		}
		for (int j = 1; j < tLength; j++){
			X[0][j] = limit;
		}

		for (int i = 1; i < sLength; i++){
			X0[i][0] = (i%3 == 0) ? i*a : limit;
			X1[i][0] = (i%3 == 1) ? i*b : limit;
			X2[i][0] = (i%3 == 2) ? i*b : limit;
		}

		for (int j = 1; j < tLength; j++){
			Y0[0][j] = (j%3 == 0) ? j*a : limit;
			Y1[0][j] = (j%3 == 1) ? j*b : limit;
			Y2[0][j] = (j%3 == 2) ? j*b : limit;
		}
		// printMatrix(X);
		// printMatrix(X0);
		// printMatrix(X1);
		// printMatrix(X2);
		// printMatrix(Y0);
		// printMatrix(Y1);
		// printMatrix(Y2);
		// Iteration
		for (int i = 1; i < sLength; i++){
			for (int j = 1; j < tLength; j++){
				int mScore = getMatchScore(s.charAt(i),t.charAt(j));
				X[i][j] = mScore + max(
					extract(X,i-1,j-1),
					extract(X0,i-1,j-1),
					extract(X1,i-1,j-1),
					extract(X2,i-1,j-1),
					extract(Y0,i-1,j-1),
					extract(Y1,i-1,j-1),
					extract(Y2,i-1,j-1)
				);

				X0[i][j] = max(
					max(
						extract(X,i,j-3),
						extract(Y0,i,j-3),
						extract(Y1,i,j-3),
						extract(Y2,i,j-3)) + 3*a,
					extract(X0,i,j-3) + 3*a
				);

				X1[i][j] = max(
					max(
						extract(X,i,j-1),
						extract(Y0,i,j-1),
						extract(Y1,i,j-1),
						extract(Y2,i,j-1)) + b,
					extract(X1,i,j-3) + 3*b
				);

				X2[i][j] = max(
					max(
						extract(X,i,j-2),
						extract(Y0,i,j-2),
						extract(Y1,i,j-2),
						extract(Y2,i,j-2)) + 2*b,
					extract(X2,i,j-3) + 3*b
				);

				Y0[i][j] = max(
					max(
						extract(X,i-3,j),
						extract(X0,i-3,j),
						extract(X1,i-3,j),
						extract(X2,i-3,j)) + 3*a,
					extract(Y0,i-3,j) + 3*a
				);

				Y1[i][j] = max(
					max(
						extract(X,i-1,j),
						extract(X0,i-1,j),
						extract(X1,i-1,j),
						extract(X2,i-1,j)) + b,
					extract(Y1,i-3,j) + 3*b
				);

				Y2[i][j] = max(
					max(
						extract(X,i-2,j),
						extract(X0,i-2,j),
						extract(X1,i-2,j),
						extract(X2,i-2,j)) + 2*b,
					extract(Y2,i-3,j) + 3*b
				);
			}
		}
		// printMatrix(X);
		// printMatrix(X0);
		// printMatrix(X1);
		// printMatrix(X2);
		// printMatrix(Y0);
		// printMatrix(Y1);
		// printMatrix(Y2);
		int optimalScore = max(
					X[sLength-1][tLength-1],
					X0[sLength-1][tLength-1],
					X1[sLength-1][tLength-1],
					X2[sLength-1][tLength-1],
					Y0[sLength-1][tLength-1],
					Y1[sLength-1][tLength-1],
					Y2[sLength-1][tLength-1]
				);
		System.out.println("Optimal alignment score: "+ optimalScore);
	}
}