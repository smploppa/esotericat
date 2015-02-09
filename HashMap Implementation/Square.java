public class Square implements Quadrilateral {
	protected Point[] vertices;
	protected int size;
	public Square(){
		this(0, 0, 1);
	}

	public Square(int xStartVal, int yStartVal, int size) {
		vertices = new Point[NUMBER_OF_POINTS];
		vertices[0] = new Point(xStartVal, yStartVal);
		vertices[1] = new Point(xStartVal + size - 1, yStartVal);
		vertices[2] = new Point(xStartVal + size -1, yStartVal + size -1);
		vertices[3] = new Point(xStartVal, yStartVal + size - 1);
		this.size = size;
	}

	public void drawReverse(Grid drawingGrid, boolean isDrawReverse) {
		int xStart = vertices[0].getX();
		int xEnd = vertices[1].getX();
		int yTop = vertices[0].getY();
		int yBottom = vertices[3].getY();

		for(int i = 0; i <= size - 2; i++)
		{
			if (!isDrawReverse) {

				drawingGrid.setGridPoint(xStart + i, yTop, true);
				drawingGrid.setGridPoint(xEnd , yTop + i, true);
				drawingGrid.setGridPoint(xEnd - i, yBottom, true);
				drawingGrid.setGridPoint(xStart, yBottom - i, true);
			}
			else {
				drawingGrid.reverseGridPoint(xStart + i, yTop);
				drawingGrid.reverseGridPoint(xEnd , yTop + i);
				drawingGrid.reverseGridPoint(xEnd - i, yBottom);
				drawingGrid.reverseGridPoint(xStart, yBottom - i);
			}
		}
	}

	public void draw(Grid drawingGrid) {
		drawReverse(drawingGrid, false);
	}

	public void moveX(int x) {
		moveXY(x, 0);
	}

	public void moveY(int y){
		moveXY(0, y);
	}

	public void moveXY(int x, int y) {
		for (Point pointItem : vertices){
			pointItem.moveXY(x, y);
		}
	}

	@Override
	public String toString() {
		return (vertices[0].toString() + "; " + vertices[1].toString()
		+ "; " + vertices[2].toString() + "; " + vertices[3].toString() + ";");
	}

	public Point[] getVertices() {
		return vertices;
	}

	@Override
	public boolean equals(Object squ) {
		if (squ == this) {
			return true;
		}
		if (squ == null || this.getClass() != squ.getClass())
		{
			return false;
		}
		Square squr = (Square) squ;
		Point[] squVertices = squr.getVertices();
		if (vertices == null || squVertices == null || vertices.length != squVertices.length) {
			return false;
		}
		for (int i = 0; i < vertices.length; i++) {
			if ( !vertices[i].equals(squVertices[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 41;
		int result = 1;
		for(Point verts : vertices)
		{
			result = prime * result + ((verts == null) ? 0 : verts.hashCode());
		}
		return result;
	}

	public static void main(String args[]) {
    }
}