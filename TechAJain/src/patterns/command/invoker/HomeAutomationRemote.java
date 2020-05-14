package patterns.command.invoker;

import patterns.command.command.ICommand;

public class HomeAutomationRemote {
    ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}
