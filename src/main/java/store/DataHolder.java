package store;

import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder 
{
	private ArrayList<UserStore> names = new ArrayList<>();
	private HashMap<String, DataHolder[]> hash = new HashMap<String, DataHolder[]>();
	private String state = "";
	public DataHolder(String task)
	{
		if(task.equalsIgnoreCase("array"))
		{
			this.state = "array";
		}else if(task.equalsIgnoreCase("hash"))
		{
			this.state = "hash";
		}else
		{
			this.state = "";
		}
	}
	
	public void add(UserStore obj)
	{
		if(state.equalsIgnoreCase("array"))
		{
			UserStore item = obj;
			names.add(item);
		}
	}
	
	public void add(String key, DataHolder[] dataholder)
	{
		if(state.equalsIgnoreCase("hash"))
		{
			hash.put(key, dataholder);
		}
	}
	
	public ArrayList<UserStore> getNames()
	{
		if(state.equalsIgnoreCase("array"))
		{
			return names;
		}
		return null;
	}
	
	public DataHolder[] getHash(String key)
	{
		if(state.equalsIgnoreCase("hash"))
		{
			return hash.get(key);
		}
		return null;
	}
	
	public String getState()
	{
		return this.state;
	}
	
}
