package pokemon.model;

public class Absol extends Pokemon implements DarkType
{
	public Absol()
	{
		super(359, "ABSOLutely");
	}
	public Absol(int num, String name)
	{
		super(num, name);
	}
	public int suckerPunch()
	{
		int punch = (int)(Math.random() * 60);
		System.out.println("ABSOLutely did: " + punch + " sucker punch damage!");
		return suckerPunch();
	}
	public void pursuit()
	{
		System.out.println("ABSOLutely is in pursuit of a Pursuit attack!");
	}
	public String bite()
	{
		System.out.println("ABSOLutely absolutely bit you!");
		return bite();
	}
}
