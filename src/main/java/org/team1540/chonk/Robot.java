package org.team1540.chonk;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.jetbrains.annotations.Async;
import org.team1540.chonk.commands.drivetrain.TankDrive;
import org.team1540.chonk.subsystems.DriveTrain;

public class Robot extends TimedRobot {

    public static DriveTrain drivetrain;

    @Override
    public void robotInit() {
        Hardware.initAll();
        drivetrain = new DriveTrain();
    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }
}
