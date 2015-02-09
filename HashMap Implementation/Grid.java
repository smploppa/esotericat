public class Grid {
	public static final int DEFAULT_SIZE  = 50;
	public static final char DEFAULT_CHAR = '*';
	private boolean[][] gridArray;
	private int height;
	private int width;
	private char fillChar;

	public Grid() {
		height = DEFAULT_SIZE;
		width = DEFAULT_SIZE;
		fillChar = DEFAULT_CHAR;
		gridArray = new boolean[width][height];
	}
	public Grid(int xSize, int ySize) {
		height = ySize;
		width = xSize;
		fillChar = DEFAULT_CHAR;
		gridArray = new boolean[width][height];
	}
	public Grid(int xSize, int ySize, char fillC) {
		height = ySize;
		width = xSize;
		fillChar = fillC;
		gridArray = new boolean[width][height];
	}

	public int getHeight()
	{
		return height;
	}
	public int getwidth()
	{
		return width;
	}
	public void setGridPoint(int x, int y, boolean gridPointOn) {
		if (x >= width || y >= height) {
			return;
		}
		gridArray[x][y] = gridPointOn;
	}
	public void reverseGridPoint(int x, int y) {
		if (x >= width || y >= height) {
			return;
		}
		gridArray[x][y] = !gridArray[x][y];
	}
	public boolean gridPointOn(int x, int y) {
		if (x >= width || y >= height) {
			return false;
		}
		return gridArray[x][y];
	}
	public void reverseGrid() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				gridArray[i][j] = !gridArray[i][j];
			}
		}
	}
	public void emptyGrid() {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					gridArray[i][j] = false;
				}
			}
	}
	public void printGrid() {
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if(gridArray[j][i]){
							System.out.print(fillChar);
						} else {
							System.out.print(" ");
						}
					}
					System.out.println("");
				}
	}
	public static void main(String args[]) {
    }
}