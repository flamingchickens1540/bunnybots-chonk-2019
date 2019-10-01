package org.team1540.chonk;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.chonk.commands.drivetrain.ArcadeDrive;
import org.team1540.chonk.commands.drivetrain.TankDrive;

public class OI {
    //driver
    public static XboxController driver = new XboxController(0);

    private static Button driverAButton = new JoystickButton(driver, 1);
    private static Button driverBButton = new JoystickButton(driver, 2);
    private static Button driverXButton = new JoystickButton(driver, 3);
    private static Button driverYButton = new JoystickButton(driver, 4);

    private static Button driverRB = new JoystickButton(driver, 6);
    private static Button driverLB = new JoystickButton(driver, 5);
    private static Button driverBackButton = new JoystickButton(driver, 7);
    private static Button driverStartButton = new JoystickButton(driver, 8);

    private static Button driverRightJoystickButton = new JoystickButton(driver, 10);
    private static Button driverLeftJoystickButton = new JoystickButton(driver, 9);

    //copilot
    public static XboxController copilot = new XboxController(1);

    private static Button copilotAButton = new JoystickButton(copilot, 1);
    private static Button copilotBButton = new JoystickButton(copilot, 2);
    private static Button copilotButton = new JoystickButton(copilot, 3);
    private static Button copilotYButton = new JoystickButton(copilot, 4);

    private static Button copilotRB = new JoystickButton(copilot, 6);
    private static Button copilotLB = new JoystickButton(copilot, 5);

    private static Button copilotBackButton = new JoystickButton(copilot, 7);
    private static Button copilotStartButton = new JoystickButton(copilot, 8);

    private static Button copilotRightJoystickButton = new JoystickButton(copilot, 10);
    private static Button copilotLeftJoystickButton = new JoystickButton(copilot, 9);

    //bindings

    public static void init() {
        System.out.println("Initializing OI...");

        driverXButton.toggleWhenPressed(new TankDrive());
        driverAButton.whenPressed(new MoveArmToPosition(2048));
    }
}