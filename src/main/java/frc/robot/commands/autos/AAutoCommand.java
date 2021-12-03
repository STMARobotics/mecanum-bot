package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.DriveStraightCommand;
import frc.robot.commands.SpinCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AAutoCommand extends ParallelCommandGroup {
    
    public AAutoCommand(DrivetrainSubsystem drivetrainSubsystem) {
        addCommands(
            new DriveStraightCommand(drivetrainSubsystem, .2, 2),
            new SpinCommand(drivetrainSubsystem, .2, 2)
        );
    }

}
