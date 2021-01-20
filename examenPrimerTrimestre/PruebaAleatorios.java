package examenPrimerTrimestre;

public class PruebaAleatorios {
	public static void main(String[] args) {
		int[][] alumnosNotas = new int[15][5];

		for (int i = 0; i < 15; ++i) {
			for (int j = 0; j < 5; ++j) {
				alumnosNotas[i][j] = (int) (Math.random()*12) - 1;
			}
		}

		for (int a = 0; a < 15; ++a) {
			System.out.println();
			for (int b = 0; b < 5; ++b) {
				System.out.printf("%d ", alumnosNotas[a][b]);
			}
		}
 }
}
