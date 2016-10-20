package jdbc;


import logic.Document;

import java.util.List;

public interface DocumentDao {
    void saveIntoDb(Document document);
    List<Document> getDocumentList();
}