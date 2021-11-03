package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutoDriveCommand extends CommandBase {
    
    private double xSpeed;
    private double ySpeed;
    private double zRotation;
    private DrivetrainSubsystem drivetrainSubsystem;

    public AutoDriveCommand(double xSpeed, double ySpeed, double zRotation, DrivetrainSubsystem drivetrainSubsystem) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zRotation = zRotation;
        this.drivetrainSubsystem = drivetrainSubsystem;
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(ySpeed, xSpeed, zRotation);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrainSubsystem.drive(0, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
