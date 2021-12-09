// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Robot;

public class DrivetrainSubsystem extends SubsystemBase {
  private static final int kFrontLeftChannel = 3;
  private static final int kRearLeftChannel = 2;
  private static final int kFrontRightChannel = 1;
  private static final int kRearRightChannel = 0;

  private static final AHRS gyro = new AHRS(Port.kMXP);

  private MecanumDrive mecanumDrive;

  public DrivetrainSubsystem() {
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(kFrontLeftChannel);
    WPI_TalonSRX rearLeft = new WPI_TalonSRX(kRearLeftChannel);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(kFrontRightChannel);
    WPI_TalonSRX rearRight = new WPI_TalonSRX(kRearRightChannel);

    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    gyro.zeroYaw();
    new Trigger(RobotState::isEnabled).whenActive(gyro::zeroYaw);
  }

  public void drive(double ySpeed, double xSpeed, double zRotation) {
    mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation, -gyro.getAngle());
  }

}
