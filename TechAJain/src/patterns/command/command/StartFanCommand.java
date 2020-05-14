package patterns.command.command;

import patterns.command.receiver.Fan;

public class StartFanCommand implements ICommand {

    Fan fan;

    public StartFanCommand(Fan fan) {
        super();
        this.fan = fan;
    }

    @Override
    public void execute() {
        System.out.println("Starting fan");
        fan.start();
    }
}
