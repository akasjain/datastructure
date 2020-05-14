package patterns.command.command;

import patterns.command.receiver.Light;

import java.util.Iterator;

public class TurnOffLightCommand implements ICommand {

    Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Turning Off light");
        light.turnOff();
    }
}
