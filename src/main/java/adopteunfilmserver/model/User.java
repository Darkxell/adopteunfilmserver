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

	public User(int id, String pseudo, int nextSuggestion)
	{
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nextSuggestion = nextSuggestion;
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
