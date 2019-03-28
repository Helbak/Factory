package code.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "formulas")
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String measure;
    private float gramPortion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    public Formula() {
    }

    public Formula(String name, String measure, float gramPortion, List<Ingredient> ingredients) {
        this.name = name;
        this.measure = measure;
        this.gramPortion = gramPortion;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public float getGramPortion() {
        return gramPortion;
    }

    public void setGramPortion(float gramPortion) {
        this.gramPortion = gramPortion;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
