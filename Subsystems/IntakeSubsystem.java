package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeSubsystem extends SubsystemBase {
    // Stating IntakeSubsystem Variables
    public double intakeMotorSpeed;
    public boolean intakeOn;

    // Stating and Defining IntakeSubsystem Objects
    public static WPI_VictorSPX intakeMotorController = new WPI_VictorSPX(Constants.intakeMotorControllerPort);

    // "IntakeSubsystem()" creates a IntakeSubsystem
    public IntakeSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
        if (intakeOn == true) {
            intakeMotorController.set(ControlMode.PercentOutput, intakeMotorSpeed);
        } else {
            intakeMotorController.set(ControlMode.PercentOutput, 0);
        }

        if (RobotContainer.mainJoystick.getRawButtonPressed(4)) {
            increaseIntakeSpeed();
        }

        if (RobotContainer.mainJoystick.getRawButtonPressed(5)) {
            decreaseIntakeSpeed();
        }

        if (RobotContainer.mainJoystick.getRawButtonPressed(2)) {
            intakeMotorSpeed = intakeMotorSpeed * -1;
        }
    }

    // "simulationPeriodic()" is called periodically, once per scheduler run, during simulation mode
    @Override
    public void simulationPeriodic() {
    }

    // "activateIntake()" commands the IntakeSubsystem to activate
    public void activateIntake() {
        intakeOn = true;
    }

    // "deactivateIntake()" comamnds the IntakeSubsystem to deactivate
    public void deactivateIntake() {
        intakeOn = false;
    }

    // "increaseIntakeSpeed()" commands the IntakeSubsystem to increase in rotation speed
    public void increaseIntakeSpeed() {
        // intakeMotorSpeed =  Math.round(intakeMotorSpeed * 100) / 100;
        if (intakeMotorSpeed + .1 < 1) {
            intakeMotorSpeed += 0.1;
        }
    }

    // "decreaseIntakeSpeed()" commands theIntakeSubsystem to decrease in rotation speed
    public void decreaseIntakeSpeed() {
        // intakeMotorSpeed =  Math.round(intakeMotorSpeed * 100) / 100;
        if (intakeMotorSpeed - .1 > -1) {
            intakeMotorSpeed -= 0.1;
        }
    }
}
