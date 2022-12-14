package pl.coderslab;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String title;
    //(max. 200 znaków)

    @ManyToOne
    private Author author;
    //    (powiązanie relacją do klasy Author)
    //    artykuł może mieć tylko jednego autora

    @OneToMany (fetch = FetchType.EAGER)
    private List<Category> categories;
    //    (powiązanie relacją do klasy Category)
    //    artykuł może należeć do wielu kategorii

    private String content;

    private LocalDateTime created;

    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
