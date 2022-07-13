package br.ifpe.web3.Controller;

import br.ifpe.web3.Model.Categoria;
import br.ifpe.web3.Model.Livro;
import br.ifpe.web3.Repository.CategoriaDAO;
import br.ifpe.web3.Repository.LivroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LivroController {

    @Autowired
    private LivroDAO livroDAO;

    @Autowired
    private CategoriaDAO categoriaDAO;

//    @ModelAttribute("livros")
//    public List<Livro> getLista() {
//        return this.livroDAO.findAll(Sort.by("codigo"));
//        //return this.lista;
//    }

    @GetMapping("/cadLivros")
    public String exibirCadastroLivros(Model model){
        model.addAttribute("lista_categ",
                this.categoriaDAO.findAll(Sort.by("nome")));
        return "cadastrar_livro";
    }

    @PostMapping("/salvarLivro")
    public String salvarLivro(Livro livro) {
        this.livroDAO.save(livro);
        return "index";
    }

//    @GetMapping("/listarLivros")
//    public String listarLivros() {
//        return "listar_livros";
//    }

}
