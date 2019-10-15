package org.team1540.chonk.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.commands.drivetrain.ArcadeDrive;
import org.team1540.chonk.commands.drivetrain.TankDrive;

public class DriveTrain extends Subsystem {
    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand(new ArcadeDrive());
    }

    public void setThrottle(double right, double left) {
        Hardware.driveRightA.set(right);
        Hardware.driveLeftA.set(left);
    }
}
