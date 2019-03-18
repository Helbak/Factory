package code.web;

import code.domain.Product;
import code.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import prog.domain.Contact;
//import prog.domain.Group;
//import prog.domain.User;
//import prog.service.ContactService;
//import prog.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MyController {
private ProductService productService;

    @RequestMapping("/")
    public String something() {
        return "first";
    }
//    @RequestMapping("/new_user")
//    public String newUser() {
//        return "authorisation_result";
//    }
//
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
    @RequestMapping("/supply_product")
    public String supplyProduct(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

        List<Product> products = productService.findProducts();

        model.addAttribute("products", products);
        return "choose_supply_product";
    }
    @RequestMapping(value = "/check_supply_product", method = RequestMethod.POST)
    public String checkSupply(Model model, @RequestParam long id, String name,  Float plusAmount, Float purchasePrice,Float sellingPrice ) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("plusAmount", plusAmount);
        model.addAttribute("newPurchasePrice", purchasePrice);
        model.addAttribute("newSellingPrice", sellingPrice);

        return "check_supply_product";
    }

    @RequestMapping(value = "/write_supply_product", method = RequestMethod.POST)
    public String writeSupply(Model model, @RequestParam Long id, Float plusAmount, Float purchasePrice,Float sellingPrice ) {

        productService.supplyProduct(id, plusAmount, purchasePrice, sellingPrice);

        return "first";
    }


//


//
//    @RequestMapping(value ="/check_password", method = RequestMethod.POST)
//    public String checkPassword(Model model, @RequestParam String login, String password) {
//       if (userService.checkPassword(login, password)==true){
//        return "password_true";}
//
//        return "wrong_password";
//    }
//
    @RequestMapping("/sale_product")
    public String sendProduct(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {

        List<Product> products = productService.findProducts();

        model.addAttribute("products", products);
       return "sale_product";
    }
    @RequestMapping(value = "/check_sale_product", method = RequestMethod.POST)
    public String checkSale(Model model, @RequestParam long id, String name, Float amount, Float sellingPrice, Float saleAmount) {

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("amount", amount);
        model.addAttribute("sellingPrice", sellingPrice);
        model.addAttribute("saleAmount", saleAmount);
       return "check_sale_product";
    }
    @RequestMapping(value = "/write_sale_product", method = RequestMethod.POST)
    public String writeSale(Model model, @RequestParam long id, String name, Float amount, Float sellingPrice, Float saleAmount) {
        productService.saleProduct(id, saleAmount);

        return "first";
    }


//
//
//    @RequestMapping("/group_add_page")
//    public String groupAddPage() {
//
//        return "group_add_page";
//    }
//
//    @RequestMapping("/group/{id}")
//    public String listGroup(
//            @PathVariable(value = "id") long groupId,
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            Model model) {
//        Group group = (groupId != DEFAULT_GROUP_ID)
//                ? contactService.findGroup(groupId).orElse(new Group())
//                : null;
//        if (page < 0) page = 0;
//
//        List<Contact> contacts = contactService
//                .findByGroup(group, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//
//        model.addAttribute("groups", contactService.findGroups());
//        model.addAttribute("contacts", contacts);
//        model.addAttribute("byGroupPages", getPageCount(group));
//        model.addAttribute("groupId", groupId);
//
//        return "index";
//    }
//
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public String search(@RequestParam String pattern, Model model) {
//        model.addAttribute("groups", contactService.findGroups());
//        model.addAttribute("contacts", contactService.findByPattern(pattern, null));
//
//        return "index";
//    }
//
//    @RequestMapping(value = "/contact/delete", method = RequestMethod.POST)
//    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
//        if (toDelete != null && toDelete.length > 0)
//            contactService.deleteContacts(toDelete);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @RequestMapping("/contact_add_page")
//    public String contactAddPage(Model model) {
//        model.addAttribute("groups", contactService.findGroups());
//        return "contact_add_page";
//    }
//    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
//    public String contactAdd(@RequestParam(value = "group") long groupId,
//                             @RequestParam String name,
//                             @RequestParam String surname,
//                             @RequestParam String phone,
//                             @RequestParam String email) {
//        Group group = (groupId != DEFAULT_GROUP_ID)
//                ? contactService.findGroup(groupId).orElse(new Group())
//                : null;
//
//        Contact contact = new Contact(group, name, surname, phone, email);
//        contactService.addContact(contact);
//
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
//    public String groupAdd(@RequestParam String name) {
//        contactService.addGroup(new Group(name));
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/contact_edit_page", method = RequestMethod.POST)
//    public String contactEditPage(Model model, @RequestParam(value = "itemId", required = true) long contactId) {
//        model.addAttribute("contact", contactService.findById(contactId));
//        model.addAttribute("groups", contactService.findGroups());
//        return "contact_edit_page";
////        return "group_add_page";
//    }
//
//    @RequestMapping(value = "/contact/edit", method = RequestMethod.POST)
//    public String contactEdit(@RequestParam(name = "userId") long userId,
//                              @RequestParam(name = "group") long groupId,
//                              @RequestParam String name,
//                              @RequestParam String surname,
//                              @RequestParam String phone,
//                              @RequestParam String email) {
//        Group group = (groupId != DEFAULT_GROUP_ID)
//                ? contactService.findGroup(groupId).orElse(new Group())
//                : null;
//        Contact contact = contactService.findById(userId);
//        contact.setGroup(group);
//        contact.setName(name);
//        contact.setSurname(surname);
//        contact.setPhone(phone);
//        contact.setEmail(email);
//        contactService.addContact(contact);
//        return "redirect:/";
////   return "/";
//    }
//
//
//    @ExceptionHandler(Exception.class)
//    public String error() {
//        return "error";
//    }
//
//    private long getPageCount() {
//        long totalCount = contactService.count();
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
//
//    private long getPageCount(Group group) {
//        long totalCount = contactService.countByGroup(group);
//        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
//    }
}
