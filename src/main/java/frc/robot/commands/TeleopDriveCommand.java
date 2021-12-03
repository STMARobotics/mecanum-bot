package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopDriveCommand extends CommandBase {
    
    private final XboxController xboxController;
    private final DrivetrainSubsystem drivetrainSubsystem;

    public TeleopDriveCommand(XboxController controller, DrivetrainSubsystem drivetrainSubsystem) {
        this.xboxController = controller;
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(
            xboxController.getX(Hand.kLeft) / 2,
            xboxController.getY(Hand.kLeft) / 2,
            -xboxController.getX(Hand.kRight) / 2);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
