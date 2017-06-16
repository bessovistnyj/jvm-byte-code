package ru.napadovskiuB.ClientBank;

import ru.napadovskiuB.Exception.AccountNotFoundException;
import ru.napadovskiuB.Exception.InsufficientFundsException;
import ru.napadovskiuB.Exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Napadovskiy Bohdan.
 */
public class Bank {

    /**
     *
     */
    private Map<User, List<Account>> mapBank;


    /**
     *
     */
    public Bank() {
        this.mapBank = new HashMap<>();
    }

    /**
     *
     * @param user
     */
    public void addUser(User user) {
        this.mapBank.put(user, new ArrayList<>());
    }

    /**
     *
     * @param user
     */
    public void deleteUser(User user) throws UserNotFoundException {
        if (this.mapBank.get(user) != null ) {
            this.mapBank.remove(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    /**
     *
     * @param user
     * @param account
     */
    public void addAccountToUser(User user, Account account) throws UserNotFoundException {
        if (this.mapBank.get(user) != null ) {
            List<Account> allUserAccounts = this.mapBank.get(user);
            allUserAccounts.add(account);
        } else {
            throw new UserNotFoundException("User not found");
        }

    }

    /**
     *
     * @param user
     * @param account
     */
    public void deleteAccountFromUser(User user, Account account) throws AccountNotFoundException, UserNotFoundException {
        if (this.mapBank.get(user) != null) {
            List<Account> allUserAccounts = this.mapBank.get(user);
            if (allUserAccounts.remove(account) != false) {
                throw new AccountNotFoundException("Account not found");
            }
        } else {
            throw new UserNotFoundException("User not found");
        }

    }

    /**
     *
     * @param user
     * @return
     */
    public List<Account> getUserAccounts(User user) throws UserNotFoundException {
        if (this.mapBank.get(user) != null ) {
            return this.mapBank.get(user);
        } else {
            throw new UserNotFoundException("User not found");
        }

    }

    /**
     *
     * @param srcUser
     * @param srcAccount
     * @param dstUser
     * @param dstAccount
     * @param amount
     * @return
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount)
    throws UserNotFoundException, AccountNotFoundException, InsufficientFundsException {
        boolean result = false;

        return result;
    }


    /**
     * Returns map.
     *
     * @return HashMap
     */
    public Map<User, List<Account>> getMap() {
        return mapBank;
    }
}
