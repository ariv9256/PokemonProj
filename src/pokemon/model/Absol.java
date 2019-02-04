package pokemon.model;

public class Absol extends Pokemon implements DarkType
{
	public Absol(int suckerPunch, String pursuit)
	{
		super(suckerPunch, pursuit);
	}
	public void pursuit()
	{
		System.out.println("Pursuit is dangerous! careful, absol does: " + getDamage() + "damage!");
	}
	public int suckerPunch()
	{
		return this.getHealthPoints();
	}
}
