package biju.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import biju.repo.ProdutoJPARepository;
import pdv.domain.Produto;

@Component
public class ShopCartItemNavService {

	@Autowired
	private ProdutoJPARepository produtoJPARepository;
	
	
	public List<Produto> findByPagination(int paramPage, int size) {
		Pageable pageable = new PageRequest(
				                paramPage,
				                size,
				                Sort.Direction.DESC,
				                "id"
			              	);	
		Page<Produto>page = produtoJPARepository.findAll(pageable);
		
		return page.getContent();
	}
	
}
