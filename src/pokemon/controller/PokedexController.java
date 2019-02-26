package pokemon.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import pokemon.model.*;
import pokemon.view.*;
import java.io.*;


public class PokedexController 
{
	private String saveFile = "backup.pokemon";
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame pokedexApp;

	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>(pokemonList);
		addPokemon();
		pokedexApp = new PokedexFrame(this);
	}
	public void start()
	{
		loadPokedex();
	}
	public ArrayList<Pokemon> getPokemonList()
	{
		return getPokemonList();
	}
	public void addPokemon()
	{
		pokemonList.add(new Absol(359, "ABSOLutely"));
		pokemonList.add(new Charmander(4, "Fire boy"));
		pokemonList.add(new DarkLion(101010, "Special"));
		pokemonList.add(new Growlithe(58, "Smol tiger"));
		pokemonList.add(new Vaporeon(134, "One Eeveolution"));
		pokemonList.add(new Zorua(570, "Little floof"));
	}
	public void updatePokemon(int index, String[] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
			
		}
	}
	public PokedexFrame getFrame()
	{
		return pokedexApp;
	}
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);
			output.close();
			saveStream.close();
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(pokedexApp, error.getMessage(), "File error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void loadPokedex()
	{
		try
		{
			ArrayList<Pokemon> saved = new ArrayList<Pokemon>();
			FileInputStream inputStream = new FileInputStream(saveFile);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			saved = (ArrayList<Pokemon>) input.readObject();
			input.close();
			inputStream.close();
			pokemonList = saved;
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(pokedexApp, "No Save File", "Loading Pokemon", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(ClassNotFoundException pokemonError)
		{
			JOptionPane.showMessageDialog(pokedexApp, pokemonError.getMessage(), "Type error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public String[] buildPokedexText()
	{
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
	public boolean isInt(String pokeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(pokeInt);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "Please type in a real number trainer");
		}
		return isValid;
	}
	public boolean isDouble(String pokeDouble)
	{
		boolean isValid = false;
		
		try
		{
			Double.parseDouble(pokeDouble);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "Please type in a decimal value");
		}
		return isValid;
	}
}
