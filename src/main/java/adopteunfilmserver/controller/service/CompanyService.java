package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Company;

@Service("companyService")
public class CompanyService extends AFSService<Company>
{

	public CompanyService()
	{
		super(Company.class);
	}

}
