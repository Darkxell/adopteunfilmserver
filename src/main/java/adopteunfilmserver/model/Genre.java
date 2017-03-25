package adopteunfilmserver.model;

public class Genre
{
	
	String genre;
	int movie;

	public Genre(int movie, String genre)
	{
		super();
		this.movie = movie;
		this.genre = genre;
	}

	public String getGenre()
	{
		return genre;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

}
