package br.ifpe.web3.Repository;

import br.ifpe.web3.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroDAO extends JpaRepository<Livro, Integer> {
}
