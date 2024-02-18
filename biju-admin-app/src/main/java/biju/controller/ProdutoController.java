package biju.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import biju.repo.CategoriaRepo;
import biju.repo.StatusRepo;
import biju.service.ProdutoService;
import biju.util.IOUtil;
import framework.util.NumberUtil;
import pdv.domain.Categoria;
import pdv.domain.Produto;
import pdv.domain.StatusProduto;

@Component("produtoController") 
@Scope("session") 
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String PRODUTO_VIEW 	= "/cadastro/produto/FormProduto.xhtml";
	private static final String LIST_PROD_VIEW 	= "/produtos/ListProdutos.xhtml";
	
	private CategoriaRepo categoriaRepo = new CategoriaRepo();
	
	private List<SelectItem>categorias  = new ArrayList<>();
	private List<SelectItem>status  	= new ArrayList<>();
	private Produto produto 			= new Produto();
	private UploadedFile image;
	private byte[] imageBytes;
	private String preco;
	
	@Autowired
	private ProdutoService produtoService;
	
	

	public String onClickBtConfirmar() {
		produto.setPreco(
			Double.valueOf(	
				NumberUtil.removeFormat(preco)
			)
		);
		
		produto.setImagem(imageBytes);

		if (produto.getQtdEstoque() != null && produto.getQtdEstoque() > 0) {
			if (produto.getStatusProduto().getId() == null) {
				produto.getStatusProduto().setId(StatusProduto.DISPONIVEL);
			}
		} else {
			produto.getStatusProduto().setId(StatusProduto.ESGOTADO);
		}
		
		produtoService.persistProduto(produto);
		
		return LIST_PROD_VIEW;
	}

	public void handleFileUpload(FileUploadEvent event) {
		if (event.getFile() != null) {
			imageBytes = event.getFile().getContent();
		}
    }
	
	public String redirectToForm() {
		produto 	= new Produto();
		imageBytes 	= null;
		preco		= null;
		image 		= null;

		produto.setCategoria(new Categoria());
		produto.setStatusProduto(new StatusProduto());

		populateCategorias();
		populateStatus();
		
		return PRODUTO_VIEW;
	}

	private void populateCategorias() {
		categorias.clear();
			
		List<Categoria>list = categoriaRepo.findAllCategorias();
		
		for (Categoria categoria : list) {
			categorias.add(
				new SelectItem(
					categoria.getId().toString(), 
					categoria.getNome()
				)	
			);
		}
	}

	private void populateStatus() {
		this.status.clear();
		
		StatusRepo repo = new StatusRepo();
		
		List<StatusProduto>list = repo.findAllStatus();
		
		for (StatusProduto status : list) {
			this.status.add(
				new SelectItem(
					status.getId().toString(), 
					status.getStatus()
				)	
			);
		}
	}
	
	public StreamedContent getImageStream() {
		if (image == null) {
			return null;
		}
		return IOUtil.imageBytesToStreamedContent(
					image.getContent(), 
					image.getContentType()
				);
    }

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

	public List<SelectItem> getCategorias() {
		return categorias;
	}

	public List<SelectItem> getStatus() {
		return status;
	}

	public String getSelectedCategoriaId() {
		return  produto.getCategoria().getId() != null ?
				produto.getCategoria().getId().toString() :
				null;
	}

	public void setSelectedCategoriaId(String selectedCategoriaId) {
		this.produto.getCategoria().setId(
				StringUtils.isNotBlank(selectedCategoriaId) ?
				Integer.valueOf(selectedCategoriaId) :
				null	
			);
	}

	public void setSelectedStatusId(String statusId) {
		this.produto.getStatusProduto().setId(
				StringUtils.isNotBlank(statusId) ?
				Integer.valueOf(statusId) :
				null	
			);
	}

	public String getSelectedStatusId() {
		return  produto.getStatusProduto().getId() != null ?
				produto.getStatusProduto().getId().toString() :
				null;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	
	
	
}
