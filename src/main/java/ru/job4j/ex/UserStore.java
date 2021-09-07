package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                rsl = users[i];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User is not found.");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
       if (user.getUsername().length() < 3 || !user.isValid()) {
           throw new UserInvalidException("User is not validate");
       }
       return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            try {
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                e.printStackTrace();
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
