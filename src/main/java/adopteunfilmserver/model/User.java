package adopteunfilmserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User
{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "current_movie")
	Movie currentSuggestion;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "following")
	Set<User> followers;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "follow", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_follow"))
	Set<User> following;

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "next_movie")
	Movie nextSuggestion;

	@Column(name = "pseudo")
	String pseudo;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recommendations", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_movie"))
	Set<Movie> recommended;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "wishlist", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_movie"))
	Set<Movie> wishlist;

	public User()
	{}

	public User(String pseudo)
	{
		super();
		this.id = 0;
		this.pseudo = pseudo;
		this.nextSuggestion = null;
		this.wishlist = new HashSet<Movie>();
		this.recommended = new HashSet<Movie>();
		this.followers = new HashSet<User>();
		this.following = new HashSet<User>();
	}

	public Movie getCurrentSuggestion()
	{
		return currentSuggestion;
	}

	public Set<User> getFollowers()
	{
		return followers;
	}

	public Set<User> getFollowing()
	{
		return following;
	}

	public int getId()
	{
		return id;
	}

	public Movie getNextSuggestion()
	{
		return nextSuggestion;
	}

	public String getPseudo()
	{
		return pseudo;
	}

	public Set<Movie> getRecommended()
	{
		return recommended;
	}

	public Set<Movie> getWishlist()
	{
		return wishlist;
	}

	public void setCurrentSuggestion(Movie currentSuggestion)
	{
		this.currentSuggestion = currentSuggestion;
	}

	public void setFollowers(Set<User> followers)
	{
		this.followers = followers;
	}

	public void setFollowing(Set<User> following)
	{
		this.following = following;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNextSuggestion(Movie nextSuggestion)
	{
		this.nextSuggestion = nextSuggestion;
	}

	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}

	public void setRecommended(Set<Movie> recommended)
	{
		this.recommended = recommended;
	}

	public void setWishlist(Set<Movie> wishlist)
	{
		this.wishlist = wishlist;
	}

}
