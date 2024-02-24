// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;


public class Shoot extends Command {
    
  ShooterSubsystem m_shooter;

  public Shoot(ShooterSubsystem m_shooter) {
       
    
        addRequirements(m_shooter);
    }


    @Override
    public void initialize() {
      
    }
    
    @Override
    public void execute() {

    m_shooter.shoot();

    }

    @Override
    public boolean isFinished() {
      return true;
    }
}
