package store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class database {
	
	private static boolean initialized = false;
	private static boolean backedup = false;
	private static HashMap<String, DataHolder[]> names = new HashMap<String, DataHolder[]>();
	private static HashMap<String, User> users = new HashMap<String, User>();
	private static HashMap<String, ArrayList<Post>> posts = new HashMap<String, ArrayList<Post>>();
	
	@SuppressWarnings("unchecked")
	public static void initiallize()
	{
		try
		{
			File file = new File("index_anybody.data");
			file.createNewFile();
			FileInputStream filein = new FileInputStream(file);
			File file1 = new File("index_anybody_users.data");
			file1.createNewFile();
			FileInputStream filein1 = new FileInputStream(file1);
			File file2 = new File("index_anybody_post.data");
			file2.createNewFile();
			FileInputStream filein2 = new FileInputStream(file2);
			ObjectInputStream obi = new ObjectInputStream(filein);
			ObjectInputStream obi1 = new ObjectInputStream(filein1);
			ObjectInputStream obi2 = new ObjectInputStream(filein2);
			if(obi.available() > -1)
			{
				Object o = obi.readObject();
				Object o1 = obi1.readObject();
				Object o2 = obi2.readObject();
				names = (HashMap<String, DataHolder[]>)o;
				users = (HashMap<String, User>)o1;
				posts = (HashMap<String, ArrayList<Post>>)o2;
			}else
			{
				FileOutputStream fileout = new FileOutputStream(file);
				ObjectOutputStream obj = new ObjectOutputStream(fileout);
				FileOutputStream fileout1 = new FileOutputStream(file1);
				ObjectOutputStream obj1 = new ObjectOutputStream(fileout1);
				FileOutputStream fileout2 = new FileOutputStream(file2);
				ObjectOutputStream obj2 = new ObjectOutputStream(fileout2);
				obj.writeObject(names);
				obj.flush();
				obj.close();
				fileout.flush();
				fileout.close();
				obj1.writeObject(users);
				obj1.flush();
				obj1.close();
				fileout1.flush();
				fileout1.close();
				obj2.writeObject(posts);
				obj2.flush();
				obj2.close();
				fileout2.flush();
				fileout2.close();
				initiallize();
			}
			obi.close();
			filein.close();
			obi1.close();
			filein1.close();
			obi2.close();
			filein2.close();
			initialized = true;
		}catch(FileNotFoundException ex)
		{
			initialized = false;
		}catch(Exception e)
		{
			initialized = false;
		}
	}
	
	public static boolean isInitialized()
	{
		return initialized;
	}

	public static class CRUD implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private static void handle(String name, int index, DataHolder data, UserStore userstore)
		{
			if(index > (name.length()-1))
			{
				
			}else
			{
				DataHolder[] ar = data.getHash(String.valueOf(name.charAt(index)));
				if(ar != null)
				{
					DataHolder as = ar[0];
					DataHolder in = ar[1];
					in.add(userstore);
					handle(name, index+1, as, userstore);
				}else
				{
					DataHolder datahash = new DataHolder("hash");
					DataHolder dataarray = new DataHolder("array");
					dataarray.add(userstore);
					handle(name, index+1, datahash, userstore);
					DataHolder[] dataholder = {datahash, dataarray};
					data.add(String.valueOf(name.charAt(index)), dataholder);
				}
			}
		}
		
		public static void createUser(User user) throws Exception
		{
				String fullname = user.getFullname().trim();
				String individual = String.valueOf(fullname.charAt(0));
				UserStore userstore = new UserStore();
				userstore.setFullname(fullname);
				userstore.setId(user.getId());
				DataHolder[] ar = (DataHolder[])names.get(individual);
				if(ar != null)
				{
					DataHolder as = ar[0];
					DataHolder in = ar[1];
					in.add(userstore);
					handle(fullname, 1, as, userstore);
					String id = user.getId();
					users.put(id, user);
				}else
				{
					DataHolder datahash = new DataHolder("hash");
					DataHolder dataarray = new DataHolder("array");
					dataarray.add(userstore);
					handle(fullname, 1, datahash, userstore);
					DataHolder[] dataholder = {datahash, dataarray};
					names.put(individual, dataholder);
					String id = user.getId();
					users.put(id, user);
				}
		}
		
		private static void check(String name, DataHolder data, int index, ArrayList<DataHolder> a)
		{
			if(index > (name.length() - 1))
			{
				
			}else
			{
				DataHolder[] dataholder = data.getHash(String.valueOf(name.charAt(index)));
				DataHolder datatocheck = dataholder[0];
				DataHolder list = dataholder[1];
				a.add(list);
				check(name, datatocheck, index+1, a);
			}
		}
		
		public static UserStore[] getUsers(String name)
		{
			ArrayList<UserStore> userlist = new ArrayList<>();
			ArrayList<DataHolder> a = new ArrayList<>(); 
			UserStore[] users;
			String fullname = name.trim();
			try
			{
				if(fullname.length() > 0)
				{
					String individual = String.valueOf(fullname.charAt(0));
					DataHolder[] data = names.get(individual);
					DataHolder datatocheck = data[0];
					DataHolder list = data[1];
					a.add(list);
					check(fullname, datatocheck, 1, a);
					DataHolder da = a.get(a.size()-1);
					Holder holder = new Holder();
					for(UserStore user : da.getNames())
					{
						holder.add(user.getFullname());
						userlist.add(user);
					}
					for(int i = 1; i < a.size(); i++)
					{
						DataHolder dah = (DataHolder)a.get(i);
						for(UserStore user : dah.getNames())
						{
							if((!holder.contains(user.getFullname())) 
									&& (!user.getFullname().equalsIgnoreCase(fullname)))
							{
								holder.add(user.getFullname());
								userlist.add(user);
							}
						}
						
					}
					users = new UserStore[userlist.size()];
					for(int i = 0; i < users.length; i++)
					{
						users[i] = userlist.get(i);
					}
				}else
				{
					UserStore[] userslist = new UserStore[0];
					return userslist;
				}
			}catch(NullPointerException e)
			{
				DataHolder da = a.get(a.size()-1);
				Holder holder = new Holder();
				for(UserStore user : da.getNames())
				{
					holder.add(user.getFullname());
					userlist.add(user);
				}
				for(int i = 1; i < a.size(); i++)
				{
					DataHolder dah = (DataHolder)a.get(i);
					for(UserStore user : dah.getNames())
					{
						if((!holder.contains(user.getFullname())) 
								&& (!user.getFullname().equalsIgnoreCase(fullname)))
						{
							holder.add(user.getFullname());
							userlist.add(user);
						}
					}
					
				}
				users = new UserStore[userlist.size()];
				for(int i = 0; i < users.length; i++)
				{
					users[i] = userlist.get(i);
				}
			}catch(Exception e)
			{
				DataHolder da = a.get(a.size()-1);
				Holder holder = new Holder();
				for(UserStore user : da.getNames())
				{
					holder.add(user.getFullname());
					userlist.add(user);
				}
				for(int i = 1; i < a.size(); i++)
				{
					DataHolder dah = (DataHolder)a.get(i);
					for(UserStore user : dah.getNames())
					{
						if((!holder.contains(user.getFullname())) 
								&& (!user.getFullname().equalsIgnoreCase(fullname)))
						{
							holder.add(user.getFullname());
							userlist.add(user);
						}
					}
					
				}
				users = new UserStore[userlist.size()];
				for(int i = 0; i < users.length; i++)
				{
					users[i] = userlist.get(i);
				}
			}
			return users;
		}
		public static User getUser(String userId)
		{
			User user = (User)users.get(userId);
			return user;
		}
		
		public static User getUser(User userId)
		{
			User user = (User)users.get(userId.getId());
			return user;
		}
		
		public static void storePost(User user, ArrayList<Post> post)
		{
			posts.put(user.getId(), post);
		}
		
		public static ArrayList<Post> getPost(User user)
		{
			ArrayList<Post> p = (ArrayList<Post>) posts.get(user.getId());
			return p;
		}
		
	}
	
	public static boolean isBackedUp()
	{
		return backedup;
	}
	
	public static void backup()
	{
		try
		{
			File file = new File("index_anybody.data");
			file.delete();
			File file1 = new File("index_anybody_users.data");
			file1.delete();
			File file2 = new File("index_anybody_post.data");
			file2.delete();
			
			File new_file = new File("index_anybody.data");
			new_file.createNewFile();
			FileOutputStream fileout = new FileOutputStream(new_file);
			File new_file1 = new File("index_anybody_users.data");
			new_file1.createNewFile();
			FileOutputStream fileout1 = new FileOutputStream(new_file1);
			File new_file2 = new File("index_anybody_post.data");
			new_file2.createNewFile();
			FileOutputStream fileout2 = new FileOutputStream(new_file2);
			ObjectOutputStream obj = new ObjectOutputStream(fileout);
			obj.writeObject(names);
			obj.flush();
			obj.close();
			fileout.flush();
			fileout.close();
			ObjectOutputStream obj1 = new ObjectOutputStream(fileout1);
			obj1.writeObject(users);
			obj1.flush();
			obj1.close();
			fileout1.flush();
			fileout1.close();
			ObjectOutputStream obj2 = new ObjectOutputStream(fileout2);
			obj2.writeObject(posts);
			obj2.flush();
			obj2.close();
			fileout2.flush();
			fileout2.close();
			backedup = true;
		}catch(FileNotFoundException ex)
		{
			backedup = false;
		}catch(Exception e)
		{
			backedup = false;
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		User user = new User();
		user.setFullname("Tega Osowa Steve");
		User user1 = new User();
		user1.setFullname("Tega Osowa Stand");
		database.CRUD.createUser(user);
		database.CRUD.createUser(user1);
		UserStore[] users = database.CRUD.getUsers("Tega Osowa Steve");
		for(int i = 0; i < users.length; i++)
		{
			System.out.println(users[i].getFullname()+" "+i);
		}
	}
	/*
	 * File file = new File("index_anybody.data");
					file.createNewFile();
					FileInputStream filein = new FileInputStream(file);
					FileOutputStream fileout = new FileOutputStream(file);
					String[] n = {"da", "sd", "nj"};
					ObjectOutputStream obj = new ObjectOutputStream(fileout);
					ObjectInputStream obi = new ObjectInputStream(filein);
					obj.writeObject(n);
					obj.flush();
					obj.close();
					fileout.flush();
					fileout.close();
					System.out.println("Written");
					String[] b = {};
					if(obi.available() > -1)
					{
						Object o = obi.readObject();
						b = (String[])o;
						System.out.println("Read");
					}
					obi.close();
					filein.close();
					System.out.println("Read");
					//String name = user.getFullname();*/
}