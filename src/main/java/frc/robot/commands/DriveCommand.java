package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

import java.util.function.DoubleSupplier;

//Commands are the method through which we interact with the subsystems.
public class DriveCommand extends CommandBase {

    Drive drive_subsystem;

    //typically we pass in double supplier lambdas (see RobotContainer). However, I am curious to why we can not just input the joysticks themselves. needs further research.
    DoubleSupplier x;
    DoubleSupplier y;
    DoubleSupplier z;
    public DriveCommand(Drive drive_subsystem, DoubleSupplier x, DoubleSupplier y, DoubleSupplier z) {
        this.drive_subsystem = drive_subsystem;
        this.x = x;
        this.y = y;
        this.z = z;


        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.drive_subsystem);
    }

    //triggers when the command is scheduled. This would also be useful for buttons. The difference between this and the constructor is the constructor is run once when the command is created. However, this is run everytime the command is scheduled (for example when a button is pressed)
    @Override
    public void initialize() {

    }

    //this runs every 20ms or so. We don't often use any methods other than this. However, I would recommend you become familiar with them as they can be useful
    @Override
    public void execute() {
        //ChassisSpeeds is at this point our standard for controlling the drive system of robots
        ChassisSpeeds speeds = new ChassisSpeeds(x.getAsDouble(), y.getAsDouble(), z.getAsDouble());
        drive_subsystem.update(speeds);
    }

    //Tells the command scheduler whether the command is done. Good for one time button commands that take a bit (For example moving an arm up and down).
    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    //Will trigger once the command is killed. I guess you could use this for teardown code. The interrupted argument is telling you weather this command ended naturally or whether something interrupted it
    @Override
    public void end(boolean interrupted) {

    }
}
