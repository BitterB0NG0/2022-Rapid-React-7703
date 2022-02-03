// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/* The VM is configured to automatically run this class, and to call the functions corresponding to
each mode, as described in the TimedRobot documentation. If you change the name of this class or
the package after creating this project, you must also update the build.gradle file in the project. */

public class Robot extends TimedRobot {
  //Decleration of Instance of AutonomousCommand
  private Command m_autonomousCommand;

  // Decleration of Instance of RobotContainer
  private RobotContainer m_robotContainer;

  // Method Run When Robot is First Initialized
  @Override
  public void robotInit() {
    /* Definition of Instance of RobotContainer which Prefroms Button Bindings and 
    Places the Autonomous Chooser on the Dashbaord */
    m_robotContainer = new RobotContainer();
  }

  /* Method Called Every Robot Packet, Regardless of Mode and is Used for Diagnostics During 
  the Disabaled, Autonomous, Teleoperated, and Test Modes. This Method Runs After Mode Specific 
  Periodic Functions but Before "LiveWindow" and "SmartDashboard" Integrated Updating. */
  @Override
  public void robotPeriodic() {
    /* Runs the Scheduler, which is responsible for polling buttons, adding newly-scheduled 
    commands, running already-scheduled commands, removing finished or interrupted commands, and 
    running subsystemPeriodic() methods. */
    CommandScheduler.getInstance().run();
  }

  // Method Called Once Each Time the Robot Enters Disabled Mode
  @Override
  public void disabledInit() {}

  // Method Called Periodically During the Disabled Mode
  @Override
  public void disabledPeriodic() {}

  /* Method Called During Autonomous Mode Initialization, Calling the Autonomus Command in the 
  "RobotContainer" Class */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // Scheduling the Autonomous Command
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  // Method Called Periodically During the Autonomous Mode
  @Override
  public void autonomousPeriodic() {
  }

  // Method Called During Teleoperated Mode Initilzation
  @Override
  public void teleopInit() {
    // Cannceling Autonomous Command
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  // Method Called Periodically During Teleoperated Mode
  @Override
  public void teleopPeriodic() {}

  // Method Called During Test Mode Initialization
  @Override
  public void testInit() {
    // Canceling All Commands
    CommandScheduler.getInstance().cancelAll();
  }

  // Method Called Periodically During Test Mode
  @Override
  public void testPeriodic() {}
}
