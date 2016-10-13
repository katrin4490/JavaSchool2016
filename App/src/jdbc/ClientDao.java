package jdbc;

import logic.Client;

import java.util.List;

public interface ClientDao {
    void save(Client client);

    void update(Client client);

    List<Client> getByName(String name);

    List<Client> getClients();

    void delete(Client client);
}
