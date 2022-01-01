package store;

import java.util.ArrayList;

public class Holder 
{
	private ArrayList<String> holder = new ArrayList<>();
	
	public void add(String string)
	{
		holder.add(string);
	}
	
	public boolean contains(String string)
	{
		return holder.contains(string);
	}
}
