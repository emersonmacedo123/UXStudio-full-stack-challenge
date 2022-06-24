package UXStudio.contactList.ContactList.Service;


import UXStudio.contactList.ContactList.Repository.Repository;
import UXStudio.contactList.ContactList.model.Contact;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final Repository repository;

    public List<Contact> getAllContacts(){
        return repository.findAll();
    }

    public Optional<Contact> getContactById(Integer id){
        return repository.findById(id);
    }

    public void registerNewContact(Contact contact){
        repository.save(contact);
    }

    public void deleteContactById(Integer id) {
        repository.deleteById(id);
    }
}
