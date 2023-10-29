// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
//what do you know they actually provide docs, nice.
public final class Constants
{
    //ngl I don't actually know what OperatorConstants is for. For the sake of this example we are going to ignore it
    public static class OperatorConstants
    {
        //idk why this is here either
        public static final int DRIVER_CONTROLLER_PORT = 0;
    }

    //Constants all all CAPITALIZED.

    //These are here for us to use in mainly subsystems.
    //all motor ids and encoder ids will go in this file. NEVER in the subsystem. (not counting joystick ids)
    public static final int FL_MOTOR_ID = 0;
    public static final int FR_MOTOR_ID = 1;
    public static final int BL_MOTOR_ID = 2;
    public static final int BR_MOTOR_ID = 3;

    public static final Translation2d FL_LOC = new Translation2d(0.381, 0.381);
    public static final Translation2d FR_LOC = new Translation2d(0.381, -0.381);
    public static final Translation2d BL_LOC = new Translation2d(-0.381, 0.381);
    public static final Translation2d BR_LOC = new Translation2d(-0.381, -0.381);

    //this number is crap, but I am too lazy to deal with the speed calculations (this is just an example) if you want a more proper example go to ChargedUp2023 and look for MAX_SWERVE_WHEEL_SPEED in constants
    public static final double WHEEL_MAX_SPEED = 3;
}
