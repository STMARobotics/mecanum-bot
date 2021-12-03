package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveStraightCommand;
import frc.robot.commands.SpinCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AAutoCommand extends SequentialCommandGroup {
    
    public AAutoCommand(DrivetrainSubsystem drivetrainSubsystem) {
        addCommands(
            new DriveStraightCommand(drivetrainSubsystem, .2, 2),
            new SpinCommand(drivetrainSubsystem, .2, 2)
        );
    }

}
