package pokemon.controller;

import java.util.ArrayList;
import pokemon.model.*;
import pokemon.view.*;
import javax.swing.JOptionPane;

public class PokedexController 
{
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame pokedexApp;

	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>(pokemonList);
		addPokemon();
	}
	public void start()
	{
		
	}
	public ArrayList<Pokemon> getPokemonList()
	{
		return getPokemonList();
	}
	public void addPokemon()
	{
		pokemonList.add(new Absol(359, "ABSOLutely"));
		pokemonList.add(new Charmander(4, "Fire boy"));
		pokemonList.add(new Growlithe(58, "Smol tiger"));
		pokemonList.add(new Vaporeon(134, "One of many eevee"));
		pokemonList.add(new Zorua(570, "Little floof"));
	}
	public void updatePokemon(int index, String[] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
			
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
	public boolean validInt(String pokeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(pokeInt);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null., "Please type in a real number trainer");
		}
		return isValid;
	}
}
