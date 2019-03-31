package code;

import code.domain.*;
import code.service.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;


@SpringBootApplication
@AllArgsConstructor
public class Application implements ApplicationRunner {
private ProductService productService;
private IncomingInvoiceService incomingInvoiceService;
private CashBalanceService cashBalanceService;
private RawService rawService;
private RawInvoiceService rawInvoiceService;
private IngredientService ingredientService;
private FormulaService formulaService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("Context bean count: " + context.getBeanDefinitionCount());
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {

        Product product = new Product("Water", "Polyana", "gr", 20, 200, 220, 200);
        productService.addProduct(product);
        Product product2 = new Product("Phone", "Sony", "item", 20, 200, 220,200);
        productService.addProduct(product2);
        Raw raw = new Raw("Oil", "Oleina", "gr", 100,30,30);
        rawService.addRaw(raw);
        Raw raw1 = new Raw("Potato", "Farmer", "gr", 0, 12,12 );
        rawService.addRaw(raw1);
        Raw raw2=new Raw("Meet", "Farmer", "gr", 0, 120, 120);
        rawService.addRaw(raw2);
        CashBalance cashBalance = new CashBalance(new Date(), "receiveCash", 99999, 100000);
        cashBalanceService.manualAddCashBalance(cashBalance);
        IncomingInvoice incomingInvoice = new IncomingInvoice(product, new Date(), 200,250,100);
        incomingInvoiceService.addIncomingInvoice(incomingInvoice);
        RawInvoice rawInvoice = new RawInvoice(raw, new Date(),20,100);
        rawInvoiceService.addRawInvoice(rawInvoice);
        Ingredient ingredient = new Ingredient(200,raw);
        ingredientService.addIngredient(ingredient);
        Ingredient ingredient1 = new Ingredient(100, raw1);
        ingredientService.addIngredient(ingredient1);
        Formula formula = new Formula("firstFormula", "gr", ingredient,ingredient1);
        formulaService.addFormula(formula);
    }
}