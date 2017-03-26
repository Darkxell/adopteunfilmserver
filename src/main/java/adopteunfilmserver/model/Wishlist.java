package adopteunfilmserver.model;

public class Wishlist
{

	int id;
	int idMovie;
	int idUser;

	public Wishlist(int id, int idUser, int idMovie)
	{
		super();
		this.id = id;
		this.idUser = idUser;
		this.idMovie = idMovie;
	}

	public int getId()
	{
		return id;
	}

	public int getIdMovie()
	{
		return idMovie;
	}

	public int getIdUser()
	{
		return idUser;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setIdMovie(int idMovie)
	{
		this.idMovie = idMovie;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

}
