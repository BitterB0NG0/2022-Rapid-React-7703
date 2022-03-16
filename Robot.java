// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


// "Robot" configured and called autonmatically according to mode
public class Robot extends TimedRobot {
  
  // Decarling Instnaces of Commands & RobotContainer
  private Command autonomousCommand;
  private RobotContainer robotContainer;

  // "robotInit()" runs during robot intilization
  @Override
  public void robotInit() {
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();
  }

   // "robotPeriodic()" runs periodically, every 20ms, regardless of mode
  @Override
  public void robotPeriodic() {
    /* Running the Scheduler, Polling Buttons, Adding/Removing Newly-scheduled/unscheduled Commands, 
    Running Commands, & Running periodic() methods */
    CommandScheduler.getInstance().run();
  }

  // "disabledInit()" runs during disabled mode initilzation
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  // "autonomousInit()" runs during autonomous mode initilization
  @Override
  public void autonomousInit() {
    // Runing the RobotContainer-Selected Autonomous Command
    // m_autonomousCommand = robotContainer.getAutonomousCommand();

    // Scheduleing the Autonomous Command (Example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.schedule();
    // }
  }

  // "autonomousPeriodic()" runs periodically during autonomous mode
  @Override
  public void autonomousPeriodic() {}

  // "teleopInit()" runs during teleoperation mode intilization
  @Override
  public void teleopInit() {
    // Ending Autonomous Mode
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  // "teleopInit()" runs periodically during teleoperation mode
  @Override
  public void teleopPeriodic() {}

  // "testInit()" runs during test mode initilization
  @Override
  public void testInit() {
    // Cancelling all Commands
    CommandScheduler.getInstance().cancelAll();
  }

  // "testPeridoic()" runs periodically during test mode
  @Override
  public void testPeriodic() {}
}
