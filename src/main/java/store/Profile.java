package store;

import java.util.ArrayList;

public class Profile {
	private String profile_image = "";
	public String getProfile_image() {
		return this.profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getDisplay_image() {
		return this.display_image;
	}
	public void setDisplay_image(String display_image) {
		this.display_image = display_image;
	}
	public Location getLocation() {
		return this.location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public ArrayList<String> getFriends() {
		return this.friends;
	}
	public void addFriends(String friend)
	{
		this.friends.add(friend);
	}
	public ArrayList<String> getFriends_url() {
		return this.friends_url;
	}
	public void addFriends_url(String url)
	{
		this.friends_url.add(url);
	}
	public String getPerson_information() {
		return this.person_information;
	}
	public void setPerson_information(String person_information) {
		this.person_information = person_information;
	}
	public String getAge() {
		return this.age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOccupation() {
		return this.Occupation;
	}
	public void setOccupation(String occupation) {
		this.Occupation = occupation;
	}
	public String getLikes() {
		return this.likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public ArrayList<Location> getLocations() {
		return this.locations;
	}
	
	public void addLocation(Location location)
	{
		this.locations.add(location);
	}
	private String display_image = "";
	private Location location = new Location(); 
	private ArrayList<Location> locations = new ArrayList<>(); 
	private ArrayList<String> friends = new ArrayList<>();
	private ArrayList<String> friends_url = new ArrayList<>();
	private String person_information = "";
	private String age = "";
	private String Occupation = "";
	private String likes = "";
}
