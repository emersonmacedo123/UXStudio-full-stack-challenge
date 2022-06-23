package UXStudio.contactList.ContactList.controller;

import UXStudio.contactList.ContactList.Service.ContactService;
import UXStudio.contactList.ContactList.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
