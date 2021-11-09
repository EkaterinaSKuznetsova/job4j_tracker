package ru.job4j.lamda;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        for (String str : strings) {
            if (!Optional.ofNullable(str).isEmpty() && Optional.of(str).get().equals(value)) {
                return Optional.ofNullable(str);
            }
        }
        return Optional.empty();
    }
}
