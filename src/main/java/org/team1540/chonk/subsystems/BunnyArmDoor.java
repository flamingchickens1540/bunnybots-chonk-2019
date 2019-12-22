package org.team1540.chonk.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Tuning;

public class BunnyArmDoor extends Subsystem {

    @Override
    protected void initDefaultCommand() {

    }

    public void open() {
        Hardware.bunnyDoor.set(Tuning.BUNNY_DOOR_OPEN);
    }

    public void close() {
        Hardware.bunnyDoor.set(Tuning.BUNNY_DOOR_CLOSE);
    }
}
