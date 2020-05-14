package patterns.command;

import patterns.command.command.StartFanCommand;
import patterns.command.command.StopFanCommand;
import patterns.command.command.TurnOnLightCommand;
import patterns.command.invoker.HomeAutomationRemote;
import patterns.command.receiver.Fan;
import patterns.command.receiver.Light;

/**
 * Class diagram - https://howtodoinjava.com/wp-content/uploads/2017/06/CommandPatternClassDiagram.jpg
 *
 * https://howtodoinjava.com/design-patterns/behavioral/command-pattern/
 */
public class Client {

    public static void main(String[] args) {
        Fan bedroomFan = new Fan();
        Fan livingroomFan = new Fan();

        Light bedroomLight = new Light();
        Light livingroomLight = new Light();

        HomeAutomationRemote remote = new HomeAutomationRemote();

        remote.setCommand(new TurnOnLightCommand(livingroomLight ));
        remote.buttonPressed();

        remote.setCommand(new TurnOnLightCommand(bedroomLight));
        remote.buttonPressed();

        remote.setCommand(new StartFanCommand(livingroomFan));
        remote.buttonPressed();

        remote.setCommand(new StopFanCommand( livingroomFan ));
        remote.buttonPressed();

        remote.setCommand(new StartFanCommand( bedroomFan ));
        remote.buttonPressed();

        remote.setCommand(new StopFanCommand( bedroomFan ));
        remote.buttonPressed();
    }
}
