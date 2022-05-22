package subd.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Date")
@Setter
@Getter
public class MyDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int date_id;
    @Column
    private Date drive_date;
    @Column
    private Integer smena;
    @Column
    private Long auto_fk;
    @Column
    private Long driver_fk;
    @Column
    private Long marsh_fk;

    public MyDate(){

    }

    public MyDate(Date drive_date, Integer smena){
        this.drive_date = drive_date;
        this.smena = smena;
    }

    @Override
    public String toString() {
        String str = "MyDate {date_id=" + date_id + ", smena=" + smena.toString();
        if (driver_fk == null) {
            str += ", driver_id='isNull'" + '}' + "\n";;
        } else {
            str += ", driver_id=" + driver_fk.toString() + '}' + "\n";;
        }
        return str;
    }
}
