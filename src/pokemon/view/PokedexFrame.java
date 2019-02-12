package pokemon.view;

import javax.swing.JFrame;
import pokemon.controller.PokedexController;

public class PokedexFrame extends JFrame
{
	private PokedexController pokedexApp;
	private PokedexPanel pokedexPanel;
	
	public PokedexFrame()
	{
		super();
		this.pokedexApp = pokedexApp;
		this.pokedexPanel = new PokedexPanel(pokedexApp);
		
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(pokedexPanel);
		this.setSize(800, 800);
		this.setTitle("GOTTA CATCH 'EM ALL");
		this.setResizable(true);
		this.setVisible(true);
	}
	
}
