public class FilledSquare extends Square implements FilledQuadrilateral {
	protected boolean isFilled;

	public FilledSquare() {
		this(0, 0, 1);
	}

	public FilledSquare(int xStartVal, int yStartVal, int size) {
		this(xStartVal, yStartVal, size, false);
	}

	public FilledSquare(int xStartVal, int yStartVal, int size, boolean isFilled) {
		super(xStartVal, yStartVal, size);
		this.isFilled = isFilled;
	}

	public void setFill(boolean fill){
		isFilled = fill;
	}

	public void reverseFill() {
		isFilled = !isFilled;
	}

	public boolean getFill(){
		return isFilled;
	}

	@Override
	public void drawReverse(Grid drawingGrid, boolean isDrawReverse){
		if (!isFilled) {
			super.drawReverse(drawingGrid, isDrawReverse);
			return;
		} else {
			int xStart = vertices[0].getX();
			int xEnd = vertices[1].getX();
			int yTop = vertices[0].getY();
			int yBottom = vertices[3].getY();

			for(int j = yTop; j <= yBottom; j++) {
				for(int i = xStart; i <= xEnd ; i++) {
					if (!isDrawReverse) {
						drawingGrid.setGridPoint(i, j, true);
					} else {
						drawingGrid.reverseGridPoint(i, j);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return new String(super.toString() + (getFill() ? " filled" : " not filled"));
	}

	@Override
	public boolean equals(Object fillSqu) {
		if (fillSqu == this) {
			return true;
		}
		if (fillSqu == null || this.getClass() != fillSqu.getClass())
		{
			return false;
		}
		FilledSquare squr = (FilledSquare) fillSqu;
		Point[] squVertices = squr.getVertices();
		if (vertices == null || squVertices == null || vertices.length != squVertices.length) {
			return false;
		}
		for (int i = 0; i < vertices.length; i++) {
			if ( !vertices[i].equals(squVertices[i])) {
				return false;
			}
		}
		if (isFilled != squr.getFill()) {
			return false;
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
		result = prime * result + new Boolean(isFilled).hashCode();
		return result;
	}

	public static void main(String args[]) {
    }
}