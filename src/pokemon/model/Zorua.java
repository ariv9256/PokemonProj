package pokemon.model;

public class Zorua extends Pokemon implements DarkType
{
	public Zorua()
	{
		super(570, "Little floof");
	}
	public Zorua(int num, String name)
	{
		super(num, name);
	}
	public void pursuit()
	{
		System.out.println("Little floof was in pursuit and her Persuit did 50 damage!");
	}
	public int suckerPunch()
	{
		int punch = (int)(Math.random() * 70);
		System.out.println("Little floof's sucker punch did: "+punch+" damage!");
		return suckerPunch();
	}
	public String bite()
	{
		System.out.println("You were bitten by a floof!");
		return bite();
	}

}
