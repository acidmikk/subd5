package subd.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "auto")
@Setter
@Getter
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auto_id;
    @Column
    private String name;
    @Column
    private Long category_fk;
    @Column
    private Integer cost_1km;

    public Auto() {
    }

    public Auto(String Name, Integer cost_1km, Long category) {
        this.name = Name;
        this.cost_1km = cost_1km;
        this.category_fk = category;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + auto_id +
                ", Name='" + name + '\'' +
                ", cost1km='" + cost_1km + '\'' +
                '}';
    }
}
