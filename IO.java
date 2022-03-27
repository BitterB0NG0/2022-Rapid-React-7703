package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IO {
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();

    // Dive Base Subsystem
    public static WPI_VictorSPX frontLeftDriveMotorController = new WPI_VictorSPX(4);
    public static WPI_VictorSPX backLeftDriveMotorController = new WPI_VictorSPX(5);
    static MotorControllerGroup leftDriveMotorControllerGroup = new MotorControllerGroup(frontLeftDriveMotorController, backLeftDriveMotorController);

    public static WPI_VictorSPX frontRightDriveMotorController = new WPI_VictorSPX(6);
    public static WPI_VictorSPX backRightDriveMotorController = new WPI_VictorSPX(7);
    static MotorControllerGroup rightDriveControllerGroup = new MotorControllerGroup(frontRightDriveMotorController, backRightDriveMotorController);

    public static DifferentialDrive differentialDrive = new DifferentialDrive(leftDriveMotorControllerGroup, rightDriveControllerGroup);


    // Intake Subsystem
    public static WPI_VictorSPX intakeMotorController = new WPI_VictorSPX(8);


    // Shooter Subsystem
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(9);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(3);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(1);


    public static Joystick mainJoystick = new Joystick(0);

    // Global Variables
    public static double distance = 0;

    public void input() {
        // Bellow is the intake subsystem io, and an example of how to program using the scheduler
        // There are two different ways of giving the run function to the getButtonPressed() function.
        // One is this one liner method
        getButtonPressed(mainJoystick, 3, ((Runnable)( () -> intakeSubsystem.activateIntake() )));

        // The other is this two line method
        // This way should be prefered, as it is more clear as to what is happening.
        Runnable deactivateIntake = () -> intakeSubsystem.deactivateIntake();
        getButtonReleased(mainJoystick, 3, deactivateIntake);

        Runnable increaseIntakeSpeed = () -> intakeSubsystem.increaseIntakeSpeed();
        getButtonPressed(mainJoystick, 4, increaseIntakeSpeed);

        Runnable decreaseIntakeSpeed = () -> intakeSubsystem.decreaseIntakeSpeed();
        getButtonPressed(mainJoystick, 5, decreaseIntakeSpeed);

        Runnable changeIntakeDirection = () -> intakeSubsystem.changeIntakeDirection();
        getButtonPressed(mainJoystick, 2, changeIntakeDirection);


        // DriveBaseSubsystem
        Runnable moveByPosition = () -> driveBaseSubsystem.moveByPosition();;
        getButtonPressed(mainJoystick, 10, moveByPosition);

        Runnable moveByDistance = () -> driveBaseSubsystem.moveByStick();;
        getButtonPressed(mainJoystick, 11, moveByDistance);


        // ShooterSubsystem
        Runnable activateShootingFlyWheels = () -> shooterSubsystem.activateShootingFlyWheels();
        getButtonPressed(mainJoystick, 1, activateShootingFlyWheels);

        Runnable deactivateShootingFlyWheels = () -> shooterSubsystem.deactivateShootingFlyWheels();
        getButtonReleased(mainJoystick, 1, deactivateShootingFlyWheels);

    }

    public void getButtonPressed(Joystick stick, int button, Runnable command) {
        if (stick.getRawButtonPressed(button)) {
            Scheduler.addMethod(command);
        }
    }

    public void getButtonReleased(Joystick stick, int button, Runnable command) {
        if (stick.getRawButtonReleased(button)) {
            Scheduler.addMethod(command);
        }
    }
}
