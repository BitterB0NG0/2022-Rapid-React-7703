package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShooterSubsystem extends SubsystemBase { 
    // Stating ShooterSubsystem Variables
    public double distanceToTarget;

    // Stating and Defining ShooterSubsystem Objects
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(Constants.floppaShooterMotorControllerPort);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(Constants.bingusShooterMotorControllerPort);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(Constants.quadingleLoadingMotorControllerPort);

    public static boolean shooterFlywheelActive = true;
    public static boolean loadWheelActive;
    public static boolean manualPowerSetting = true;

    // "ShooterSubsystem()" creates a ShooterSubsystem
    public ShooterSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
        // Setting shooting flywheel power/speed
        if (shooterFlywheelActive) {
            setFlyWheelSpeeds((RobotContainer.mainJoystick.getRawAxis(2) - 1) / 2);
            floppaShooterMotorController.set(ControlMode.PercentOutput, Constants.floppaPower);
            bingusShooterMotorController.set(ControlMode.PercentOutput, -Constants.bingusPower);
        }

        // Setting loading flywheel power/speed
        if (loadWheelActive == true) {
            quadingleLoadingMotorController.set(ControlMode.PercentOutput, Constants.quadinglePower);
        }

        // Engaging loading flywheel
        if (RobotContainer.mainJoystick.getRawButtonPressed(1)) {
            loadWheelActive = true;
        } 

        // Disengaging loading flywheel
        if (RobotContainer.mainJoystick.getRawButtonReleased(1)) {
            loadWheelActive = false;
        }

        // Switching shooting modes
        if (RobotContainer.mainJoystick.getRawButtonPressed(9)) {
            if (shooterFlywheelActive) {
                shooterFlywheelActive = false;
            } else {
                shooterFlywheelActive = true;
            }
        }
    }

    // "simulationPeriodic()" is called periodically, once per scheduler run, during simulation mode
    @Override
    public void simulationPeriodic() {}

    // "setFlyWheelSpeeds()" sets the power of the shootingFlyWheelsSpeeds
    public void setFlyWheelSpeeds(double powerSetting) {
        if (manualPowerSetting = true) {
            Constants.floppaPower = powerSetting;
            Constants.bingusPower = powerSetting;
        } else {
            //Constants.floppaPower = ;
            //Constants.bingusPower =;
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
