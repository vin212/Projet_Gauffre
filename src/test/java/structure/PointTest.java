package structure;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PointTest {

	@Test
	public void testSameCoordinatevalues() {
		Point comparePoint = new Point(1, 2);
		assertEquals(0, new Point(1, 2).CompareTo(comparePoint));

	}

	@Test
	public void testGreaterYCoordinateOfCurrentPoint() {
		Point comparePoint = new Point(1, 1);
		assertEquals(1, new Point(1, 3).CompareTo(comparePoint));

	}

	@Test
	public void testGreaterYCoordinateOfInputPoint() {
		Point comparePoint = new Point(1, 3);
		assertEquals(-1, new Point(1, 1).CompareTo(comparePoint));

	}

	@Test
	public void testLesserXCoordinateOfInputPoint() {
		Point comparePoint = new Point(1, 1);
		assertEquals(1, new Point(2, 1).CompareTo(comparePoint));

	}

	@Test
	public void testGreaterXCoordinateOfInputPoint() {
		Point comparePoint = new Point(3, 2);
		assertEquals(-1, new Point(1, 2).CompareTo(comparePoint));

	}

	@Test
	public void testToString() {
		String expected = ("( " + 1 + ", " + 2 + ")");
		String actual = new Point(1, 2).toString();
		assertEquals(expected, actual);
	}
}