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
import frc.robot.commands.SpinIntakeMotor;
import frc.robot.commands.spinLoaderMotor;

// "RobotContainer" holds subsystem, command, and configuration declerations
public class RobotContainer {
  // Declarining Instances of Subsystems
  private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final SensorSubsystem sensorSubsystem = new SensorSubsystem();

  // Declaring Instances of Input-Output Devices
  public final Joystick mainJoystick = new Joystick(0);
  public final JoystickButton trigger = new JoystickButton(mainJoystick, 1);
  public final XboxController xboxController = new XboxController(0);

  // "RobotContainer" holds all subsystems, input-output, and configurations
  public RobotContainer() {
    // Call "configureButtonBindings()" method
    configureButtonBindings();

    // Configure Default Commands
    driveBaseSubsystem.setDefaultCommand(new RunCommand(
      () -> DriveBaseSubsystem.drivePercentCurvature(mainJoystick.getRawAxis(0), mainJoystick.getRawAxis(1), true), driveBaseSubsystem) 
     ); // A split-stick curvature drive command, with forward/backward controlled by the left hand, and turning controlled by the right.
  }

  // "configureButtonBindings()" defines button-command mapping
  private void configureButtonBindings() {
    new JoystickButton(Constants.mainJoystick, 1)
      .whenPressed(new spinLoaderMotor(shooterSubsystem,1));
    new JoystickButton(Constants.mainJoystick, 1)
    .whenReleased(new spinLoaderMotor(shooterSubsystem,0));
    
    new JoystickButton(Constants.mainJoystick, 3)
      .whenPressed(new SpinIntakeMotor(intakeSubsystem,1));
    new JoystickButton(Constants.mainJoystick, 3)
      .whenReleased(new SpinIntakeMotor(intakeSubsystem,0));

  }

  // "getAuthonomousCommand()" passes the autonomous command to the main "Robot.java" class
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
}
