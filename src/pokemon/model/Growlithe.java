package pokemon.model;

public class Growlithe extends Pokemon implements FireType
{
	public Growlithe()
	{
		super(58, "Smol tiger");
	}
	public Growlithe(int num, String name)
	{
		super(num, name);
	}
	public int flamethrower()
	{
		int flame = (int)(Math.random()* 90);
		System.out.println("Smol tiger did: "+flame+ " flamethrower damage!");
		return flamethrower();
	}
	public void inferno()
	{
		System.out.println("Smol tiger's inferno left a burn!");
	}
	public String firespin()
	{
		System.out.println("Smol tiger did 45 firespin damage!");
		return firespin();
	}

}
