import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Notification {
    private final List<String> errors = new ArrayList<>();
    public void addError(final String message){
        errors.add(message);
    }
    public boolean hasErrors(){
        return !errors.isEmpty();
    }
    public String errorMessage(){
        return errors.toString();
    }
    public String getAllErrors() {
        return this.errors.stream()
                .collect(joining(", "));
    }
}
