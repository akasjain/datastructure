package hackerrank;

import java.util.*;

public class Command {

    List<Command> childCommands;

    void execute() {

    }

    void rollback() {

    }

    Collection<Command> findCommandsExecutedBefore(Command failedCommand, Command parentCommand) {

        List<Command> executed = new ArrayList<>();

        for(Command cmd : parentCommand.childCommands) {
            findExecutionOrder(cmd, executed);
        }
        executed.add(parentCommand);

        for(int i = 0; i < executed.size(); i++) {
            if(executed.get(i).equals(failedCommand)) {
                break;
            }
        }

        List<Command> failedCommands = new ArrayList();

        return failedCommands;

    }

    private void findExecutionOrder(Command parent, List<Command> executed) {

/*        if(parent == failedCommand) {
            executed.add(failedCommand);
            return;
        }*/


        for(Command cmd : parent.childCommands) {
            findExecutionOrder(cmd, executed);
        }

        executed.add(parent);


    }


}