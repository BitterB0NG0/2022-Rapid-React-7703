package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    public double intakeMotorSpeed;
    public boolean intakeOn;

    public static WPI_VictorSPX intakeMotorController = new WPI_VictorSPX(Constants.intakeMotorControllerPort);

    /** Creates a new ExampleSubsystem. */
    public IntakeSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if (intakeOn == true) {
            intakeMotorController.set(intakeMotorSpeed);
        } else {
            intakeMotorController.set(0);
        }

        if (Constants.mainJoystick.getRawButtonPressed(4)) {
            increaseIntakeSpeed();
        }

        if (Constants.mainJoystick.getRawButtonPressed(5)) {
            decreaseIntakeSpeed();
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public void activateIntake() {
        intakeOn = true;
    }

    public void deactivateIntake() {
        intakeOn = false;
    }

    public void increaseIntakeSpeed() {
        intakeMotorSpeed += 0.05;
    }

    public void decreaseIntakeSpeed() {
        intakeMotorSpeed -= 0.05;
    }
}
