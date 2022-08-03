package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return this.categoryDao.findAll();
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "article/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        return "/article/add";
    }

    @PostMapping("/add")
    public String save(Article article, Model model) {
        articleDao.save(article);
        return "redirect:/article/list";
    }
//    @ResponseBody
//    @RequestMapping("/add")
//    public String saveArticle() {
////        Article article1 = Article.builder()
////                .title("Tomasz Dedek o konflikcie z Marianną Schreiber.")
////                .content("Tomasz Dedek obraził na Twitterze rodzinę Marianny Schreiber. Założycielka partii \"MAM DOŚĆ 2023\" zapowiedziała pozew. Aktor odniósł się do konfliktu.")
////                .build();
////
////
////        Article article2 = Article.builder()
////                .title("Joanna Jabłczyńska w fuksji.")
////                .content("W ostatnim czasie Joanna Jabłczyńska zrobiła modowy progres. Eleganckie kreacje i mocne kolory nie stanowią dla niej żadnego wyzwania. Bawi się nimi i wychodzi z tej gry obronną ręką.")
////                .build();
////
////        Article article3 = Article.builder()
////                .title("Fatalne warunki współpracy z Sebastianem Fabijańskim.")
////                .content("Sebastian Fabijański stracił ważny kontrakt. Wygląda na to, że nie wyreżyseruje filmu, który był jego marzeniem. Wszystko przez nieodpowiedzialne zachowanie aktora.")
////                .build();
////        Article article4 = Article.builder()
////                .title("\"Sprawa dla reportera\". Internauci kpią z Tamary Gonzalez Perei.")
////                .content("Internauci nie dają spokoju Tamarze Gonzalez Perei. Celebrytka zareagowała, jednak nie do końca osiągnęła cel.")
////                .build();
////        Article article5 = Article.builder()
////                .title("Jarosław Jakimowicz przyznał na wizji, że wysłał komuś leki.")
////                .content("Jarosław Jakimowicz na wizji przyznał się do wysyłania zalegających leków na alergię. Opowiedział o tym na antenie TVP Info. Ekspertka, która gościła w studiu, była zaskoczona i oceniła jego zachowanie.")
////                .build();
////        Article article6 = Article.builder()
////                .title("Fatalne warunki współpracy z Sebastianem Fabijańskim.")
////                .content("Sebastian Fabijański stracił ważny kontrakt. Wygląda na to, że nie wyreżyseruje filmu, który był jego marzeniem. Wszystko przez nieodpowiedzialne zachowanie aktora.")
////                .build();
////        Article article7 = Article.builder()
////                .title("Beata Kozidrak ponownie stanie przed sądem.")
////                .content("Jakiś czas temu Beata Kozidrak usłyszała wyrok w sprawie kierowania samochodu pod wpływem alkoholu. Prokuratura uznała, że jest on jednak zbyt łagodny i złożyła apelację. Już niedługo piosenkarka ponownie zasiądzie na ławie oskarżonych.")
////                .build();
////        Article article8 = Article.builder()
////                .title("Julia Wieniawa narzeka na \"celebryctwo\".")
////                .content("Julia Wieniawa udzieliła najnowszego wywiadu, w którym opowiedziała o negatywnych skutkach bycia celebrytką. Szczerze przyznała, że zdobyta popularność zaczęła jej ciążyć. \"Celebryctwo trochę mnie zmęczyło\" - podkreśliła Julia Wieniawa.")
////                .build();
////
////        articleDao.save(article1);
////        articleDao.save(article2);
////        articleDao.save(article3);
////        articleDao.save(article4);
////        articleDao.save(article5);
////        articleDao.save(article6);
////        articleDao.save(article7);
//        return "dodano";
//    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") String id) {
        long idVal = Long.parseLong(id);
        Article article = articleDao.findById(idVal);
        model.addAttribute("article", article);
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        return "article/edit";
    }

    @PostMapping("/edit")
    public String edit(Article article, Model model) {
        articleDao.update(article);
        return "redirect:/article/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") String id, Model model) {
        long idVal = Long.parseLong(id);
        Article article = articleDao.findById(idVal);
        model.addAttribute("article", article);
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        return "/article/delete";
    }

    @PostMapping("/delete")
    public String delete(Article article, Model model){
        articleDao.delete(article);
        return "redirect:/article/list";
    }
}