package br.ifpe.web3.Controller;

import br.ifpe.web3.Model.Situacao;
import br.ifpe.web3.Repository.CategoriaDAO;
import br.ifpe.web3.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoriaController {

    private List<Categoria> lista = new ArrayList<>();

    @Autowired // injeção do Objeto
    private CategoriaDAO categoriaDAO;

    @ModelAttribute("categorias")
    public List<Categoria> getLista() {
        return this.categoriaDAO.findAll(Sort.by("nome"));
        //return this.lista;
    }
    @ModelAttribute("enum_situacao")
    public Situacao[] getEnumSituacao() {
        return Situacao.values();
    }

    @GetMapping("/listarCategorias")
    public String listaCat() {
        return "listar_categorias";
    }

    @GetMapping("/categoria")
    public String exibirCategoria(Categoria categoria) {
        return "cadastrar_categoria";
    }

    @PostMapping("/salvarCategoria")
    public String cadastrarCategoria(Integer codigo, String nome) {
        System.out.println("Código: " + codigo + ", nome: " + nome);
        return "index";
    }

    @PostMapping("/salvarCategoriaObj")
    public String salvarCategoriaObj(Categoria categoria) {
        this.lista.add(categoria);
        System.out.println(categoria);

        this.categoriaDAO.save(categoria);

        return "index";
    }
    @GetMapping("/exibirCategoria")
    public String exibirCategoria(Integer codigo, Model model) {
        Optional<Categoria> cat = Optional.of(this.categoriaDAO.getById(codigo));
        model.addAttribute("categoria", cat);
        return "cadastrar_categoria";
    }

}
