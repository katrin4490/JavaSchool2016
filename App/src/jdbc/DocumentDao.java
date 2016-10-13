package jdbc;


import logic.Account;
import logic.Document;

import java.util.List;

public interface DocumentDao {
    void save(Document document);

    void update(Document document);

    @SuppressWarnings("unchecked")
    List<Document> getByAccDT(Account account);

    @SuppressWarnings("unchecked")
    List<Document> getByAccCT(Account account);

    List<Document> getDocuments();

    void delete(Document document);
}
