package adopteunfilmserver.model;


public class Actor
{

	String director;
	int movie;
	String role;
	String roleInfo;

	public Actor(int movie, String director, String role, String roleInfo)
	{
		super();
		this.movie = movie;
		this.director = director;
		this.role = role;
		this.roleInfo = roleInfo;
	}

	public String getDirector()
	{
		return director;
	}

	public int getMovie()
	{
		return movie;
	}

	public String getRole()
	{
		return role;
	}

	public String getRoleInfo()
	{
		return roleInfo;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
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
