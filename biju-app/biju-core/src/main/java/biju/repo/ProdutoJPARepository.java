package biju.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdv.domain.Produto;

@Repository
public interface ProdutoJPARepository extends JpaRepository<Produto, Integer>, ProdutoRepository {

	List<Produto> findTop12ByOrderByIdDesc();
	
	List<Produto> findTop6ByOrderByIdDesc();
	
}
