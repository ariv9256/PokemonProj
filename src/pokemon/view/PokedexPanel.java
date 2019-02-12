package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexPanel extends JPanel
{
	private PokedexController pokedexApp;
	private PokedexPanel pokedexPanel;
	private SpringLayout appLayout;
	
	private JTextField numberField;
	private JTextField pokedexDropdown;
	private JTextField nameField; 
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	public PokedexPanel(PokedexController pokedexApp)
	{
		super();
		this.pokedexApp = pokedexApp;
		
		this.appLayout = new SpringLayout();
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		healthLabel = new JLabel("This pokemon's health is: ");
		numberLabel = new JLabel ("This pokemons' attack level is: ");
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(pokedexDropdown);
		this.add(healthField);
	}
	private void setupLayout()
	{
		this.setLayout(appLayout);
	}
	private void setupListeners()
	{
		
	}
	
}
