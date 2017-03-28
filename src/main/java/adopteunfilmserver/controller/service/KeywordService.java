package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Keyword;

@Service("keywordService")
public class KeywordService extends AFSService<Keyword>
{

	public KeywordService()
	{
		super(Keyword.class);
	}

}
