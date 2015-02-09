public class FilledRectangle extends Rectangle implements FilledQuadrilateral {
	protected boolean isFilled;

	public FilledRectangle() {
		this(0, 0, 1, 1, false);
	}

	public FilledRectangle(int xStartVal, int yStartVal, int width, int height, boolean isFilled) {
		super(xStartVal, yStartVal, width, height);
		this.isFilled = isFilled;
	}

	public void setFill(boolean fill) {
		isFilled = fill;
	}

	public void reverseFill() {
		isFilled = !isFilled;
	}

	public boolean getFill() {
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
	public boolean equals(Object fillRct) {
		if (fillRct == this) {
			return true;
		}
		if (fillRct == null || this.getClass() != fillRct.getClass())
		{
			return false;
		}
		FilledRectangle fRct = (FilledRectangle) fillRct;
		Point[] fRectVertices = fRct.getVertices();
		if (vertices == null || fRectVertices == null || vertices.length != fRectVertices.length) {
			return false;
		}
		for (int i = 0; i < vertices.length; i++) {
			if ( !vertices[i].equals(fRectVertices[i])) {
				return false;
			}
		}
		if (isFilled != fRct.getFill()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 13;
		int result = 1;
		for(Point verts : vertices)
		{
			result = prime * result + ((verts == null) ? 0 : verts.hashCode());
		}
		result = prime * result + new Boolean(isFilled).hashCode();
		return result;
	}
}