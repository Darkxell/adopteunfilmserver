package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.AFSService;
import adopteunfilmserver.controller.service.GenreService;
import adopteunfilmserver.model.Genre;

@Controller
public class GenreController
{

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/genre/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Genre> add(@PathVariable String name)
	{
		this.genreService.add(new Genre(name));
		List<Genre> genres = this.genreService.list();
		AFSService.closeSession();
		return genres;
	}

	@RequestMapping(value = "/genre/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Genre> delete(@PathVariable int id)
	{
		this.genreService.delete(id);
		List<Genre> genres = this.genreService.list();
		AFSService.closeSession();
		return genres;
	}

	@RequestMapping(value = "/genre/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Genre get(@PathVariable int id)
	{
		return this.genreService.get(id);
	}

	@RequestMapping(value = "/genre/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Genre> list()
	{
		return this.genreService.list();
	}

	@RequestMapping(value = "/genre/update/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Genre update(@PathVariable int id, @PathVariable String name)
	{
		Genre genre = this.genreService.get(id);
		genre.setName(name);
		this.genreService.update(genre);
		AFSService.closeSession();
		return genre;
	}

}
