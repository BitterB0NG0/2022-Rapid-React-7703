// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.commands.ArcadeDrive;

/* This class is where the bulk of the robot should be declared. Since Command-based is a "declarative" 
paradigm, very little robot logic should actually be handled in the {@link Robot} periodic methods 
(other than the scheduler calls). Instead, the structure of the robot (including subsystems, commands, 
and button mappings) should be declared here. */

public class RobotContainer {
  // Declaring Output-Input
  public static Joystick stick = new Joystick(Constants.joystickPort);
  public static Joystick stick1 = new Joystick(Constants.joystick1Port);
  public static Joystick stick2 = new Joystick(Constants.joystick2Port);
  // Declaring Instances of Subsystem, Command, & RobotContainer Classes
  public final DriveBaseSubsystem m_driveBaseSubsystem = new DriveBaseSubsystem();
  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveBaseSubsystem);

  // The Container for the Robot. Contains Subsystems, OI Devices, Commands, and Button Bindings.
  public RobotContainer() {
    //Calling "configureButtonBindings()" Methods
    configureButtonBindings();
  }

  // Method for the Configuration of Button Bindings
  private void configureButtonBindings() {}

  //Method to Pass the Autonomous Command to the "Main" Class
  public Command getAutonomousCommand() {
    return m_arcadeDrive; // "return m_arcadeDrive" is temporary, but something must be returned
  }
  
}