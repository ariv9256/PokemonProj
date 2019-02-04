package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexPanel extends JPanel
{
	private PokedexController pokedexController;
	private PokedexPanel pokedexPanel;
	private JLabel pursuit;
	private SpringLayout appLayout;
	
	public PokedexPanel(PokedexController pokedexController)
	{
		super();
		this.pokedexController = pokedexController;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		
	}
	private void setupLayout()
	{
		this.setLayout(appLayout);
	}
	private void setupListeners()
	{
		
	}
	
}
