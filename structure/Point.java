package structure;

public class Point 
{
	int x;
	int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getx()
	{
		return this.x;
	}

	public int gety()
	{
		return this.y;
	}

	public boolean CompareTo (Point p)
	{
		return (p.x == this.x && p.y == this.y);
	}

}