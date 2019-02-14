package pokemon.model;

public class Charmander extends Pokemon implements FireType
{
	public Charmander()
	{
		super(4, "Fire boy");
	}
	public Charmander(int num, String name)
	{
		super(num, name);
	}
	public int flamethrower()
	{
		int flame = (int) (Math.random() * 40);
		System.out.println("Fire boy did: " + flame + " flamethrower damage!");
		return flamethrower();
	}
	public void inferno()
	{
		System.out.println("Fire boy used inferno!");
	}
	public String firespin()
	{
		System.out.println("Firespin did quite the damage!");
		return firespin();
	}

}
