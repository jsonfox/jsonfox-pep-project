package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account createAccount(Account account) {
        if (this.getAccountByUsername(account) != null) {
            return null;
        }
        
        if (account.getUsername().length() == 0 || account.getPassword().length() < 4) {
            return null;
        }

        return this.accountDAO.createAccount(account);
    }

    public Account loginToAccount(Account account) {
        return this.accountDAO.loginToAccount(account);
    }

    public Account getAccountByUsername(Account account) {
        return this.accountDAO.getAccountByUsername(account);
    }
}
