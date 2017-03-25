package adopteunfilmserver.model;

public class Rating
{

	int idMovie;
	int idUser;
	int note;

	public Rating(int idUser, int idMovie, int note)
	{
		super();
		this.idUser = idUser;
		this.idMovie = idMovie;
		this.note = note;
	}

	public int getIdMovie()
	{
		return idMovie;
	}

	public int getIdUser()
	{
		return idUser;
	}

	public int getNote()
	{
		return note;
	}

	public void setIdMovie(int idMovie)
	{
		this.idMovie = idMovie;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

	public void setNote(int note)
	{
		this.note = note;
	}

}
