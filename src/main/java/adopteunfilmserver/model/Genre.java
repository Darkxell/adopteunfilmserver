package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre
{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "genre")
	String name;

	public Genre()
	{}

	public Genre(String name)
	{
		super();
		this.id = 0;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
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
