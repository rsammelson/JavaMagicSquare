package magicSquare;

public class MagicSquare {
	int [] [] magicSquare;

	public MagicSquare () {
		// TODO generate square
	}

	public MagicSquare (int [] [] square) throws InvalidSquareException {
		if (square == null || square.length == 0 || square[0] == null || square[0].length == 0) {
			throw new InvalidSquareException("The \"square\" argument cannot be null.");
		}
		for (int [] row : square) {
			if (row.length != square[0].length) {
				throw new InvalidSquareException("All rows in the \"square\" array must have the same length.");
			}
		}
		if (square.length != square[0].length) {
			throw new InvalidSquareException("The \"square\" argument must have equal dimensions.");
		}
		for (int [] row : square) {
			for (int i : row) {
				if (i < 0) {
					throw new InvalidSquareException("All numbers in the \"square\" array must not be less than zero.");
				}
			}
		}
		if (!checkIfValidSquareSimple(square)) {
			throw new InvalidSquareException("The \"square\" argument must be a valid magic square.");
		}
		magicSquare = square;
	}

	public static boolean checkIfValidSquareSimple (int [] [] square) {
		for (int [] row : square) {
			int sum = sumArray(row);
			if (sum != sumArray(square[0])) {
				return false;
			}
		}
		for (int i = 0; i < square[0].length; i++) {
			// TODO check columns
		}
		// TODO check diagonals
		return true;
	}

	private static int sumArray (int [] n) {
		int sum = 0;
		for (int i : n) {
			sum += i;
		}
		return sum;
	}
}
