package code.web;

import code.domain.CashBalance;
import code.domain.IncomingInvoice;
import code.domain.Product;
import code.domain.SalesInvoice;
import code.service.CashBalanceSevice;
import code.service.IncomingInvoiceService;
import code.service.ProductService;
import code.service.SalesInvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
private CashBalanceSevice cashBalanceSevice;


    @RequestMapping("/")
    public String something(Model model) {
        float cash = cashBalanceSevice.getLastBalance();
        model.addAttribute("cash", cash);
        return "first"; }

@RequestMapping("/add_product")
public String writing() {
    return "add_product";
}

    @RequestMapping(value = "/write_product", method = RequestMethod.POST)
    public String newUser(Model model, @RequestParam String name, String producer, String measure, float amount, float purchasePrice,float sellingPrice ) {
        Product product = new Product(name, producer, measure, amount,purchasePrice, sellingPrice, purchasePrice);
        productService.addProduct(product);
        return "add_product";
    }
//    @RequestMapping("/supply_product")
//    public String supplyProduct(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
//
//        List<Product> products = productService.findProducts();
//
//        model.addAttribute("products", products);
//        return "choose_supply_product";
//    }



    @RequestMapping("/sales_invoice")
    public String salesInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

        List<Product> products = productService.findProducts();

        float cash = cashBalanceSevice.getLastBalance();
model.addAttribute("cash", cash);
        model.addAttribute("products", products);
        return "choose_sales_invoice";
    }
    @RequestMapping("/check_sales_invoice")
    public String checkSalesInvoice(Model model, @RequestParam long id, String name, Float amount, Float sellingPrice, Float saleAmount) {

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("amount", amount);
        model.addAttribute("sellingPrice", sellingPrice);
        model.addAttribute("saleAmount", saleAmount);
        return "check_sales_invoice";
    }
    @RequestMapping(value = "/write_sales_invoice", method = RequestMethod.POST)
    public String writeSalesInvoice(Model model, @RequestParam long id, String name, Float amount, Float sellingPrice, Float saleAmount) {
//        productService.saleProduct(id, saleAmount);


        Product product = productService.getProductById(id);
        SalesInvoice salesInvoice = new SalesInvoice(product, new Date(), saleAmount);
        salesInvoiceService.addSalesInvoice(salesInvoice);
        float cash = cashBalanceSevice.getLastBalance();
        model.addAttribute("cash", cash);

        return "first";
    }

    @RequestMapping("/incoming_invoice")
public String incomingInvoice(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

    List<Product> products = productService.findProducts();
    float cash = cashBalanceSevice.getLastBalance();
    model.addAttribute("cash", cash);
    model.addAttribute("products", products);
    return "choose_incoming_invoice";
}
    @RequestMapping(value = "/check_incoming_invoice", method = RequestMethod.POST)
    public String checkIncomingInvoice(Model model, @RequestParam long id, String name,  Float plusAmount, Float purchasePrice,Float sellingPrice ) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("plusAmount", plusAmount);
        model.addAttribute("newPurchasePrice", purchasePrice);
        model.addAttribute("newSellingPrice", sellingPrice);

        return "check_incoming_invoices";
    }

//    @RequestMapping(value = "/write_supply_product", method = RequestMethod.POST)
//    public String writeSupply(Model model, @RequestParam Long id, Float plusAmount, Float purchasePrice,Float sellingPrice ) {
//
//        productService.supplyProduct(id, plusAmount, purchasePrice, sellingPrice);
//
//        return "first";
//    }
    @RequestMapping(value = "/write_incoming_invoice", method = RequestMethod.POST)
    public String writeIncomingInvoice(Model model, @RequestParam Long id, Float plusAmount, Float purchasePrice,Float sellingPrice ) {
Product product = productService.getProductById(id);
        IncomingInvoice incomingInvoice = new IncomingInvoice(product, new Date(), sellingPrice, purchasePrice, plusAmount);
        incomingInvoiceService.addIncomingInvoice(incomingInvoice);
        productService.supplyProduct(id, plusAmount, purchasePrice, sellingPrice);
        float cash = cashBalanceSevice.getLastBalance();
        model.addAttribute("cash", cash);
        return "first";
    }

@RequestMapping("/list_cashBill")
public String listCashBill(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
List<CashBalance> cashBalances = cashBalanceSevice.findCashBalance();
    model.addAttribute("cashBalances", cashBalances);
    float cash = cashBalanceSevice.getLastBalance();
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

}
