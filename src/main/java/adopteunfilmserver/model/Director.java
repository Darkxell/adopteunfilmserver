package adopteunfilmserver.model;

public class Director
{

	String alias;
	String director;
	String info;
	int movie;

	public Director(int movie, String director, String alias, String info)
	{
		super();
		this.movie = movie;
		this.director = director;
		this.alias = alias;
		this.info = info;
	}

	public String getAlias()
	{
		return alias;
	}

	public String getDirector()
	{
		return director;
	}

	public String getInfo()
	{
		return info;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

}
