package adopteunfilmserver.model;

public class Follow
{

	int id;
	int idFollowed;
	int idUser;

	public Follow(int id, int idUser, int idFollowed)
	{
		super();
		this.id = id;
		this.idUser = idUser;
		this.idFollowed = idFollowed;
	}

	public int getId()
	{
		return id;
	}

	public int getIdFollowed()
	{
		return idFollowed;
	}

	public int getIdUser()
	{
		return idUser;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setIdFollowed(int idFollowed)
	{
		this.idFollowed = idFollowed;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

}
