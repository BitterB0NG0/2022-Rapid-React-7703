// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.IO;
import frc.robot.Scheduler;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.SensorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.TimedRobot;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */


  @Override
  public void robotInit() {
    SensorSubsystem.cameraInit();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  int autoCounter = 0;
  // function runs every 20ms, use that to count when to run certain code.
  @Override
  public void autonomousPeriodic() {
    if (autoCounter < 200) {
      DriveBaseSubsystem.movePercent(1, 0, false);
    } else if (autoCounter < 400){
      DriveBaseSubsystem.movePercent(0, 0, false);
      ShooterSubsystem.loadWheelActive = true;
    } else {
      ShooterSubsystem.loadWheelActive = false;
    }
    autoCounter++;

    Scheduler.invokeMethod();
    // System.out.println(autoCounter);
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    IO.input();
    Scheduler.invokeMethod();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
