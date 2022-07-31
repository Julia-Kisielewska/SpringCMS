package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/hello")
    @ResponseBody
    public String start() {
        return "";
    }

    @ResponseBody
    @RequestMapping("/add")
    public String saveArticle() {
//        Article article1 = Article.builder()
//                .title("Tomasz Dedek o konflikcie z Marianną Schreiber.")
//                .content("Tomasz Dedek obraził na Twitterze rodzinę Marianny Schreiber. Założycielka partii \"MAM DOŚĆ 2023\" zapowiedziała pozew. Aktor odniósł się do konfliktu.")
//                .build();
//
//
//        Article article2 = Article.builder()
//                .title("Joanna Jabłczyńska w fuksji.")
//                .content("W ostatnim czasie Joanna Jabłczyńska zrobiła modowy progres. Eleganckie kreacje i mocne kolory nie stanowią dla niej żadnego wyzwania. Bawi się nimi i wychodzi z tej gry obronną ręką.")
//                .build();
//
//        Article article3 = Article.builder()
//                .title("Fatalne warunki współpracy z Sebastianem Fabijańskim.")
//                .content("Sebastian Fabijański stracił ważny kontrakt. Wygląda na to, że nie wyreżyseruje filmu, który był jego marzeniem. Wszystko przez nieodpowiedzialne zachowanie aktora.")
//                .build();
//
//        articleDao.save(article1);
//        articleDao.save(article2);
//        articleDao.save(article3);
        return "dodano";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteArticle(){
        return "usunięto";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateArticle(){
        return "zaktualizowano";
    }
}
