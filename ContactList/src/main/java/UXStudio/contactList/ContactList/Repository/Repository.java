package UXStudio.contactList.ContactList.Repository;

import UXStudio.contactList.ContactList.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Contact, Long> {


}
