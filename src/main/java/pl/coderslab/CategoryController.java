package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category")
public class CategoryController {

private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "category/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }
    @PostMapping("/add")
    public String save(Category category, Model model) {
        categoryDao.save(category);
        return "redirect:/category/list";
    }
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") String id) {
        long idVal = Long.parseLong(id);
        Category category = categoryDao.findById(idVal);
        model.addAttribute("category", category);
        return "category/add";
    }

    @PostMapping("/edit")
    public String edit (Category category, Model model){
        categoryDao.update(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") String id, Model model) {
        long idVal = Long.parseLong(id);
        Category category = categoryDao.findById(idVal);
        model.addAttribute("category", category);
        return "/category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, Model model){
        categoryDao.delete(category);
        return "redirect:/category/list";
    }
}
