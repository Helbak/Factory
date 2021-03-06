package code.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "formulas")
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
private int numberIngr;
    private String name;
    private String measure;

    @OneToOne
    @JoinColumn(name="Id_ingredient_one")
//@OneToMany(mappedBy = "formula", cascade = CascadeType.ALL)
//private List<Ingredient> ingredients= new ArrayList<Ingredient>();
    private Ingredient one;
    @OneToOne
    @JoinColumn(name="Id_ingredient_two")

    private Ingredient two;
    @OneToOne
    @JoinColumn(name="Id_ingredient_three")
    private Ingredient three;
    @OneToOne
    @JoinColumn(name="Id_ingredient_four")
    private Ingredient four;
    @OneToOne
    @JoinColumn(name="Id_ingredient_five")
    private Ingredient five;

    public Formula() {
    }

    public Formula(int numberIngr, String name, String measure, Ingredient one) {
        this.numberIngr = numberIngr;
        this.name = name;
        this.measure = measure;
        this.one = one;
    }

    public Formula(int numberIngr, String name, String measure, Ingredient one, Ingredient two) {
        this.numberIngr = numberIngr;
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
    }

    public Formula(int numberIngr, String name, String measure, Ingredient one, Ingredient two, Ingredient three) {
        this.numberIngr = numberIngr;
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public Formula(int numberIngr, String name, String measure, Ingredient one, Ingredient two, Ingredient three, Ingredient four) {
        this.numberIngr = numberIngr;
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public Formula(int numberIngr, String name, String measure, Ingredient one, Ingredient two, Ingredient three, Ingredient four, Ingredient five) {
        this.numberIngr = numberIngr;
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberIngr() {
        return numberIngr;
    }

    public void setNumberIngr(int numberIngr) {
        this.numberIngr = numberIngr;
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

    public Ingredient getOne() {
        return one;
    }

    public void setOne(Ingredient one) {
        this.one = one;
    }

    public Ingredient getTwo() {
        return two;
    }

    public void setTwo(Ingredient two) {
        this.two = two;
    }

    public Ingredient getThree() {
        return three;
    }

    public void setThree(Ingredient three) {
        this.three = three;
    }

    public Ingredient getFour() {
        return four;
    }

    public void setFour(Ingredient four) {
        this.four = four;
    }

    public Ingredient getFive() {
        return five;
    }

    public void setFive(Ingredient five) {
        this.five = five;
    }
}