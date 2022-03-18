// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SensorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// "RobotContainer" holds subsystem, command, and configuration declerations
public class RobotContainer {
  // Declarining Instances of Subsystems
  public final static DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final SensorSubsystem sensorSubsystem = new SensorSubsystem();

  // Declaring Instances of Input-Output Devices
  public final static Joystick mainJoystick = new Joystick(Constants.mainjoystickPort);
  public final JoystickButton trigger = new JoystickButton(mainJoystick, 1);

  // "RobotContainer" holds all subsystems, input-output, and configurations
  public RobotContainer() {
    // Calling "configureButtonBindings()" method
    configureButtonBindings();
    sensorSubsystem.cameraInit();
  }

  // "configureButtonBindings()" defines button-command mapping
  private void configureButtonBindings() {
    // Intake Subsystem
    new JoystickButton(mainJoystick,3)
      .whenPressed(new RunCommand(
        () -> intakeSubsystem.activateIntake(), intakeSubsystem) 
      );
    new JoystickButton(mainJoystick, 3)
      .whenReleased(new RunCommand(
        () -> intakeSubsystem.deactivateIntake(), intakeSubsystem)
      );
    new JoystickButton(mainJoystick, 8)
      .whenReleased(new RunCommand(
        () -> intakeSubsystem.deployIntake(), intakeSubsystem)
      );
  }

  public Command autonomousActivity() {
    return new RunCommand(() -> driveBaseSubsystem.differentialDrive.curvatureDrive(-1, 0, false));

  }
}
