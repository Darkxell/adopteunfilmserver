package adopteunfilmserver.model;

public class Language
{

	String language;
	int movie;

	public Language(int movie, String language)
	{
		super();
		this.movie = movie;
		this.language = language;
	}

	public String getLanguage()
	{
		return language;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

}
