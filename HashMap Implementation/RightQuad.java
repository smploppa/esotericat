public interface Quadrilateral {
	public static final int NUMBER_OF_POINTS  = 4;
	public void draw(Grid drawingGrid);
	public void drawReverse(Grid drawingGrid, boolean isDrawReverse);
	public void moveX(int x);
	public void moveY(int y);
	public void moveXY(int x, int y);

}