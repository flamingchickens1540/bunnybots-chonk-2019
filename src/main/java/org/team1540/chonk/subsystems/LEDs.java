package org.team1540.chonk.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.commands.leds.IdleLEDs;

public class LEDs extends Subsystem {

    public void setRaw(boolean red, boolean green, boolean blue) {
        Hardware.redLEDs.set(red);
        Hardware.greenLEDs.set(green);
        Hardware.blueLEDs.set(blue);
    }

    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand(new IdleLEDs());
    }
}
