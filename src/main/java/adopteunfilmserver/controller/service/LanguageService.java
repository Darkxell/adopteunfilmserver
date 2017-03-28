package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Language;

@Service("languageService")
public class LanguageService extends AFSService<Language>
{

	public LanguageService()
	{
		super(Language.class);
	}

}
