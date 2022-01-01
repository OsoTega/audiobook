package Algorithm;

public class Ranking {

	final static double[] WORD = new double[3];
	final static double DIVISOR = WORD.length;
	private static double vectorSum(double[] vector)
	{
		double sum = 0;
		for(int i = 0; i < vector.length; i++)
		{
			sum+=vector[i];
		}
		return sum;
	}
	public static double searchProbability(String searchword, String search)
	{
		String word = searchword;
		try {
			String[] words = word.trim().split("\\s+");
			String[] searchs = search.trim().split("\\s+");
			double first_word_total = 0;
			double[] next_data = new double[words.length];
			double next_word_total = 0;
			double[] cal = new double[words.length];
			double[] extra = new double[1];
			double prob = 0;
			if((words.length - searchs.length) == 0)
			{
				for(int i = 0; i < words.length; i++)
				{
					String i_word = words[i];
					String i_search = searchs[i];
					if((i_word.length() - i_search.length()) == 0)
					{
						char[] letters = i_word.toCharArray();
						char[] cha = i_search.toCharArray();
						double[] chaVector = new double[letters.length];
						for(int j = 0; j < letters.length; j++)
						{
							if(letters[j] == cha[j])
							{
								chaVector[j] = 1;
							}else
							{
								chaVector[j] = 0;
							}
						}
						first_word_total = vectorSum(chaVector)/chaVector.length;
					}else {
						if(i_word.length() > i_search.length())
						{
							char[] letters = i_word.toCharArray();
							char[] cha = i_search.toCharArray();
							double[] chaVector = new double[letters.length];
							int size_n = i_word.length() - i_search.length();
							char[] newcha = new char[cha.length+size_n];
							for(int c = 0; c < cha.length; c++)
							{
								newcha[c] = cha[c];
							}
							
							cha = newcha;
							for(int o = 0; o < cha.length; o++)
					        {
								char item = cha[o];
					        	if(item == 0)
					        	{
					        		item = '#';
					        		cha[o] = item;
					        	}
					        }
							for(int j = 0; j < letters.length; j++)
							{
								if(letters[j] == cha[j])
								{
									chaVector[j] = 1;
								}else
								{
									chaVector[j] = 0;
								}
							}
							first_word_total = vectorSum(chaVector)/chaVector.length;
						}else if(i_word.length() < i_search.length())
						{
							char[] letters = i_word.toCharArray();
							char[] cha = i_search.toCharArray();
							double[] chaVector = new double[letters.length];
							for(int j = 0; j < letters.length; j++)
							{
								if(letters[j] == cha[j])
								{
									chaVector[j] = 1;
								}else
								{
									chaVector[j] = 0;
								}
							}
							first_word_total = vectorSum(chaVector)/chaVector.length;
						}
					}
					next_data[i] = first_word_total;
					first_word_total = 0;
				}
				next_word_total = vectorSum(next_data)/next_data.length;
				for(int v = 0; v < words.length; v++)
				{
					if(searchs[v].equalsIgnoreCase(words[v]))
					{
						cal[v]+=1;
					}else
					{
						cal[v]+=0;
					}
				}
				double attr1 = vectorSum(cal)/cal.length;
				double c = words.length - searchs.length;
				if(c == 0)
				{
					extra[0] = 1;
				}
				double attr2 = vectorSum(extra)/extra.length;
				WORD[0] = next_word_total;
				WORD[1] = attr1;
				WORD[2] = attr2;
				prob = vectorSum(WORD)/DIVISOR;
				return prob;
				}else {
				if(words.length > searchs.length)
				{
					int size = words.length - searchs.length;
					String[] newsearch = new String[searchs.length+size];
					for(int c = 0; c < searchs.length; c++)
					{
						newsearch[c] = searchs[c];
					}
					
					searchs = newsearch;
					for(int o = 0; o < searchs.length; o++)
			        {
						String item = searchs[o];
			        	if(item == null)
			        	{
			        		item = "#";
			        		searchs[o] = item;
			        	}
			        }
					
			        for(int i = 0; i < words.length; i++)
					{
						String i_word = words[i];
						String i_search = searchs[i];
						if((i_word.length() - i_search.length()) == 0)
						{
							char[] letters = i_word.toCharArray();
							char[] cha = i_search.toCharArray();
							double[] chaVector = new double[letters.length];
							for(int j = 0; j < letters.length; j++)
							{
								if(letters[j] == cha[j])
								{
									chaVector[j]=1;
								}else
								{
									chaVector[j]=0;
								}
							}
							first_word_total = vectorSum(chaVector)/chaVector.length;
						}else {
							if(i_word.length() > i_search.length())
							{
								char[] letters = i_word.toCharArray();
								char[] cha = i_search.toCharArray();
								int size_n = i_word.length() - i_search.length();
								double[] chaVector = new double[letters.length];
								char[] newcha = new char[cha.length+size_n];
								for(int c = 0; c < cha.length; c++)
								{
									newcha[c] = cha[c];
								}
								
								cha = newcha;
								for(int o = 0; o < cha.length; o++)
						        {
									char item = cha[o];
						        	if(item == 0)
						        	{
						        		item = '#';
						        		cha[o] = item;
						        	}
						        }
								for(int j = 0; j < letters.length; j++)
								{
									if(letters[j] == cha[j])
									{
										chaVector[j]=1;
									}else
									{
										chaVector[j]=0;
									}
								}
								first_word_total = vectorSum(chaVector)/chaVector.length;
							}else if(i_word.length() < i_search.length())
							{
								char[] letters = i_word.toCharArray();
								char[] cha = i_search.toCharArray();
								double[] chaVector = new double[letters.length];
								for(int j = 0; j < letters.length; j++)
								{
									if(letters[j] == cha[j])
									{
										chaVector[j]=1;
									}else
									{
										chaVector[j]=0;
									}
								}
								first_word_total = vectorSum(chaVector)/chaVector.length;
							}
						}
						next_data[i]=first_word_total;
						first_word_total = 0;
					}
			        next_word_total = vectorSum(next_data)/next_data.length;
					for(int v = 0; v < words.length; v++)
					{
						if(searchs[v].equalsIgnoreCase(words[v]))
						{
							cal[v]+=1;
						}else
					{
						cal[v]+=0;
					}
				}
				double attr1 = vectorSum(cal)/cal.length;
				double c = words.length - searchs.length;
				if(c == 0)
				{
					extra[0] = 1;
				}
				double attr2 = vectorSum(extra)/extra.length;
				WORD[0] = next_word_total;
				WORD[1] = attr1;
				WORD[2] = attr2;
				prob = vectorSum(WORD)/DIVISOR;
				return prob;
				}else if(words.length < searchs.length)
				{
			        for(int i = 0; i < words.length; i++)
					{
						String i_word = words[i];
						String i_search = searchs[i];
						if((i_word.length() - i_search.length()) == 0)
						{
							char[] letters = i_word.toCharArray();
							char[] cha = i_search.toCharArray();
							double[] chaVector = new double[letters.length];
							for(int j = 0; j < letters.length; j++)
							{
								if(letters[j] == cha[j])
								{
									chaVector[j]=1;
								}else
								{
									chaVector[j]=0;
								}
							}
							first_word_total = vectorSum(chaVector)/chaVector.length;
						}else {
							if(i_word.length() > i_search.length())
							{
								char[] letters = i_word.toCharArray();
								char[] cha = i_search.toCharArray();
								double[] chaVector = new double[letters.length];
								int size_n = i_word.length() - i_search.length();
								char[] newcha = new char[cha.length+size_n];
								for(int c = 0; c < cha.length; c++)
								{
									newcha[c] = cha[c];
								}
								
								cha = newcha;
								for(int o = 0; o < cha.length; o++)
						        {
									char item = cha[o];
						        	if(item == 0)
						        	{
						        		item = '#';
						        		cha[o] = item;
						        	}
						        }
								for(int j = 0; j < letters.length; j++)
								{
									if(letters[j] == cha[j])
									{
										chaVector[j]=1;
									}else
									{
										chaVector[j]=0;
									}
								}
								first_word_total = vectorSum(chaVector)/chaVector.length;
							}else if(i_word.length() < i_search.length())
							{
								char[] letters = i_word.toCharArray();
								char[] cha = i_search.toCharArray();
								double[] chaVector = new double[letters.length];
								for(int j = 0; j < letters.length; j++)
								{
									if(letters[j] == cha[j])
									{
										chaVector[j]=1;
									}else
									{
										chaVector[j]=0;
									}
								}
								first_word_total = vectorSum(chaVector)/chaVector.length;
							}
						}
						next_data[i]=first_word_total;
						first_word_total = 0;
					}
			        next_word_total = vectorSum(next_data)/next_data.length;
					for(int v = 0; v < words.length; v++)
					{
						if(searchs[v].equalsIgnoreCase(words[v]))
						{
								cal[v]+=1;
						}else
						{
							cal[v]+=0;
						}
					}
					double attr1 = vectorSum(cal)/cal.length;
					double c = words.length - searchs.length;
					if(c == 0)
					{
						extra[0] = 1;
					}
					double attr2 = vectorSum(extra)/extra.length;
					WORD[0] = next_word_total;
					WORD[1] = attr1;
					WORD[2] = attr2;
					prob = vectorSum(WORD)/DIVISOR;
					return prob;
				}
			}
		}catch(Exception e)
		{
			double first_word_total = 0;
			double next_data = 0;
			double next_word_total = 0;
			if((word.length() - search.length()) == 0)
			{
				char[] letters = word.toCharArray();
				char[] cha = search.toCharArray();
				double[] chaVector = new double[letters.length];
				for(int j = 0; j < letters.length; j++)
				{
					if(letters[j] == cha[j])
					{
						chaVector[j]=1;
					}else
					{
						chaVector[j]=0;
					}
				}
				first_word_total = vectorSum(chaVector)/chaVector.length;
			}else
			{
				if(word.length() > search.length())
				{
					char[] letters = word.toCharArray();
					char[] cha = search.toCharArray();
					double[] chaVector = new double[letters.length];
					int size_n = word.length() - search.length();
					char[] newcha = new char[cha.length+size_n];
					for(int c = 0; c < cha.length; c++)
					{
						newcha[c] = cha[c];
					}
					
					cha = newcha;
					for(int o = 0; o < cha.length; o++)
			        {
						char item = cha[o];
			        	if(item == 0)
			        	{
			        		item = '#';
			        		cha[o] = item;
			        	}
			        }
					for(int j = 0; j < letters.length; j++)
					{
						if(letters[j] == cha[j])
						{
							chaVector[j]=1;
						}else
						{
							chaVector[j]=0;
						}
					}
					first_word_total = vectorSum(chaVector)/chaVector.length;
				}else if(word.length() < search.length())
				{
					char[] letters = word.toCharArray();
					char[] cha = search.toCharArray();
					double[] chaVector = new double[letters.length];
					for(int j = 0; j < letters.length; j++)
					{
						if(letters[j] == cha[j])
						{
							chaVector[j]=1;
						}else
						{
							chaVector[j]=0;
						}
					}
					first_word_total = vectorSum(chaVector)/chaVector.length;
				}
			}
			next_data = first_word_total;
			first_word_total = 0;
			next_word_total = next_data/search.length();
			return next_word_total;
		}
		return 0.0;
	}
	public static void main(String[] args) 
	{
		double an = searchProbability("Tega Steve Osowa", "Tega Steve Osowa");
		System.out.println(an);
	}

}
