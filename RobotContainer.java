// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SensorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// "RobotContainer" holds subsystem, command, and configuration declerations
public class RobotContainer {
  // Declarining Instances of Subsystems
  private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final SensorSubsystem sensorSubsystem = new SensorSubsystem();

  // Declaring Instances of Input-Output Devices
  public final static Joystick mainJoystick = new Joystick(Constants.mainjoystickPort);
  public final JoystickButton trigger = new JoystickButton(mainJoystick, 1);
  public final XboxController xboxController = new XboxController(0);

  // "RobotContainer" holds all subsystems, input-output, and configurations
  public RobotContainer() {
    // Call "configureButtonBindings()" method
    configureButtonBindings();

    // // Configure Default Commands
    // driveBaseSubsystem.setDefaultCommand(new RunCommand(
    //   () -> DriveBaseSubsystem.movePercent(mainJoystick.getRawAxis(0), mainJoystick.getRawAxis(1), true), driveBaseSubsystem) 
    //  ); // A split-stick curvature drive command, with forward/backward controlled by the left hand, and turning controlled by the right.
  }

  // "configureButtonBindings()" defines button-command mapping
  private void configureButtonBindings() {
    // Intake Subsystem
    // Joystick Button 3
    new JoystickButton(mainJoystick,3)
      .whenPressed(new RunCommand(
        () -> intakeSubsystem.activateIntake(), intakeSubsystem) 
      );
    new JoystickButton(mainJoystick, 3)
      .whenReleased(new RunCommand(
        () -> intakeSubsystem.deactivateIntake(), intakeSubsystem)
      );


    // Shooter Subsystem
    // button 1
    new JoystickButton(mainJoystick, 1)
      .whenPressed(new RunCommand(
        () -> shooterSubsystem.activateShooter(), shooterSubsystem));
    new JoystickButton(mainJoystick, 1)
      .whenPressed(new RunCommand(
        () -> shooterSubsystem.deactivateShooter(), shooterSubsystem));

  }

  // "getAuthonomousCommand()" passes the autonomous command to the main "Robot.java" class
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
}
