package adopteunfilmserver.model;

public class ProductionDesigner
{

	int id;
	String info;
	int movie;
	int person;

	public ProductionDesigner(int id, int movie, int person, String info)
	{
		super();
		this.id = id;
		this.movie = movie;
		this.person = person;
		this.info = info;
	}

	public int getId()
	{
		return id;
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

	public void setId(int id)
	{
		this.id = id;
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
