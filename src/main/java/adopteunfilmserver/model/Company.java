package adopteunfilmserver.model;

public class Company
{

	String country;
	int id;
	String info;
	String name;

	public Company(int id, String name, String country, String info)
	{
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.info = info;
	}

	public String getCountry()
	{
		return country;
	}

	public int getId()
	{
		return id;
	}

	public String getInfo()
	{
		return info;
	}

	public String getName()
	{
		return name;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
