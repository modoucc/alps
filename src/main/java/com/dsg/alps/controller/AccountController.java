package com.dsg.alps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsg.alps.model.Account;
import com.dsg.alps.service.AccountService;

/**
 * 
 * @class com.dsg.alps.controller.AccountController
 * @description 用户相关的操作
 * 
 * @author Simon.Cong(modoucc@gmail.com)
 * @date 2013-3-13 下午1:27:06
 */
@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("list")
	public String list(Model model) {
		List<Account> accounts = accountService.getAllAccounts();
		model.addAttribute("accounts", accounts);
		return "list";

	}

}
