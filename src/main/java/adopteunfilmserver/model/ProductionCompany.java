package adopteunfilmserver.model;

public class ProductionCompany
{

	String company;
	String country;
	String info;
	int movie;

	public ProductionCompany(int movie, String company, String country, String info)
	{
		super();
		this.movie = movie;
		this.company = company;
		this.country = country;
		this.info = info;
	}

	public String getCompany()
	{
		return company;
	}

	public String getCountry()
	{
		return country;
	}

	public String getInfo()
	{
		return info;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public void setCountry(String country)
	{
		this.country = country;
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
