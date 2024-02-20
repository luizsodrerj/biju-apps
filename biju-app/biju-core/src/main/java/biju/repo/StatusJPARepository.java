package biju.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdv.domain.StatusProduto;

@Repository
public interface StatusJPARepository extends JpaRepository<StatusProduto, Integer> {

}
