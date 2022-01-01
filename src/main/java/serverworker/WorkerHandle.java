package serverworker;

import java.util.ArrayList;

import Algorithm.Ranking;
import store.UserStore;
import store.database;

public class WorkerHandle extends Thread
{
	private boolean finished = false;
	private String name = "";
	private ArrayList<UserProbability> use = new ArrayList<>();
	private UserProbability[] usearr = new UserProbability[use.size()];
	public boolean finished()
	{
		return this.finished;
	}
	public void name(String name)
	{
		this.name = name;
	}
	
	public String getTId()
	{
		return this.name;
	}
	
	public UserProbability[] getProbs()
	{
		return this.usearr;
	}
	@Override
	public void run()
	{
		UserStore[] users = database.CRUD.getUsers(name);
		for(int i = 0; i < users.length; i++)
		{
			UserStore user = users[i];
			double prob = Ranking.searchProbability(name, user.getFullname());
			UserProbability userproba = new UserProbability();
			userproba.setFullname(user.getFullname());
			userproba.setId(user.getId());
			userproba.setProbability_score(prob);
			use.add(userproba);
		}
		
		for(int i = 0; i < use.size(); i++)
		{
			usearr[i] = use.get(i);
		}
		
		finished = true;
	}
}
