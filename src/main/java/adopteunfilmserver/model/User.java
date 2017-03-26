package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User
{

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "next_movie")
	int nextSuggestion;

	@Column(name = "pseudo")
	String pseudo;

	public User()
	{}

	public User(String pseudo)
	{
		super();
		this.id = 0;
		this.pseudo = pseudo;
		this.nextSuggestion = -1;
	}

	public int getId()
	{
		return id;
	}

	public int getNextSuggestion()
	{
		return nextSuggestion;
	}

	public String getPseudo()
	{
		return pseudo;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setNextSuggestion(int nextSuggestion)
	{
		this.nextSuggestion = nextSuggestion;
	}

	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}

}
