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
	private JButton changeButton;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController pokedexApp)
	{
		super();
		this.pokedexApp = pokedexApp;
		
		this.appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource(""));
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		
		evolveField = new JTextField("false");
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 0, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 6, SpringLayout.EAST, evolveField);
		healthField = new JTextField("0");
		
		healthLabel = new JLabel("This pokemon's health is: ");
		
		numberLabel = new JLabel ("This pokemons' attack level is: ");
		
		evolveLabel = new JLabel ("This is my pokemon's enhancement label");
		
		nameLabel = new JLabel("My name is");
		
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		changeButton = new JButton("Click here to change values");
		
		pokedexDropdown = new JComboBox<String>();
		
		
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
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(enhanceLabel);
		this.add(attackLabel);
		
		this.add(changeButton);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.EAST, nameField, -128, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 6, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 65, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 6, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 6, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -211, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 10, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 112, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 6, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -39, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -372, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 35, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 43, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, -108, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -219, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -10, SpringLayout.EAST, this);
	}
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(pokedexApp.isInt(attackField.getText()) && pokedexApp.isDouble(enhancementField.getText()) && pokedexApp.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			pokedexApp.updatePokemon(index, data);
		}
	}
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "ultraball";
		String extension = ".png";
		try 
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		catch(NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				sendDataToController();
			}
		});
	}
	
}
