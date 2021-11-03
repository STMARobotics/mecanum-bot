// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/** This is a demo program showing how to use Mecanum control with the RobotDrive class. */
public class Robot extends TimedRobot {
  private static final int kFrontLeftChannel = 3;
  private static final int kRearLeftChannel = 2;
  private static final int kFrontRightChannel = 1;
  private static final int kRearRightChannel = 0;

  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private XboxController m_stick;

  @Override
  public void robotInit() {
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(kFrontLeftChannel);
    WPI_TalonSRX rearLeft = new WPI_TalonSRX(kRearLeftChannel);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(kFrontRightChannel);
    WPI_TalonSRX rearRight = new WPI_TalonSRX(kRearRightChannel);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    m_stick = new XboxController(kJoystickChannel);
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.driveCartesian(
      m_stick.getX(Hand.kLeft) / 2,
      m_stick.getY(Hand.kLeft) / 2,
      -m_stick.getX(Hand.kRight) / 2);
  }
}
