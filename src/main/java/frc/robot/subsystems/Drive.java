package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


//Subsystems each represent a part of the robot. Here is shown a drive subsystem (which includes the wheels mainly). You would also make subsystem for arms, intakes, launchers, etc.
public class Drive extends SubsystemBase {

    //declaring motors. m_ stands for class member and/or private variable (yes I had to look it up).
    private final CANSparkMax fLMotor;
    private final CANSparkMax fRMotor;
    private final CANSparkMax bLMotor;
    private final CANSparkMax bRMotor;

    // I would like you to just take a look at this in the docs. 90% of the time I would use driveCartesian (https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html)
    // to control the mecanum drive.
    // However, this system is much closer to what we will be using for the swerveDrive as it provides:
    // 1: It take care of all the math for us and allows us to use a standardized speed system (aka chassis speeds).
    // 2: It gives us easier odometry support which will be very important for auto (It will probably be our biggest issue this season)
    // I would recommend you read the docs so you have an understanding how all this works: https://docs.wpilib.org/en/stable/docs/software/kinematics-and-odometry/index.html
    // If you would like to see an implementation of a mecanum drive from scratch, check the Its-Pauls-Fault Repo where we used a custom implementation (mostly bc I did not know about driveCartesian).
    private final MecanumDriveKinematics kinematics;

    public Drive() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.

        //We generally declare our variables in the class and init them in the constructor. I'm not 100% sure whether this stylistic or technical but both would be valid reasons
        //notice the use of constants to mack which motor is which. CANSparkMaxLowLevel.MotorType.kBrushless just tells the class what kind of motor we are using (in this case a brushless motor)
        fLMotor = new CANSparkMax(Constants.FL_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        fRMotor = new CANSparkMax(Constants.FR_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        bLMotor = new CANSparkMax(Constants.BL_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        bRMotor = new CANSparkMax(Constants.BR_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);

        kinematics = new MecanumDriveKinematics(Constants.FL_LOC, Constants.FR_LOC, Constants.BL_LOC, Constants.BR_LOC);
    }

    public void update(ChassisSpeeds speeds) {
        MecanumDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(speeds);

        //if my memory serves me right this is to prevent the robot from shooting like a bullet into the nearest wall
        //it could also be used to increase the responsiveness if needed
        double max_speed_magnitude = 0.3;

        //The reason we need to do all this mathy stuff is bc the motors take a value of 1 to -1. This is just a rough copy of the motor speed code from the ChargedUp2023 codebase (obviously adapted for mecanum drive), specifically from the file: swerveModule.java.
        // One thing to note is that you normally do not want to repeat yourself as I have done here. by not reapeting yourself you make your life easier if you need to change it later. However, java's tools for doing this on a small scale seem limited and since it is not a big deal here I will just repeat myself.
        //If possible don't repeat yourself if it risks a massive headache later. At the same time sometime it is just easier.
        fLMotor.set((wheelSpeeds.frontLeftMetersPerSecond / Constants.WHEEL_MAX_SPEED) * max_speed_magnitude);
        fRMotor.set((wheelSpeeds.frontRightMetersPerSecond / Constants.WHEEL_MAX_SPEED) * max_speed_magnitude);
        bLMotor.set((wheelSpeeds.rearLeftMetersPerSecond / Constants.WHEEL_MAX_SPEED) * max_speed_magnitude);
        bRMotor.set((wheelSpeeds.rearRightMetersPerSecond / Constants.BR_MOTOR_ID) * max_speed_magnitude);

        /* Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself.
        Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself.
         Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself.
         Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself. Do not repeat yourself.
         */
    }
}

