package pokemon.model;

public class Vaporeon extends Pokemon implements WaterType
{
	public Vaporeon()
	{
		super(134, "One Eeveolution");
	}
	public Vaporeon(int num, String name)
	{
		super(num, name);
	}
	public String aquaRing()
	{
		System.out.println("One Eeveolution is using aquaRing!");
		return aquaRing();
	}
	public void waterGun()
	{
		int water = 35;
		System.out.println("One Eeveolution's water gun does: "+water+" damage");
	}

}
