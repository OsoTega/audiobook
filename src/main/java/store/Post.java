package store;

import java.util.ArrayList;

public class Post 
{
	private String dateposted = "";
	public String getDateposted() {
		return dateposted;
	}
	public void setDateposted(String dateposted) {
		this.dateposted = dateposted;
	}
	public ArrayList<String> getMediaType() {
		return mediaType;
	}
	public void setMediaType(ArrayList<String> mediaType) {
		this.mediaType = mediaType;
	}
	public ArrayList<String> getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(ArrayList<String> mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	public ArrayList<String> getCommentsBy() {
		return commentsBy;
	}
	public void setCommentsBy(ArrayList<String> commentsBy) {
		this.commentsBy = commentsBy;
	}
	private ArrayList<String> mediaType = new ArrayList<>();
	private ArrayList<String> mediaUrl = new ArrayList<>();
	private String text = "";
	private String likes = "";
	private ArrayList<String> comments = new ArrayList<>();
	private ArrayList<String> commentsBy = new ArrayList<>();
}
