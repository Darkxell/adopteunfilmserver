package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.AFSService;
import adopteunfilmserver.controller.service.LanguageService;
import adopteunfilmserver.model.Language;

@Controller
public class LanguageController
{

	@Autowired
	private LanguageService languageService;

	@RequestMapping(value = "/language/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Language> add(@PathVariable String name)
	{
		this.languageService.add(new Language(name));
		List<Language> languages = this.languageService.list();
		AFSService.closeSession();
		return languages;
	}

	@RequestMapping(value = "/language/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Language> delete(@PathVariable int id)
	{
		this.languageService.delete(id);
		List<Language> languages = this.languageService.list();
		AFSService.closeSession();
		return languages;
	}

	@RequestMapping(value = "/language/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Language get(@PathVariable int id)
	{
		return this.languageService.get(id);
	}

	@RequestMapping(value = "/language/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Language> list()
	{
		return this.languageService.list();
	}

	@RequestMapping(value = "/language/update/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Language update(@PathVariable int id, @PathVariable String name)
	{
		Language language = this.languageService.get(id);
		language.setName(name);
		this.languageService.update(language);
		AFSService.closeSession();
		return language;
	}

}
