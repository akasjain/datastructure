package patterns.mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatApp implements Chat {

    Map<String, User> users;

    public ChatApp() {

        this.users = new HashMap<>();
    }

    @Override
    public void sendMessage(String message, String userId) {
        User u = users.get(userId);
        u.receive(message);
    }

    @Override
    public void addUser(User u) {
        users.put(u.getId(), u);
    }
}
