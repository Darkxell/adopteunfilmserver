package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company
{

	@Column(name = "country")
	String country;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "company")
	String name;

	public Company()
	{}

	public Company(String name, String country)
	{
		super();
		this.id = 0;
		this.name = name;
		this.country = country;
	}

	public String getCountry()
	{
		return country;
	}

	public int getId()
	{
		return id;
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

	public void setName(String name)
	{
		this.name = name;
	}

}
