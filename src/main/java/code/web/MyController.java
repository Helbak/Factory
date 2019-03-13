package code.web;

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
//    static final int DEFAULT_GROUP_ID = -1;
//    static final int ITEMS_PER_PAGE = 6;
////private Map<String, String > map = new ConcurrentHashMap<>();
//    private ContactService contactService;
//private UserService userService;
//
//    @RequestMapping("/")
//    public String loginControll() {
//        return "login";
//    }
//    @RequestMapping("/new_user")
//    public String newUser() {
//        return "authorisation_result";
//    }
//
//    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
//    public String newUser(Model model, @RequestParam String login, String password) {
//        User user = new User(login,password);
//        userService.addUser(user);
////        String result = "Hello  "+login;
////        model.addAttribute("result", result);
//        return "login";
//    }
//
//    @RequestMapping(value ="/check_password", method = RequestMethod.POST)
//    public String checkPassword(Model model, @RequestParam String login, String password) {
//       if (userService.checkPassword(login, password)==true){
//        return "password_true";}
//
//        return "wrong_password";
//    }
//
//    @RequestMapping("/index")
//    public String index(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
//        if (page < 0) page = 0;
//
//        List<Contact> contacts = contactService
//                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
//
//        model.addAttribute("groups", contactService.findGroups());
//        model.addAttribute("contacts", contacts);
//        model.addAttribute("allPages", getPageCount());

//        return "index";
//    }
//
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
