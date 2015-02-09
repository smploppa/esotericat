public class Point {
	private int x;
	private int y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(int xVal, int yVal){
		x = xVal;
		y = yVal;
	}

	public Point(Point copyPoint){
		x = copyPoint.getX();
		y = copyPoint.getY();
	}

	public int getX(){
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveX(int xMove) {
		x = x + xMove;
	}

	public void moveY(int yMove) {
		y = y + yMove;
	}

	public void moveXY(int xMove, int yMove) {
			x = x + xMove;
			y = y + yMove;
	}

	public String toString() {
		return new String(x + ", " + y);
	}

	@Override
	public boolean equals(Object point2)
	{
		if (point2 == this) {
			return true;
		}
		if (point2 == null || point2.getClass() != this.getClass()) {
			return false;
		}
		Point p2 = (Point) point2;
		return (x == p2.getX()) && (y == p2.getY());
	}


	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + new Integer(x).hashCode();
		result = prime * result + new Integer(y).hashCode();
		return result;
	}

	public static void main(String args[]) {
		int[] intArg = {0, 0};
		if (args.length > 1) {
			for (int i = 0; i < 2; i++)
			{
				try {
					intArg[i] = Integer.parseInt(args[i]);
				} catch (NumberFormatException e) {
					System.err.println("Argument" + args[i] + " must be an integer.");
					System.exit(1);
				}
			}
		}
		Point myPoint = new Point(intArg[0], intArg[1]);
		Point myPoint2 = new Point(myPoint);
		System.out.println(myPoint.toString());
		System.out.println(myPoint.equals(myPoint2));
		myPoint.moveXY(2,3);
		System.out.println(myPoint.toString());
		System.out.println(myPoint.equals(myPoint2));

    }
}