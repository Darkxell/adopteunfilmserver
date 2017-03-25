package adopteunfilmserver.model;

public class Wishlist
{

	int idMovie;
	int idUser;

	public Wishlist(int idUser, int idMovie)
	{
		super();
		this.idUser = idUser;
		this.idMovie = idMovie;
	}

	public int getIdMovie()
	{
		return idMovie;
	}

	public int getIdUser()
	{
		return idUser;
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
