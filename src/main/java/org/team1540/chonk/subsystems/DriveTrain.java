package org.team1540.chonk.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.commands.drivetrain.ArcadeDrive;
import org.team1540.chonk.commands.drivetrain.ModifiedArcadeDrive;
import org.team1540.chonk.commands.drivetrain.PointDrive;
import org.team1540.chonk.commands.drivetrain.TankDrive;

public class DriveTrain extends Subsystem {
    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand(new ArcadeDrive());
//        setDefaultCommand(new ModifiedArcadeDrive());
//        setDefaultCommand(new TankDrive());
        setDefaultCommand(new PointDrive());

    }

    public void setThrottle(double left, double right) {
        Hardware.driveLeftA.set(-left);
        Hardware.driveRightA.set(right);
    }
}
