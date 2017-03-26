package adopteunfilmserver.model;

public class Writer
{

	String director;
	String info;
	int movie;

	public Writer(int movie, String director, String info)
	{
		super();
		this.movie = movie;
		this.director = director;
		this.info = info;
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
