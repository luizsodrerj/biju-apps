package biju.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdv.domain.Categoria;

@Repository
public interface CategoriaJPARepository extends JpaRepository<Categoria, Integer> {
		
    List<Categoria> findAllByOrderByNomeAsc();

}
