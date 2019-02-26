package pokemon.model;

public class DarkLion extends Pokemon implements WaterType, DarkType
{
	public DarkLion()
	{
		super(101010, "DarkLion");
	}
	public DarkLion(int num, String name)
	{
		super(num, name);
	}
	public String aquaRing()
	{
		System.out.println("DarkLion is using aquaring!");
		return aquaRing();
	}
	public void waterGun()
	{
		int liquid = 100;
		System.out.println("DarkLion's water gun did: " +liquid+ " Damage! Wow!");
	}
	public void pursuit()
	{
		System.out.println("DarkLion's pursuit did 60 damage!");
	}
	public int suckerPunch()
	{
		int hurt = (int)(Math.random() * 90);
		System.out.println("DarkLion's sucker punch did: "+hurt+" damage! Wow!");
		return suckerPunch();
	}
	public String bite()
	{
		System.out.println("You were bitten by DarkLion! Ouch..");
		return bite();
	}
}
