package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person
{

	@Id
	@Column(name = "id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "name")
	String name;

	public Person()
	{}

	public Person(String name)
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
