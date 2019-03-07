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
		
		this.pokemonIcon = new ImageIcon(getClass().getResource(""));
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		attackField = new JTextField("0");
		healthLabel = new JLabel("This pokemon's health is: ");
		numberLabel = new JLabel ("This pokemons' attack level is: ");
		evolveLabel = new JLabel ("This pokemon can evolve: ");
		nameLabel = new JLabel("My name is: ");
		enhanceLabel = new JLabel("This pokemon's enhancement modifier is: ");
		attackLabel = new JLabel("Attack points: " );
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		changeButton = new JButton("Click here to change values");
		saveButton = new JButton("Save!");
		pokedexDropdown = new JComboBox<String>();
		
		
		
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
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 0, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 479, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -65, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 32, SpringLayout.NORTH, this);
		
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, -37, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 18, SpringLayout.EAST, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -37, SpringLayout.WEST, enhancementField);
		
		
		
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, evolveField);
		
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, evolveField);
		
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -15, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, evolveField);
		
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -372, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 14, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 114, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -60, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 6, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, evolveField);
		
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 6, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -15, SpringLayout.NORTH, enhanceLabel);
		
		
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -58, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.SOUTH, evolveLabel, -6, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 0, SpringLayout.WEST, evolveField);
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, -44, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 54, SpringLayout.EAST, changeButton);
		
		
		
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -6, SpringLayout.NORTH, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 14, SpringLayout.NORTH, changeButton);
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
