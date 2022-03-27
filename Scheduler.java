package frc.robot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import frc.robot.subsystems.*;

public class Scheduler {
    private static List<Runnable> listOfMethods = new ArrayList<>();
    private static List<Runnable> listOfSubsystems = new ArrayList<>();

    public static void addMethod(Runnable methodCall) {
        listOfMethods.add(methodCall);
    }

    public static void invokeMethod() {
        // if (listOfMethods.size() > 0) {
        //     listOfMethods.get(listOfMethods.size()-1).run();
        //     listOfMethods.remove(listOfMethods.size()-1);
        // }

        for(Runnable aMethod : listOfMethods) {
            aMethod.run();
        }


        for(Runnable aPeriodic : listOfSubsystems) {
            aPeriodic.run();
        }

        listOfMethods.clear();
    }

    public static void AddSubsystemPeriodic(Runnable periodic) {
        listOfSubsystems.add(periodic);
    }

}