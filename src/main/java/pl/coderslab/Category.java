package pl.coderslab;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column (nullable = true)
    private String description;
    //(może przyjmować wartość null - ustawione jako default, dodano na potrzeby zadania)

}
