package adopteunfilmserver.model;

public class Actor
{

	int id;
	int movie;
	int person;
	String role;
	String roleInfo;

	public Actor(int id, int movie, int person, String role, String roleInfo)
	{
		super();
		this.id = id;
		this.movie = movie;
		this.person = person;
		this.role = role;
		this.roleInfo = roleInfo;
	}

	public int getId()
	{
		return id;
	}

	public int getMovie()
	{
		return movie;
	}

	public int getPerson()
	{
		return person;
	}

	public String getRole()
	{
		return role;
	}

	public String getRoleInfo()
	{
		return roleInfo;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

	public void setPerson(int person)
	{
		this.person = person;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public void setRoleInfo(String roleInfo)
	{
		this.roleInfo = roleInfo;
	}

}
