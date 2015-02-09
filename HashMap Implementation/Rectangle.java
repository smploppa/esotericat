public class Rectangle implements Quadrilateral {
	protected Point[] vertices;

	public Rectangle(){
		this(0, 0, 1, 1);
	}

	public Rectangle(int xStartVal, int yStartVal, int width, int height) {
		vertices = new Point[NUMBER_OF_POINTS];
		vertices[0] = new Point(xStartVal, yStartVal);
		vertices[1] = new Point(xStartVal + width - 1, yStartVal);
		vertices[2] = new Point(xStartVal + width -1, yStartVal + height -1);
		vertices[3] = new Point(xStartVal, yStartVal + height - 1);
	}

	public void drawReverse(Grid drawingGrid, boolean isDrawReverse) {
		int xStart = vertices[0].getX();
		int xEnd = vertices[1].getX();
		int yTop = vertices[0].getY();
		int yBottom = vertices[3].getY();

		for(int i = xStart; i <= xEnd; i++)
		{
			if (!isDrawReverse) {

				drawingGrid.setGridPoint(i, yTop, true);
				drawingGrid.setGridPoint(i, yBottom, true);
			}
			else {
				drawingGrid.reverseGridPoint(i, yTop);
				drawingGrid.reverseGridPoint(i, yBottom);
			}
		}
		for(int i = yTop + 1; i < yBottom ; i++)
		{
			if (!isDrawReverse) {

				drawingGrid.setGridPoint(xStart, i,  true);
				drawingGrid.setGridPoint(xEnd, i,  true);
			}
			else {
				drawingGrid.reverseGridPoint(xStart, i );
				drawingGrid.reverseGridPoint(xEnd, i);
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
	public boolean equals(Object Rect) {
		if (Rect == this) {
			return true;
		}
		if (Rect == null || this.getClass() != Rect.getClass())
		{
			return false;
		}
		Rectangle rct = (Rectangle) Rect;
		Point[] RectVertices = rct.getVertices();
		if (vertices == null || RectVertices == null || vertices.length != RectVertices.length) {
			System.out.println("3");
			return false;
		}
		for (int i = 0; i < vertices.length; i++) {
			if ( !vertices[i].equals(RectVertices[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 19;
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