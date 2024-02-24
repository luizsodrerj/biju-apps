package biju.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import biju.repo.ProdutoJPARepository;
import biju.util.FacesUtil;
import pdv.domain.ItemVenda;
import pdv.domain.Produto;

@Component("shopCartController")
@Scope("session")
public class ShopCartController {

	private static final String PROD_DETAIL_PAGE = "/site/ProductDetail.xhtml";
	private static final String MAIN_PAGE 		 = "/site/main.xhtml";

	@Autowired
	private ShopCartItemNavController shopCartItemNavController;

	@Autowired
	private ProdutoJPARepository produtoJPARepository;

	private List<ItemVenda>shopCart = new ArrayList<ItemVenda>();
	
	private Produto produto = new Produto();
	

	public String onClickBtSaveAddToShopCart() {
		ItemVenda item = new ItemVenda();
		item.setNome(produto.getNome());
		item.setPreco(produto.getPreco());
		item.setQuantidade(1);
		item.setProduto(produto);
		shopCart.add(item);

		FacesUtil.getSession().setAttribute("produtos",shopCartItemNavController.getPecas());
		
		return MAIN_PAGE;
	}
	
	public String onClickBtAddToShopCart() {
		produto = produtoJPARepository.findOne(
			Integer.valueOf(
				FacesUtil.getRequest().getParameter("idProduto")
			)
		);
		List<Produto>list = new ArrayList<Produto>();
		list.add(produto);
		FacesUtil.getSession().setAttribute("produtos", list);
		
		return PROD_DETAIL_PAGE;
	}
	
	public String goToMainPage() {
		FacesUtil.getSession().setAttribute("produtos",shopCartItemNavController.getPecas());
		
		return MAIN_PAGE;
	}
	
	public List<ItemVenda> getShopCart() {
		return shopCart;
	}
	
	public Produto getProduto() {
		return produto;
	}
	

}









