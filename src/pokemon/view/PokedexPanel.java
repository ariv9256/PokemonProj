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
	private JComboBox<String> pokedexDropdown;
	
	private JTextField numberField;
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
		evolveLabel = new JLabel ("This is my pokemon's enhancement label");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("pokemon goes here");
		changeButton = new JLabel("Click here to change values");
		pokedexDropdown = new JComboBox<String>();//stub
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupDropdown()
	{
		DefaultComboBoxModel temp = new DefaultComboBoxModel(pokedexApp.buildPokedexText());
		pokedexDropdown.setModel();
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(pokedexDropdown);
		this.add(healthField);
		this.add(numberField);
		this.add(evolveField);
		this.add(enhancementField);
		this.add(attackField);
		this.add(nameField);
		
		this.add(healthLabel);
		this.add(numberLabel);
	}
	private void setupLayout()
	{
		this.setLayout(appLayout);
	}
	private void setupListeners()
	{
		
	}
	
}
