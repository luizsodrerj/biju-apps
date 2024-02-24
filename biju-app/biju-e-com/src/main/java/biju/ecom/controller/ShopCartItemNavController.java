package biju.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import biju.ecom.service.ShopCartItemNavService;
import biju.util.FacesUtil;
import pdv.domain.Produto;

@Component("shopCartItemNavController")
@Scope("session")
public class ShopCartItemNavController {

	private static final String MAIN_PAGE = "/site/main.xhtml";
	
	public static final int PAGE_SIZE = 9; 
	
	private List<Produto>pecas = new ArrayList<>();

	private int currentPage = 0;
	
	
	@Autowired
	private ShopCartItemNavService shopCartItemNavService;
	
	
	public String onClickLinkNextPage() {
		currentPage++;
		
		List<Produto>result = shopCartItemNavService.findByPagination(currentPage, PAGE_SIZE);
		
		currentPage = !result.isEmpty() ? currentPage : currentPage - 1;
		pecas 		= !result.isEmpty() ? result : pecas;
		
		FacesUtil.getSession().setAttribute("produtos", pecas);
		
		return null;
	}
	
	public String goToMainPage() {
		currentPage = 0;
		pecas = shopCartItemNavService.findByPagination(currentPage, PAGE_SIZE);
		
		FacesUtil.getSession().setAttribute("produtos", pecas);
		
		return MAIN_PAGE;
	}
	
	public List<Produto> getPecas() {
		return pecas;
	}

	public int getCurrentPage() {
		return currentPage + 1;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}









