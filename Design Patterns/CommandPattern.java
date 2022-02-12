class Scratch {
    public static void main(String[] args) {
        Remote remote = new Remote();
        //Fan object to perform command
        Fan fan = new Fan();
        //Light object to perform command
        Light light = new Light();

        /*
        Commands on/off Fan object
         */
        remote.setCommand(new FanOnCommand(fan));
        remote.execute();
        remote.setCommand(new FanOffCommand(fan));
        remote.execute();
        /*
        Commands on/off Light object
         */
        remote.setCommand(new LightsOnCommand(light));
        remote.execute();
        remote.setCommand(new LightsOffCommand(light));
        remote.execute();



    }
}
/*
Command interface which is having a execute command
 */
interface Command {
    void execute();
}
/*
Light class holding 'on/off' execute methods
 */
class Light {
    void On() {
        System.out.println("Lights turned on");
    }

    void off() {
        System.out.println("Lights turned off");
    }
}

/*
LightsOnCommand class holding 'ON' execute methods
 */
class LightsOnCommand implements Command {

    Light light;

    public LightsOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.On();
    }
}
/*
LightsOffCommand class holding 'OFF' execute methods
 */
class LightsOffCommand implements Command {

    Light light;

    public LightsOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.off();
    }
}

/*
Fan class holding 'on/off' execute methods
 */

class Fan {
    void on() {
        System.out.println("Fan turned on");
    }

    void off() {
        System.out.println("Fan turned off");
    }
}

/*
FanOnCommand class holding 'ON' execute methods
 */
class FanOnCommand implements Command {
    Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        this.fan.on();
    }
}

/*
FanOffCommand class holding 'OFF' execute methods
 */
class FanOffCommand implements Command {
    Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        this.fan.off();
    }
}

/*
the remote control doesn’t know anything about turning on the fan or light.
That information is contained in a separate command object. This reduces the coupling between them.
 */
class Remote {
    Command button;

    public void setCommand(Command button) {
        this.button = button;
    }

    public void execute() {
        this.button.execute();
    }
}