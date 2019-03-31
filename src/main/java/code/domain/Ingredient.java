package code.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float weight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raw_id")
    private Raw raw;
    @OneToOne
    @JoinColumn(name="Id_formula")
    private Formula formula;

    public Ingredient() {
    }

    public Ingredient(float weight, Raw raw) {
        this.weight = weight;
        this.raw = raw;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Raw getRaw() {
        return raw;
    }

    public void setRaw(Raw raw) {
        this.raw = raw;
    }
}
