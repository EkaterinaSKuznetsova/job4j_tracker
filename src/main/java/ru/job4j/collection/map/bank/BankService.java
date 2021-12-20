package ru.job4j.collection.map.bank;
import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * @author Ekaterina Kuznetsova
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение всех пользователей сервиса осуществляется в коллекции типа Map
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему.
     * По умолчанию к этому пользователю нужно добавить пустой список счетов.
     * Также осуществляется проверка есть ли такой пользователь в системе.
     * @param user пользователь который добавляется в систему
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспорт и счет и добавляет этот новый счет пользователю.
     * Находим пользователя по номеру паспорта. Если у найденного пользователя нет
     * счета с таким номером, то добавляем его.
     * @param passport номер паспорта пользователя
     * @param account  номер сета, который нужно добавить пользователю
     */

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта.
     * И осуществляет поиск пользователя с таким номером паспорта
     * @param passport номер паспорта пользователя
     */

    public Optional<User> findByPassport(String passport) {
         return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход паспорт и реквизиты.
     * Метод ищет счет пользователя по реквизитам
     * Сначала нужно найти пользователя по паспорту с помощью метода findByPassport.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
       return users.get(findByPassport(passport).get())
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst();
    }

    /**
     * Метод принимает на вход паспорт и реквизиты счета, с которого нужно списать сумму,
     * саму сумму списания и паспорт и реквизиты счета на который нужно зачислить сумму.
     * метод предназначен для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте списания
     * (с которого переводят), то метод должен вернуть false.
     * @param srcPassport номер паспорта пользователя у которого списываем деньги
     * @param srcRequisite реквизиты счета списания
     * @param destPassport номер паспорта пользователя которому зачисляемденьги
     * @param destRequisite реквизиты счета зачисления
     * @param amount сумма списания/зачисления
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> src =  findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            return true;

        }
        return false;
    }
}

