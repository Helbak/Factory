package code.web;

import code.domain.*;
import code.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class MyController {
    private ProductService productService;
    private IncomingInvoiceService incomingInvoiceService;
    private SalesInvoiceService salesInvoiceService;
    private CashBalanceService cashBalanceService;
    private ProfitService profitService;
    private RawService rawService;
    private RawInvoiceService rawInvoiceService;
    private IngredientService ingredientService;
    private FormulaService formulaService;

    @RequestMapping("/")
    public String something(Model model) {
        float cash = cashBalanceService.getLastBalance();
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("cash", cash);
        model.addAttribute("profit", profit);
        return "first";
    }

    @RequestMapping("/add_product")
    public String writing() {
        return "add_product";
    }

    @RequestMapping("/add_raw")
    public String addRaw() {
        return "add_raw";
    }

    @RequestMapping(value = "/write_product", method = RequestMethod.POST)
    public String newProduct(Model model, @RequestParam String name, String producer, String measure, float amount, float purchasePrice, float sellingPrice) {
        Product product = new Product(name, producer, measure, amount, purchasePrice, sellingPrice, purchasePrice);
        productService.addProduct(product);
        return "add_product";
    }

    @RequestMapping(value = "/write_raw", method = RequestMethod.POST)
    public String newRaw(Model model, @RequestParam String name, String producer, String measure, float purchasePrice) {
        Raw raw = new Raw(name, producer, measure, 0, purchasePrice, purchasePrice);
        rawService.addRaw(raw);
        return "add_raw";
    }

    @RequestMapping("/sales_invoice")
    public String salesInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

        List<Product> products = productService.findProducts();

        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        model.addAttribute("products", products);
        return "choose_sales_invoice";
    }

    @RequestMapping("/check_sales_invoice")
    public String checkSalesInvoice(Model model, @RequestParam long id, String name, Float amount, Float sellingPrice, Float saleAmount) {
        if (amount < saleAmount) {
            return "have_no_resources";
        }
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("amount", amount);
        model.addAttribute("sellingPrice", sellingPrice);
        model.addAttribute("saleAmount", saleAmount);
        return "check_sales_invoice";
    }

    @RequestMapping(value = "/write_sales_invoice", method = RequestMethod.POST)
    public String writeSalesInvoice(Model model, @RequestParam long id, String name, Float amount, Float sellingPrice, Float saleAmount) {


        Product product = productService.getProductById(id);
        SalesInvoice salesInvoice = new SalesInvoice(product, new Date(), saleAmount);
        salesInvoiceService.addSalesInvoice(salesInvoice);
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }

    @RequestMapping("/incoming_invoice")
    public String incomingInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

        List<Product> products = productService.findProducts();
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        model.addAttribute("products", products);
        return "choose_incoming_invoice";
    }

    @RequestMapping("/raw_invoice")
    public String rawInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

        List<Raw> raws = rawService.findRaws();
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        model.addAttribute("raws", raws);
        return "choose_raw_invoice";
    }

    @RequestMapping(value = "/check_incoming_invoice", method = RequestMethod.POST)
    public String checkIncomingInvoice(Model model, @RequestParam long id, String name, Float plusAmount, Float purchasePrice, Float sellingPrice) {
        if (plusAmount * purchasePrice <= cashBalanceService.getLastBalance()) {
            model.addAttribute("id", id);
            model.addAttribute("name", name);
            model.addAttribute("plusAmount", plusAmount);
            model.addAttribute("newPurchasePrice", purchasePrice);
            model.addAttribute("newSellingPrice", sellingPrice);
            return "check_incoming_invoices";
        }
        return "have_no_resources";
    }

    @RequestMapping(value = "/check_raw_invoice", method = RequestMethod.POST)
    public String checkIncomingInvoice(Model model, @RequestParam long id, String name, Float plusAmount, Float purchasePrice) {
        if (plusAmount * purchasePrice <= cashBalanceService.getLastBalance()) {
            model.addAttribute("id", id);
            model.addAttribute("name", name);
            model.addAttribute("plusAmount", plusAmount);
            model.addAttribute("newPurchasePrice", purchasePrice);
            return "check_raw_invoices";
        }
        return "have_no_resources";
    }

    @RequestMapping(value = "/write_incoming_invoice", method = RequestMethod.POST)
    public String writeIncomingInvoice(Model model, @RequestParam Long id, Float plusAmount, Float purchasePrice, Float sellingPrice, String branch) {
        Product product = productService.getProductById(id);
        IncomingInvoice incomingInvoice = new IncomingInvoice(product, new Date(), sellingPrice, purchasePrice, plusAmount);
        incomingInvoiceService.addIncomingInvoice(incomingInvoice);
        productService.supplyProduct(id, plusAmount, purchasePrice, sellingPrice);
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }

    @RequestMapping(value = "/write_raw_invoice", method = RequestMethod.POST)
    public String writeRawInvoice(Model model, @RequestParam Long id, Float plusAmount, Float newPurchasePrice) {
        Raw raw = rawService.getRawById(id);
        RawInvoice rawInvoice = new RawInvoice(raw, new Date(), newPurchasePrice, plusAmount);
        rawInvoiceService.addRawInvoice(rawInvoice);
        rawService.supplyRaw(raw, plusAmount, newPurchasePrice);
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }


    @RequestMapping("/list_cashBill")
    public String listCashBill(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<CashBalance> cashBalances = cashBalanceService.findCashBalance();
        model.addAttribute("cashBalances", cashBalances);
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        return "list_cashBill";
    }

    @RequestMapping("/list_product")
    public String listProduct(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<Product> products = productService.findProducts();
        float sumProduct = productService.getsumProduct();
        model.addAttribute("sumProduct", sumProduct);
        model.addAttribute("products", products);
        return "list_product";
    }
    @RequestMapping("/list_raw")
    public String listRaw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<Raw> raws = rawService.findRaws();
        float sumRaw = rawService.getSumOfRaws();
        model.addAttribute("sumRaw", sumRaw);
        model.addAttribute("raws", raws);
        return "list_raw";
    }
    @RequestMapping("/list_formula")
    public String listFormula(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<Formula> formulas = formulaService.findFormula();
        List<Ingredient>ingredients = ingredientService.findIngredientsDAO();
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("formulas", formulas);
       return "list_formula";
    }
    @RequestMapping("/list_sales_invoice")
    public String listSalesInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<SalesInvoice> salesInvoices = salesInvoiceService.findSalesInvoice();
        float sumSales = salesInvoiceService.getsumSales();
        model.addAttribute("sumSales", sumSales);
        model.addAttribute("salesInvoices", salesInvoices);
        return "/list_sales_invoice";
    }

    @RequestMapping("/list_incoming_invoice")
    public String listIncomingInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<IncomingInvoice> incomingInvoices = incomingInvoiceService.findIncomingInvoice();
        float sumBuying = incomingInvoiceService.getsumBuying();
        model.addAttribute("sumBuying", sumBuying);
        model.addAttribute("incomingInvoices", incomingInvoices);
        return "/list_incoming_invoice";
    }

    @RequestMapping("/name_of_formula")
    public String nameOfFormula (Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        return "name_of_formula";
    }

    @RequestMapping("/add_formula")
    public String addFormula(Model model, @RequestParam String nameFormula, String measure) {
        List<Raw> raws = rawService.findRaws();
        model.addAttribute("raws", raws);
        model.addAttribute("nameFormula", nameFormula);
        model.addAttribute("measure", measure);
        return "add_formula";
    }

    @RequestMapping("/add_formula_page_two")
    public String addFormulaTwo(Model model, @RequestParam String nameFormula, String measure, long rawId, Float amountOne) {
        List<Raw> raws = rawService.findRaws();
        String rawOneName = rawService.getRawById(rawId).getName();
        Long rawOneId = rawId;
        model.addAttribute("raws", raws);
        model.addAttribute("nameFormula", nameFormula);
        model.addAttribute("measure", measure);
        model.addAttribute("amountOne", amountOne);
        model.addAttribute("rawOneName", rawOneName);
        model.addAttribute("rawOneId", rawOneId);
        return "add_formula_page_two";
    }
    @RequestMapping("/done_one_ingredient")
    public String doneOneIngredient(Model model, @RequestParam String nameFormula, String measure, Long rawOneId, Float amountOne) {

        Ingredient ingredientOne = new Ingredient(amountOne, rawService.getRawById(rawOneId));
ingredientService.addIngredient(ingredientOne);

Formula formula = new Formula(1, nameFormula,measure, ingredientOne);
formulaService.addFormula(formula);
        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }
    @RequestMapping("/add_formula_page_three")
    public String addFormulaThree(Model model, @RequestParam String nameFormula, String measure,
                                  Long rawOneId, Float amountOne,Long rawTwoId, Float amountTwo) {
        List<Raw> raws = rawService.findRaws();
        model.addAttribute("raws", raws);
        model.addAttribute("nameFormula", nameFormula);
        model.addAttribute("measure", measure);
        if(rawService.getRawById(rawOneId)==null){return "have_no_resources";}
        Ingredient ingredient1 = new Ingredient(amountOne,rawService.getRawById(rawOneId));
        ingredientService.addIngredient(ingredient1);
        Ingredient ingredient2 = new Ingredient(amountTwo, rawService.getRawById(rawTwoId));
        ingredientService.addIngredient(ingredient2);
        model.addAttribute("ingredient1", ingredient1);
        model.addAttribute("ingredient2", ingredient2);
        return "add_formula_page_three";
    }
    @RequestMapping("/done_two_ingredient")
    public String doneTwoIngredient(Model model, @RequestParam String nameFormula, String measure,
                                    Integer idOneIngr, Integer idTwoIngr) {
if( idOneIngr==0){return "have_no_resources";}

      Ingredient ingredient1 = ingredientService.getIngredientById(idOneIngr);
        Ingredient ingredient2 = ingredientService.getIngredientById(idTwoIngr);
        Formula formula = new Formula(2,nameFormula, measure,ingredient1,ingredient2);


        formulaService.addFormula(formula);

        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }
    @RequestMapping("/add_formula_page_four")
    public String addFormulaThree(Model model, @RequestParam String nameFormula, String measure, Ingredient ingredient1,
                                  Ingredient ingredient2, Long rawThreeId, Float amountThree) {
        List<Raw> raws = rawService.findRaws();
        Ingredient ingredient3 = new Ingredient(amountThree, rawService.getRawById(rawThreeId));

        model.addAttribute("raws", raws);
        model.addAttribute("nameFormula", nameFormula);
        model.addAttribute("measure", measure);

        model.addAttribute("ingredient1", ingredient1);
        model.addAttribute("ingredient2", ingredient2);
        model.addAttribute("ingredient3", ingredient3);
        return "add_formula_page_four";
    }
    @RequestMapping("/done_three_ingredient")
    public String doneTwoIngredient(Model model, @RequestParam String nameFormula, String measure,
                                    Integer idOneIngr, Integer idTwoIngr, Long rawThreeId, Float amountThree) {
Ingredient ingredient3 = new Ingredient(amountThree, rawService.getRawById(rawThreeId));
        Ingredient ingredient1 = ingredientService.getIngredientById(idOneIngr);
        Ingredient ingredient2 = ingredientService.getIngredientById(idTwoIngr);

        ingredientService.addIngredient(ingredient3);
        Formula formula = new Formula(3,nameFormula ,measure, ingredient1, ingredient2, ingredient3);
        formulaService.addFormula(formula);

        float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }

    @RequestMapping("/produce_product")
    public String produceProduct (Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<Formula> formulas = formulaService.findFormula();
        model.addAttribute("formulas", formulas);

        return "produce_product";
    }

    @RequestMapping("/add_product_to_trading")
    public String product_to_trading(Model model, @RequestParam long formulaId, int amount, float markup){
Formula formula = formulaService.getFormulaById(formulaId);
        if(formulaService.checkResourcesForFormula(formula,amount)==false){return "have_no_resources";}
Product product = formulaService.createObjectProduct(formula,amount,markup);
        productService.supplyProductFromProduction(product);

            float cash = cashBalanceService.getLastBalance();
        model.addAttribute("cash", cash);
        float profit = profitService.getLastTotalProfit();
        model.addAttribute("profit", profit);
        return "first";
    }
}