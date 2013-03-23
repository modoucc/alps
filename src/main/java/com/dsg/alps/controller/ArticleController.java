package com.dsg.alps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsg.alps.model.Article;
import com.dsg.alps.service.ArticleService;

/**
 * 
 * @class com.dsg.alps.controller.ArticleController
 * @description 文章的action
 * 
 * @author Simon.Cong(modoucc@gmail.com)
 * @date Mar 23, 2013 12:31:03 AM
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("list")
	public String index(Model model) {
		List<Article> articles = articleService.findAll();
		model.addAttribute("articles", articles);
		return "article/list";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "article/createOrUpdateForm";
	}

	/**
	 * 
	 * @param article
	 * @param result
	 * @param model
	 * @return
	 * @description Article之前加@valid注解，标明需要表单验证,详细验证规则见model
	 * @author Simon.Cong(modoucc@gmail.com)
	 * @date Mar 23, 2013 2:15:28 PM
	 */
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Article article,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "article/createOrUpdateForm";
		} else {
			articleService.create(article);
			return "redirect:/article/list";
		}
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable Long id, Model model) {
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "article/createOrUpdateForm";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
	public String processUpdateForm(@Valid Article article,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "article/createOrUpdateForm";
		} else {
			articleService.update(article);
			return "redirect:/article/list";
		}
	}

}
