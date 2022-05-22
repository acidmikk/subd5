package subd.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Marshrut")
@Setter
@Getter
public class Marsh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int marsh_id;
    @Column
    private Integer num;
    @Column
    private String discription;
    @Column
    private Integer lenght;
    public Marsh(){

    }
    public Marsh(Integer num, String discription, Integer lenght){
        this.num =num;
        this.discription = discription;
        this.lenght = lenght;
    }
    @Override
    public String toString() {
        return "Marshrut{" +
                "id=" + marsh_id +
                ", discription='" + discription +
                ", lenght=" + lenght.toString() + '\'' +
                '}';
    }
}
