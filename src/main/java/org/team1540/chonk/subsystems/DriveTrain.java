package org.team1540.chonk.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.IO;
import org.team1540.rooster.Utilities;

import static org.team1540.chonk.Hardware.*;

public class DriveTrain extends Subsystem {
    @Override
    protected void initDefaultCommand() {
        Hardware.driveRightB.follow(Hardware.driveRightA);
        Hardware.driveRightC.follow(Hardware.driveRightA);

        Hardware.driveLeftB.follow(Hardware.driveLeftA);
        Hardware.driveLeftC.follow(Hardware.driveLeftA);
    }

    public void tankDrive() {
        Hardware.driveRightA.set(Utilities.processDeadzone(IO.driver.getY(GenericHID.Hand.kLeft), .1));
        Hardware.driveLeftA.set(Utilities.processDeadzone(IO.driver.getY(GenericHID.Hand.kLeft), .1));
    }
}
