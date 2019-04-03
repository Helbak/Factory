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
//    @OneToMany(mappedBy = "formula", cascade = CascadeType.ALL)
//    private List<Ingredient> one= new ArrayList<Ingredient>();
//    @OneToMany(mappedBy = "formula", cascade = CascadeType.ALL)
//    private List<Ingredient> two= new ArrayList<Ingredient>();
//    @OneToMany(mappedBy = "formula", cascade = CascadeType.ALL)
//    private List<Ingredient> three= new ArrayList<Ingredient>();



    @OneToOne
    @JoinColumn(name="Id_ingredient_one")
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

//    public Formula(String name, String measure, List<Ingredient> one) {
//        this.name = name;
//        this.measure = measure;
//        this.one = one;
//    }
//
//    public Formula(String name, String measure, List<Ingredient> one, List<Ingredient> two) {
//        this.name = name;
//        this.measure = measure;
//        this.one = one;
//        this.two = two;
//    }
//
//    public Formula(String name, String measure, List<Ingredient> one, List<Ingredient> two, List<Ingredient> three) {
//        this.name = name;
//        this.measure = measure;
//        this.one = one;
//        this.two = two;
//        this.three = three;
//    }
        public Formula(String name, String measure, Ingredient one) {
        this.name = name;
        this.measure = measure;
        this.one = one;
    }

    public Formula(String name, String measure, Ingredient one, Ingredient two) {
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
    }

    public Formula(String name, String measure, Ingredient one, Ingredient two, Ingredient three) {
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public Formula(String name, String measure, Ingredient one, Ingredient two, Ingredient three, Ingredient four) {
        this.name = name;
        this.measure = measure;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public Formula(String name, String measure, Ingredient one, Ingredient two, Ingredient three, Ingredient four, Ingredient five) {
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