package store;

import java.util.ArrayList;

public class User 
{
	private String fullname = "";
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	public ArrayList<String> getVideos() {
		return videos;
	}
	public void setVideos(ArrayList<String> videos) {
		this.videos = videos;
	}
	public ArrayList<ArrayList<String>> getSocialmedia() {
		return socialmedia;
	}
	public void setSocialmedia(ArrayList<ArrayList<String>> socialmedia) {
		this.socialmedia = socialmedia;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private Profile profile = new Profile();
	private ArrayList<String> images = new ArrayList<>();
	private ArrayList<String> videos = new ArrayList<>();
	private ArrayList<ArrayList<String>> socialmedia = new ArrayList<>();
	private String id = "";
	
}
