package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.IO;
import frc.robot.SubsystemScheduler;

public class IntakeSubsystem extends SubsystemScheduler {
    // Stating IntakeSubsystem Variables
    public double intakeMotorSpeed;
    public boolean intakeOn;
    public static boolean deployingIntake;
    public static int counter = 0;
    public static boolean moveForward = false;
    public static int startedIntake = 0;

    // "IntakeSubsystem()" creates a IntakeSubsystem
    public IntakeSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {        
        // Setting intake power/speed
        if (intakeOn == true) {
            IO.intakeMotorController.set(ControlMode.PercentOutput, intakeMotorSpeed);
        } else {
            IO.intakeMotorController.set(ControlMode.PercentOutput, 0);
        }
    }

    // "activateIntake()" commands the IntakeSubsystem to activate
    public void activateIntake() {
        intakeOn = true;
    }

    // "deactivateIntake()" comamnds the IntakeSubsystem to deactivate
    public void deactivateIntake() {
        intakeOn = false;
    }

    // "increaseIntakeSpeed()" commands the IntakeSubsystem to increase its rotation speed
    public void increaseIntakeSpeed() {
        // intakeMotorSpeed = Math.round(intakeMotorSpeed * 100) / 100;
        if (intakeMotorSpeed + .1 < 1) {
            intakeMotorSpeed += 0.1;
        }
    }

    // "decreaseIntakeSpeed()" commands theIntakeSubsystem to decrease its rotation speed
    public void decreaseIntakeSpeed() {
        // intakeMotorSpeed = Math.round(intakeMotorSpeed * 100) / 100;
        if (intakeMotorSpeed - .1 > -1) {
            intakeMotorSpeed -= 0.1;
        }
    }

    // "deployIntake()" commands the IntakeSubsystem to deploy
    public void deployIntake() {
        deployingIntake = true;
        startedIntake = counter;
    }

    public void changeIntakeDirection() {
        intakeMotorSpeed = intakeMotorSpeed * -1;
    }
}