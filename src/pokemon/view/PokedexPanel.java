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
	private JButton saveButton;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController pokedexApp)
	{
		super();
		this.pokedexApp = pokedexApp;
		this.appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/image/masterball.png"));
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		attackField = new JTextField("0");
		healthLabel = new JLabel("This pokemon's health is: ");
		numberLabel = new JLabel ("This pokemons' pokedex number is: ");
		evolveLabel = new JLabel ("This pokemon can evolve: ");
		nameLabel = new JLabel("My name is: ");
		enhanceLabel = new JLabel("This pokemon's enhancement modifier is: ");
		attackLabel = new JLabel("Attack points: " );
		imageLabel = new JLabel("pokemon goes here: ", pokemonIcon, JLabel.CENTER);
		
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -15, SpringLayout.EAST, this);
		changeButton = new JButton("Click here to change values");
		saveButton = new JButton("Save!");
		pokedexDropdown = new JComboBox<String>();
		
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, 49, SpringLayout.NORTH, pokedexDropdown);
		
		
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupDropdown()
	{
		DefaultComboBoxModel temp = new DefaultComboBoxModel(pokedexApp.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);

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
		this.add(saveButton);
		this.add(pokedexDropdown);
		
		this.add(imageLabel);
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, attackField, 6, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 32, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 387, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -69, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -367, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, evolveField);
		
		
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 78, SpringLayout.NORTH, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 10, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 16, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 6, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 10, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 6, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 24, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 10, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -159, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -24, SpringLayout.NORTH, attackField);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 19, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 7, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 114, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 10, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -351, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 0, SpringLayout.WEST, healthLabel);
		
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -255, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -76, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, -198, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -46, SpringLayout.EAST, this);
		
	}
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(pokedexApp.isInt(attackField.getText()) && pokedexApp.isDouble(enhancementField.getText()) && pokedexApp.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			data[5] = numberField.getText();
			
			pokedexApp.updatePokemon(index, data);
			repaint();
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
	private void updateFields(int index)
	{
		String[] data = pokedexApp.getPokeData(index);
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
		
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
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				pokedexApp.savePokedex();
			}
		});
		pokedexDropdown.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent click)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				updateFields(pokedexDropdown.getSelectedIndex());
				changeImageDisplay(name);
			}
		});
		
	}
	
	
}
