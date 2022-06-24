package UXStudio.contactList.ContactList.controller;

import UXStudio.contactList.ContactList.Service.ContactService;
import UXStudio.contactList.ContactList.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class ContactController {
    public final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllContacts(){
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity(contacts, HttpStatus.OK);
        
    }

    @DeleteMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable String id){
        contactService.deleteContactById(parseInt(id));
        return "Deleted Successfully";
    }

    @PostMapping("/new-contact")
    @ResponseBody
    public HttpStatus addNewContact(@RequestBody Contact contact){
        try {
            contactService.registerNewContact(contact);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.CONFLICT;
        }
    }


}
