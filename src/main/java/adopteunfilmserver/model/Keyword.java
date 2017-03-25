package adopteunfilmserver.model;

public class Keyword
{
	
	String keyword;
	int movie;

	public Keyword(int movie, String keyword)
	{
		super();
		this.movie = movie;
		this.keyword = keyword;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

}
