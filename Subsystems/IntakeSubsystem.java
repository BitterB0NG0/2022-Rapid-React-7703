package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeSubsystem extends SubsystemBase {

    public double intakeMotorSpeed;

    /** Creates a new ExampleSubsystem. */
    public IntakeSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if (Constants.runningIntake == true) {
            activateIntake();
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
        Constants.intakeMotorController.set(intakeMotorSpeed);
    }

    public void deactivateIntake() {
        Constants.intakeMotorController.set(0);
    }

    public void increaseIntakeSpeed() {
        intakeMotorSpeed += 0.05;
    }

    public void decreaseIntakeSpeed() {
        intakeMotorSpeed -= 0.05;
    }
}
