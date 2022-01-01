package serverworker;

import java.util.ArrayList;
import java.util.HashMap;

import Algorithm.NameList;
import store.User;
import store.database;

public class ListofResponse 
{
	private static ArrayList<User> results = new ArrayList<User>();
	private static ListPop stack = new ListPop();
	private static HashMap<String, UserProbability[]> resultsuse = new HashMap<String, UserProbability[]>();
	private static ArrayList<String> users = new ArrayList<String>();
	private static HashMap<Double, String> biggest = new HashMap<Double, String>();
	private static HashMap<String, UserProbability[]> mainprobs_results = new HashMap<String, UserProbability[]>();
	private static HashMap<Double, String> pms_results = new HashMap<Double, String>();
	private static ArrayList<String> searchwords = new ArrayList<String>();
	private static HashMap<String, Double> pms = new HashMap<String, Double>();
	private static ArrayList<Double> big = new ArrayList<Double>();
	private static ArrayList<Double> pms_list = new ArrayList<Double>();
	private static String first ="";
	private static boolean find = false;
	
	public static User[] getResults(String word)
	{
		storePMS(word);
		implement(word);
		addLargest();
		results();
		User[] users = new User[results.size()];
		for(int i = 0; i < results.size(); i++)
		{
			users[i] = results.get(i);
		}
		return users;
	}
	
	public static boolean find()
	{
		return find;
	}
	
	private static HashMap<String, UserProbability[]> getList(String word)
	{
		first = word.trim();
		String[] words = NameList.getNames(word);
		HashMap<String, UserProbability[]> probs_results = new HashMap<String, UserProbability[]>();
		for(int i = 0; i < words.length; i++)
		{
			WorkerHandle n = new WorkerHandle();
			n.name(words[i]);
			n.start();
			if(n.finished() == true)
			{
				probs_results.put(words[i], n.getProbs());
				searchwords.add(words[i]);
				mainprobs_results.put(words[i], n.getProbs());
			}
		}
		return probs_results;
	}
	private static void storePMS(String word)
	{
		HashMap<String, UserProbability[]> has = getList(word);
		for(int j = 0; j < searchwords.size(); j++)
		{
			UserProbability[] user = has.get(searchwords.get(j));
			double PMS = applyPMS(user)/user.length;
			pms_results.put(PMS, searchwords.get(j));
			pms.put(searchwords.get(j), PMS);
			pms_list.add(PMS);
		}
	}
	
	private static double applyPMS(UserProbability[] user) {
		double sum = 0;
		
		for(int i = 0; i < user.length; i++)
		{
			UserProbability pro = user[i];
			double att = pro.getProbability_score();
			sum+=att;
		}
		
		return sum;
	}
	
	private static UserProbability per()
	{
		double largest = stack.get(0).getProbability_score();
		UserProbability usp = stack.get(0);
		for(int i = 0; i < stack.size(); i++)
		{
			UserProbability user = stack.get(i);
			if(user.getProbability_score() > largest)
			{
				largest = user.getProbability_score();
				usp = user;
			}
		}
		return usp;
	}
	
	private static void results()
	{
		for(int i = 0; i < users.size(); i++)
		{
			String name = users.get(i);
			UserProbability[] user = resultsuse.get(name);
			for(int j = 0; j < user.length; j++)
			{
				stack.push(user[i]);
			}
		}
		
		while(stack.size() > 0)
		{
			UserProbability user = per();
			int index = stack.indexOf(user);
			UserProbability neuser = stack.pop(index);
			String id = neuser.getId();
			User userresult = database.CRUD.getUser(id);
			results.add(userresult);
		}
		
		
	}
	
	private static void addLargest()
	{
		double largest = findLargest();
		if(largest > 0.17)
		{
			String sc = biggest.get(largest);
			resultsuse.put(sc, mainprobs_results.get(sc));
			users.add(sc);
		}
	}
	
	private static double findLargest()
	{
		double largest = big.get(0);
		for(int i = 0; i < big.size(); i++)
		{
			if(big.get(i) > largest)
			{
				largest = big.get(i);
			}
		}
		return largest;
	}
	
	private static void implement(String word) {
		double largest = pms_list.get(0);
		for(int i = 0; i < pms_list.size(); i++)
		{
			double score = pms_list.get(i);
			if(score > largest)
			{
				largest = score;
			}
		}
		
		
		if(largest > 0.5)
		{
			String sc = pms_results.get(largest);
			resultsuse.put(sc, mainprobs_results.get(sc));
			users.add(sc);
			find = true;
		}else
		{
			int index = searchwords.indexOf(word);
			String temp = searchwords.get(0);
			searchwords.set(0, word);
			searchwords.set(index, temp);
			check(0);
		}
	}
	
	private static void check(int index)
	{
		if(index > (searchwords.size() - 1))
		{
			if(find = false)
			{
				for(int i = 0; i < searchwords.size(); i++)
				{
					String word = searchwords.get(i);
					resultsuse.put(word, mainprobs_results.get(word));
					users.add(word);
					find = false;
				}
			}
		}else
		{
			String word = searchwords.get(index);
			double pmsresult = pms.get(word);
			if(pmsresult >= 0.3)
			{
				resultsuse.put(word, mainprobs_results.get(word));
				users.add(word);
				find = true;
			}else if(pmsresult < 0.3)
			{
				double largest = getLargestNum(word);
				if(largest >= 0.3)
				{
					big.add(largest);
					biggest.put(largest, word);
					find = true;
				}
				find = false;
				check(index+1);
			}
		}
	}

	private static Double getLargestNum(String word) 
	{
		UserProbability[] user = mainprobs_results.get(word);
		double largest = user[0].getProbability_score();
		for(int i = 0; i < user.length; i++)
		{
			UserProbability pr = user[i];
			double pro = pr.getProbability_score();
			if(pro > largest)
			{
				largest = pro;
			}
		}
		return largest;
	}
	
}
