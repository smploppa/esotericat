import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class QuadSetsDisplay {

	public Quadrilateral readRectangle(Scanner s) {
		int x = s.nextInt();
		int y = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();
		return new Rectangle(x, y, width, height);
	}

	public Quadrilateral  readFilledSquare(Scanner s){
		int x = s.nextInt();
		int y = s.nextInt();
		int size = s.nextInt();
		boolean fill = s.nextBoolean();
		return new FilledSquare(x, y, size, fill);
	}

	public Quadrilateral readFilledRectangle(Scanner s) {
		int x = s.nextInt();
		int y = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();
		boolean fill = s.nextBoolean();
		return new FilledRectangle(x, y, width, height, fill);
	}

	public Quadrilateral readSquare (Scanner s) {
		int x = s.nextInt();
		int y = s.nextInt();
		int size = s.nextInt();
		return new Square(x, y, size);
	}

	public Quadrilateral readQuadrilateral(Scanner s) throws IOException {

		String qType = s.next();
		if (qType.equals("Square")) {
			return readSquare(s);
		}
		else if (qType.equals("FillSquare")) {
			return readFilledSquare(s);
		}
		if (qType.equals("Rect")) {
			return readRectangle(s);
		}
		else if (qType.equals("FillRect")) {
			return readFilledRectangle(s);
		}
		else {
			throw new IOException("Not a quadrilateral");
		}
	}

	public static void main(String args[]) throws IOException {

		if (args.length < 2) {
			System.out.println("Please provide 2 arguments, the names of the test input files.");
			System.exit(1);
		}
		QuadSetsDisplay myDisplayReader = new QuadSetsDisplay();
		Set<Quadrilateral> qSet1 = new HashSet<Quadrilateral>();
		Set<Quadrilateral> qSet2 = new HashSet<Quadrilateral>();
		Set<Quadrilateral> intersection = new HashSet<Quadrilateral>();
		Set<Quadrilateral> union = new HashSet<Quadrilateral>();
		Set<Quadrilateral> removeA = new HashSet<Quadrilateral>();
		Set<Quadrilateral> symmDiff = new HashSet<Quadrilateral>();
		Grid myGrid = new Grid(50, 50);

		Scanner s1 = null;
		Scanner s2 = null;

		try {
			s1 = new Scanner(new BufferedReader(new FileReader(args[0])));
			while (s1.hasNext()) {
				Quadrilateral q = myDisplayReader.readQuadrilateral(s1);
				qSet1.add(q);
			}
			s2 = new Scanner(new BufferedReader(new FileReader(args[1])));
			while (s2.hasNext()) {
				Quadrilateral q = myDisplayReader.readQuadrilateral(s2);
				qSet2.add(q);
			}

		} finally {
			if (s1 != null) {
				s1.close();
			}
			if (s2 != null) {
				s2.close();
			}
		}

		System.out.println("Set 1");
		Iterator itr = qSet1.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Quadrilateral q = (Quadrilateral) obj;
			q.draw(myGrid);
		}
		myGrid.printGrid();
		myGrid.emptyGrid();

		System.out.println("Set 2");
		itr = qSet2.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Quadrilateral q = (Quadrilateral) obj;
			q.draw(myGrid);
		}
		myGrid.printGrid();
		myGrid.emptyGrid();

		System.out.println("Intersection");
		intersection = new HashSet<Quadrilateral>(qSet1);
		intersection.retainAll(qSet2);
		itr = intersection.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Quadrilateral q = (Quadrilateral) obj;
			q.draw(myGrid);
		}
		myGrid.printGrid();
		myGrid.emptyGrid();

		System.out.println("Union");
		union =  new HashSet<Quadrilateral>(qSet1);
		union.addAll(qSet2);
		itr = union.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Quadrilateral q = (Quadrilateral) obj;
			q.draw(myGrid);
		}
		myGrid.printGrid();
		myGrid.emptyGrid();

		System.out.println("Remove all, s2");
		removeA =  new HashSet<Quadrilateral>(qSet1);
		removeA.removeAll(qSet2);
		itr = removeA.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Quadrilateral q = (Quadrilateral) obj;
			q.draw(myGrid);
		}
		myGrid.printGrid();
		myGrid.emptyGrid();

		System.out.println("Symmetric Difference");
		symmDiff =  new HashSet<Quadrilateral>(qSet1);
		symmDiff.addAll(qSet2);
		Set<Quadrilateral> tmp = new HashSet<Quadrilateral>(qSet1);
		tmp.retainAll(qSet2);
		symmDiff.removeAll(tmp);
		itr = symmDiff.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Quadrilateral q = (Quadrilateral) obj;
			q.draw(myGrid);
		}
		myGrid.printGrid();
	}
}