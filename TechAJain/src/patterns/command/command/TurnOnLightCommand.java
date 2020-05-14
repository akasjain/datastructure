package patterns.command.command;

import patterns.command.receiver.Light;

public class TurnOnLightCommand implements ICommand {

    Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Turning On light");
        light.turnOn();

    }
}
