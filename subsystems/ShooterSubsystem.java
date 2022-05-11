package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.Constants;
import frc.robot.IO;
import frc.robot.SubsystemScheduler;

public class ShooterSubsystem extends SubsystemScheduler {
    // Stating ShooterSubsystem Variables
    public double distanceToTarget;
    public static boolean shooterFlywheelActive = true;
    public static boolean loadWheelActive;
    public static boolean manualPowerSetting = true;
    public static boolean load = true;

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
        distanceToTarget = IO.distance;
        // Setting shooting flywheel power/speed
        if (shooterFlywheelActive) {
            setFlyWheelSpeeds((IO.mainJoystick.getRawAxis(2) - 1) / 2);
            IO.floppaShooterMotorController.set(ControlMode.PercentOutput, Constants.floppaPower);
            IO.bingusShooterMotorController.set(ControlMode.PercentOutput, -Constants.bingusPower);
        } else {
            setFlyWheelSpeeds(0);
        }

        // Setting loading flywheel power/speed
        if (loadWheelActive == true) {
            if (load) {
                IO.quadingleLoadingMotorController.set(ControlMode.PercentOutput, Constants.quadinglePower);
            } else {
                IO.quadingleLoadingMotorController.set(ControlMode.PercentOutput, -Constants.quadinglePower);
            }
        } else {
            IO.quadingleLoadingMotorController.set(ControlMode.PercentOutput, 0);
        }
    }

    // "setFlyWheelSpeeds()" sets the power of the shootingFlyWheelsSpeeds
    public void setFlyWheelSpeeds(double powerSetting) {
        if (manualPowerSetting = true) {
            Constants.floppaPower = powerSetting;
            Constants.bingusPower = powerSetting;
        } else {
            double maximumVelocity = (Math.sqrt(2 * Constants.gravitationalFieldStrenth * Constants.maximumHeight)) / Math.cos(Constants.shooterAngle);
            double requiredVelocity = (Math.sqrt((2 * distanceToTarget) / (Constants.gravitationalFieldStrenth * Math.tan(Constants.shooterAngle)))) / Math.cos(Constants.shooterAngle);
            Constants.floppaPower = requiredVelocity / maximumVelocity;
            Constants.bingusPower = requiredVelocity / maximumVelocity;
        }
    }

    // "loadShooter()" commands the loading wheel to rotate slightly and load the shooting mechanism
    public void loadShooter() {

    }

    // "activateShooter()" commands the shooter system to shoot
    public void activateShooter() {
        loadWheelActive = true;
    }

    // "deactivateShooter()" commands the shooter system to shoot
    public void deactivateShooter() {
        loadWheelActive = false;
    }

    // "activateShootingFlyWheels()" commands the shooting flywheels to spool up to the required veolcities
    public void activateShootingFlyWheels() {
        shooterFlywheelActive = true;
    }

    // "deactivateShootingFlyWheels()" commands the shooting flywheels to halt
    public void deactivateShootingFlyWheels() {
        shooterFlywheelActive = false;
    }
}