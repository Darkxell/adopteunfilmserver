package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating
{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne(cascade =
	{ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_movie")
	Movie movie;

	@Column(name = "note")
	int note;

	@ManyToOne(cascade =
	{ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_user")
	User user;

	public Rating()
	{}

	public Rating(User user, Movie movie, int note)
	{
		super();
		this.id = 0;
		this.user = user;
		this.movie = movie;
		this.note = note;
	}

	public int getId()
	{
		return id;
	}

	public Movie getMovie()
	{
		return movie;
	}

	public int getNote()
	{
		return note;
	}

	public User getUser()
	{
		return user;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}

	public void setNote(int note)
	{
		this.note = note;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

}
