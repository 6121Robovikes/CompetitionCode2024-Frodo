// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.configs.MotionMagicConfigs;

import edu.wpi.first.units.Velocity;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

/** Add your docs here. */
public class Shooter extends Command {
    private final ShooterSubsystem ShooterSubsystem;
    
    
    public Shooter(ShooterSubsystem shooterSubsystem) {
        ShooterSubsystem = shooterSubsystem;
        addRequirements(ShooterSubsystem);
    }



    @Override
    public void initialize() {
      
    }
    
    @Override
    public void execute() {

      // SET SPEED!
    ShooterSubsystem.setControl(MotionMagicCruiseVelocity);

    }

    @Override
    public boolean isFinished() {
      return true;
    }
}
