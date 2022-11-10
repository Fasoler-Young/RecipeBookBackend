package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "comment")
    private String comment;

    @Basic
    @Column(name = "public")
    private Boolean is_public;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipes_id")
    private List<Product> products;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipes_id")
    private List<Action> actions;
}