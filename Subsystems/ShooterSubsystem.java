package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase { 
    // Stating and Defining ShooterSubsystem Objects
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(Constants.floppaShooterMotorControllerPort);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(Constants.bingusShooterMotorControllerPort);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(Constants.quadingleLoadingMotorControllerPort);

    // "ShooterSubsystem()" creates a ShooterSubsystem
    public ShooterSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
    }

    // This method will be called once per scheduler run during simulation
    @Override
    public void simulationPeriodic() {
    }

    // "calculateFlyWheelSpeeds()" calculates the velocity requirements for hitting the target
    public void calculateFlyWheelSpeeds() {

    }

    // "loadShooter()" commands the loading wheel to rotate slightly and load the shooting mechanism
    public void loadShooter() {

    }

    // "activateShooter()" commands the shooter system to shoot
    public void activateShooter() {

    }

    // "activateShootingFlyWheels()" commands the shooting flywheels to spool up to the required veolcities
    public void activateShootingFlyWheels() {

    }

    // "deactivateShootingFlyWheels()" commands the shooting flywheels to halt
    public void deactivateShootingFlyWheels() {

    }
}
