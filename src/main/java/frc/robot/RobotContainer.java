// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CommandSwerveDrivetrain;
import frc.robot.commands.Shoot;
import frc.robot.commands.Source;
import frc.robot.commands.Stow;
import frc.robot.commands.Ground;
import frc.robot.constants.TunerConstants;
// import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {

   //robot's  subsystems are defined here
  public static Joystick m_joystick = new Joystick(1);
  private static final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private static final PivotSubsystem m_pivot = new PivotSubsystem();
  private static final IntakeSubsystem m_intake = new IntakeSubsystem();
  public final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain;
  // private static final ClimberSubsystem m_climb = new ClimberSubsystem();


  //drivetrain stuff... don't mess with it
  private double MaxSpeed = TunerConstants.kSpeedAt12VoltsMps; // kSpeedAt12VoltsMps desired top speed
  private double MaxAngularRate = 1.5 * Math.PI; // 3/4 of a rotation per second max angular velocity

  /* Setting up bindings for necessary control of the swerve drive platform */
  private final CommandXboxController m_controller = new CommandXboxController(0); // My controller

   // My drivetrain

  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(0.1).withRotationalDeadband(0.1) // Add a 10% deadband
      .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // I want field-centric
                                                               // driving in open loop
  private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
  private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();
  private final Telemetry logger = new Telemetry(MaxSpeed);

  private void configureBindings() {

    //drivetrain bindings
    drivetrain.setDefaultCommand( // Drivetrain will execute this command periodically
        drivetrain.applyRequest(() -> drive.withVelocityX(-m_controller.getLeftY() * MaxSpeed) // Drive forward with
                                                                                           // negative Y (forward)
            .withVelocityY(-m_controller.getLeftX() * MaxSpeed) // Drive left with negative X (left)
            .withRotationalRate(-m_controller.getRightX() * MaxAngularRate) // Drive counterclockwise with negative X (left)
        ));


   //default shooterspeed
      //  m_shooter.setDefaultCommand(new Shoot(m_shooter, 80));
   
        m_controller.a().whileTrue(drivetrain.applyRequest(() -> brake));
   m_controller.b().whileTrue(drivetrain
        .applyRequest(() -> point.withModuleDirection(new Rotation2d(-m_controller.getLeftY(), -m_controller.getLeftX()))));

    // reset the field-centric heading on left bumper press
    m_controller.leftBumper().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));

    if (Utils.isSimulation()) {
      drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(90)));
    }
    drivetrain.registerTelemetry(logger::telemeterize);

  
    //OPERATOR BINDINGS

    //stop shooter
    // JoystickButton shoot = new JoystickButton (m_joystick, 7);
    // shoot.toggleOnTrue(new Shoot(m_shooter, 20));
    // shoot.toggleOnFalse(new Shoot(m_shooter, 0));
    
    m_controller.a().whileTrue(new Shoot(m_shooter, 20));
    m_controller.a().whileFalse(new Shoot(m_shooter, 0));
    m_controller.b().whileTrue(new Source(m_pivot, m_intake));
    m_controller.x().whileTrue(new Ground(m_pivot, m_intake));
    m_controller.y().whileTrue(new Stow(m_pivot, m_intake));
    
  

    // //move arm to source, intake on
    // JoystickButton Source = new JoystickButton(m_joystick, 11);
    // Source.onTrue(new Source(m_pivot, m_intake));

    // JoystickButton Ground = new JoystickButton(m_joystick, 9);
    // Ground.onTrue(new Ground(m_pivot, m_intake));
    
    // JoystickButton Stow = new JoystickButton(m_joystick, 10);
    // Stow.onTrue(new Stow(m_pivot, m_intake));

    


    //move ar to amp, intake out

    //move arm to ground, intake in

    //mover arm to stow, intake off

    //move arm to feed, intake out

  }




  public RobotContainer() {
    configureBindings();



  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
