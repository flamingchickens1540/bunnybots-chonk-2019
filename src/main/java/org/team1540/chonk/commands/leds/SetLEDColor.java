package org.team1540.chonk.commands.leds;


import edu.wpi.first.wpilibj.command.TimedCommand;
import org.team1540.chonk.Robot;

public class SetLEDColor extends TimedCommand {

    private boolean red;
    private boolean green;
    private boolean blue;

    public SetLEDColor(boolean red, boolean green, boolean blue) {
        super(0.5);
        requires(Robot.leds);
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    protected void initialize() {
        Robot.leds.setRaw(red, green, blue);
    }
}
