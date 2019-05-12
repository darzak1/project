package pl.edu.wszib.project.domain;//obiekt domenowy

import javax.persistence.*;
import java.util.Date;


@Entity//wskzauje że to encja
@Table(name = "selected_colors")// tu utworzy tabę w sql gdzie będzie zapisywane dane
public class SelectedColor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//  adnotacja generująca automatycznie wartości dla @Id
    private Integer id;// identyfikator danego obietku (tu wiersza w bazie danych)
    private String color;
    private Date ctime;// data stworzenia(created timne ctime)

    public SelectedColor() {// dodaje constructor bezargome!!!!!!!!!!!!!!!!!
    }

    public SelectedColor(String color, Date ctime) {// wstawiam kolejny construktor
        this.color = color;
        this.ctime = ctime;
    }

    public Integer getId() {// setery i getery dla wszystkich
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
