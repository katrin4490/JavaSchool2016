package jdbc;

import logic.Account;
import logic.Client;

import java.util.List;

public interface AccountDao {
    void save(Account account);

    void update(Account account);

    @SuppressWarnings("unchecked")
    List<Account> getByClient(Client client);

    List<Account> getAccounts();

    void delete(Account account);
}