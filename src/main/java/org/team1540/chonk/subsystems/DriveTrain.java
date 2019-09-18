package org.team1540.chonk.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.IO;
import org.team1540.chonk.commands.drivetrain.TankDrive;
import org.team1540.rooster.Utilities;

import static org.team1540.chonk.Hardware.*;

public class DriveTrain extends Subsystem {
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    public void setThrottle(double right, double left) {
        Hardware.driveRightA.set(right);
        Hardware.driveLeftA.set(left);
    }
}
