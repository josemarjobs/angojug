package com.angojug;

import java.util.List;

import com.angojug.dao.PostDAO;
import com.angojug.model.Postagem;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private Result result;
	private PostDAO postsDao;

	public IndexController(Result result, PostDAO postDao) {
		this.result = result;
		this.postsDao = postDao;
	}

	@Get
	@Path("/")
	public void index() {
		List<Postagem> posts = this.postsDao.list();
		result.include("posts", posts);
	}
}
