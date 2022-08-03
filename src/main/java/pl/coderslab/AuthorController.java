package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/author")
public class AuthorController {

private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "author/add";
    }
    @PostMapping("/add")
    public String save(Author author, Model model) {
        authorDao.save(author);
        return "redirect:/author/list";
    }
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") String id) {
        long idVal = Long.parseLong(id);
        Author author = authorDao.findById(idVal);
        model.addAttribute("author", author);
        return "author/add";
    }

    @PostMapping("/edit")
    public String edit (Author author, Model model){
      authorDao.update(author);
        return "redirect:/author/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") String id, Model model) {
        long idVal = Long.parseLong(id);
        Author author = authorDao.findById(idVal);
        model.addAttribute("author", author);
        return "/author/delete";
    }

    @PostMapping("/delete")
    public String delete(Author author, Model model){
        authorDao.delete(author);
        return "redirect:/author/list";
    }
}
