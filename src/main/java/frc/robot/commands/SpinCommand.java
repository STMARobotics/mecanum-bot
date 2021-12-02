package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class SpinCommand extends CommandBase {

    private final DrivetrainSubsystem drivetrainSubsystem;
    private final Timer timer = new Timer();
    private final double power;
    private final int seconds;

    public SpinCommand(DrivetrainSubsystem drivetrainSubsystem, double power, int seconds) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.power = power;
        this.seconds = seconds;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(0, 0, power);
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= seconds;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrainSubsystem.drive(0, 0, 0);
        timer.stop();
    }

}