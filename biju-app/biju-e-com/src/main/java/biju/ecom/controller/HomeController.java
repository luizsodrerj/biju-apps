package biju.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import biju.ecom.viewhelper.ContactsViewHelper;
import biju.ecom.viewhelper.PecaViewHelper;
import biju.repo.ProdutoJPARepository;
import biju.util.FacesUtil;
import pdv.domain.Produto;

@Component("homeController")
@Scope("request")
public class HomeController {

	private List<ContactsViewHelper>contacts = new ArrayList<ContactsViewHelper>();
	private List<PecaViewHelper>pecas 		 = new ArrayList<PecaViewHelper>();
	
	@Autowired
	private ProdutoJPARepository produtoJPARepository;
	
	
	@PostConstruct
	private void postConstruct() {
		populateProducts();
		populateContacts();
	}
	
	private void populateContacts() {
		contacts = new ContactsViewHelper().getList();
	}


	private void populateProducts() {
		List<Produto>produtos = produtoJPARepository.findTop6ByOrderByIdDesc();
		int count 			  = 1;
		
		FacesUtil.getSession().setAttribute("produtos", produtos);
		
		for (Produto produto : produtos) {
			PecaViewHelper viewHelper = new PecaViewHelper();
			viewHelper.setDivClass(
				count < 6 ?	
				"col-md-6 col-lg-4 mb-5" :
				"col-md-6 col-lg-4"	
			);
			viewHelper.setDataBsTarget("#portfolioModal" + count++);
			viewHelper.setId("portfolioModal" + (count - 1));
			viewHelper.setText(produto.getDescricao());
			viewHelper.setTitle(produto.getNome());
			viewHelper.setIdProduto(produto.getId());
			viewHelper.setPhoto(produto.getImagem());
			pecas.add(viewHelper);
		}
	}
	
	public List<ContactsViewHelper> getContacts() {
		return contacts;
	}
	
	public List<PecaViewHelper> getPecas() {
		return pecas;
	}
}









