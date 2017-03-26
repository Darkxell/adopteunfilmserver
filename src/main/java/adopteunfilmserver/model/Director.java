package adopteunfilmserver.model;

public class Director
{

	String alias;
	int id;
	String info;
	int movie;
	int person;

	public Director(int id, int movie, int person, String alias, String info)
	{
		super();
		this.id = id;
		this.movie = movie;
		this.person = person;
		this.alias = alias;
		this.info = info;
	}

	public String getAlias()
	{
		return alias;
	}

	public String getInfo()
	{
		return info;
	}

	public int getMovie()
	{
		return movie;
	}

	public int getPerson()
	{
		return person;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

	public void setPerson(int person)
	{
		this.person = person;
	}
}
