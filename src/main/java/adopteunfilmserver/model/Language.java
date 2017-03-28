package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language
{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "language")
	String name;

	public Language()
	{}

	public Language(String name)
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
