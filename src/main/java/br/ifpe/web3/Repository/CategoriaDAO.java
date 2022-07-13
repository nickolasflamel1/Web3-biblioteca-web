package br.ifpe.web3.Repository;

import br.ifpe.web3.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {
}
