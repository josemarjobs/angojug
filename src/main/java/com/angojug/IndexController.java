package com.angojug;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Get
	@Path("/")
	public void index() {
		result.include("home", "AngoJUG, por Josemar Jobs");
	}
}
