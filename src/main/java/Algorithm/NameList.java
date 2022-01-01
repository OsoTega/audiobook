package Algorithm;

import java.util.ArrayList;

public class NameList {
	
	static String[] holder;
	static ArrayList<String> holder_ = new ArrayList<>();

	private static int factorial(int num)
	{
		int fac = 1;
		for(int i = 0; i < num; i++)
		{
			fac *= (num - i); 
		}
		return fac;
	}
	private static void sortName(String name)
	{
		try
		{
			String[] words = name.trim().split("\\s+");
			int size = words.length;
			int fac = factorial(size);
			holder = new String[fac];
			String[] wordFormat = new String[words.length];
			for(int i = 0; i < words.length; i++)
			{
				wordFormat[i] = words[i];
			}
			
			permute(wordFormat, 0, size-1);
			
		}catch(Exception e)
		{
			System.out.println("Exception");
			e.printStackTrace();
		}
	}
	
	private static void permute(String[] word, int l, int j)
	{
		String id_word = ""; 
		if(l == j)
		{
			for(String wor : word)
			{
				id_word+=(wor+" ");
			}
			holder_.add(id_word);
		}else
		{
			for(int i = l; i <= j; i++)
			{
				word = switchWords(word, l, i);
				permute(word, l+1, j);
				word = switchWords(word, l, i);
			}
		}
	}
	
	private static String[] switchWords(String[] word, int i, int j)
	{
		String temp;
		temp = word[i];
		word[i] = word[j];
		word[j] = temp;
		return word;
	}
	
	public static String[] getNames(String name)
	{
		sortName(name.trim());
		for(int i = 0; i < holder.length; i++)
		{
			holder[i] = holder_.get(i);
		}
		return holder;
	}
	
	public static void main(String[] args) 
	{
		String[] names = getNames("Tega Steve Osowa");
		for(int i = 0; i < names.length; i++)
		{
			System.out.println(names[i]);
		}
	}

}
