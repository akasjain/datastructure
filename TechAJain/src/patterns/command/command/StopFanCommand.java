package patterns.command.command;

import patterns.command.receiver.Fan;

public class StopFanCommand implements ICommand {

    Fan fan;

    public StopFanCommand(Fan fan) {
        super();
        this.fan = fan;
    }

    @Override
    public void execute() {
        System.out.println("Stopping fan");
        fan.stop();
    }
}
