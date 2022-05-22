package subd.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "driver")
@Setter
@Getter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driver_id;
    @Column
    private String first_name;
    @Column
    private String second_name;
    @Column
    private String father_name;

    public Driver() {
    }

    public Driver(String firstName, String lastName, String father_name) {
        this.first_name = firstName;
        this.second_name = lastName;
        this.father_name = father_name;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + driver_id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + second_name + '\'' +
                '}';
    }
}
