package adopteunfilmserver.model;

public class Follow
{

	int idFollowed;
	int idUser;

	public Follow(int idUser, int idFollowed)
	{
		super();
		this.idUser = idUser;
		this.idFollowed = idFollowed;
	}

	public int getIdFollowed()
	{
		return idFollowed;
	}

	public int getIdUser()
	{
		return idUser;
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
