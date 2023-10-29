// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */


// had to relearn java a little bit to do this lol
// We do 90% of our setup here. stuff such as button controls will also go here.
public class RobotContainer
{

    //hopefully this needs no introduction
    private final Joystick right_joy = new Joystick(0);
    private final Joystick left_joy = new Joystick(1);

    //while I am not doing so here you would also put your button commands here. See ChargedUp2023 for examples.

    private final Drive drive_system = new Drive();
    //we make the drive command here. we put in the sub system above in its arguments. The () -> <code goes here> is called a lambda or anonymous function. The best way I can explain it is putting a function (or method if you care about terminology) inside a variable. it also satisfies the DoubleSupplier interface.
    private final DriveCommand drive_command = new DriveCommand(drive_system, () -> right_joy.getRawAxis(1), () -> right_joy.getRawAxis(0), () -> left_joy.getRawAxis(1) );


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        // Configure the trigger bindings
        configureBindings();

        //Here we say that if there is no other command overriding it (which there should never be in this case) then our drive command should be used.
        drive_system.setDefaultCommand(drive_command);
    }
    
    private void configureBindings()
    {
        //you would put button bindings here. We will be making a function to allow for per driver bindings
        //Per driver bindings do not exist by default in wpilib. We get around this using a bit of a hack where we tell the command scheduler to unbind everything and then rebind everything with different buttons.
    }
    
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        //returning null is generally not a good idea as it may cause a null pointer exception (the kotlin programming language does not even let you do it without explicit checks)
        //I am only doing it here bc I do not have time to make an example robot auto. We will go over autonomous later as Randy and I are still figuring it out on the swerve drive.
        return null;
    }
}
