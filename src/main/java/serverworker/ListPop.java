package serverworker;

import java.util.ArrayList;

public class ListPop 
{
	int max = 5;
    ArrayList<UserProbability> stack = new ArrayList<UserProbability>();
    int top = 0;
    
    public void push(UserProbability data)
    {
         stack.add(data);
    }
    
    public int size()
    {
        return stack.size();
    }
    
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    
    public UserProbability get(int i)
    {
        UserProbability item = stack.get(i);
        return item;
    }
    
    public int indexOf(UserProbability user)
    {
    	return stack.indexOf(user);
    }
    
    public UserProbability pop(int i)
    {
        UserProbability data = stack.get(i);
        stack.remove(i);
        return data;
    }
}
