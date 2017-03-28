package adopteunfilmserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User
{

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

	public Set<Movie> getWishlist()
	{
		return wishlist;
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

	public void setWishlist(Set<Movie> wishlist)
	{
		this.wishlist = wishlist;
	}

}
