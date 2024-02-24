// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotSubsystem;


public class Source extends Command {

  PivotSubsystem m_pivot;

  double sourcePosition = 0; //determine this position 

  public Source(PivotSubsystem m_pivot) {
    this.m_pivot = m_pivot;
    addRequirements(m_pivot);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //m_pivot.setPosition(sourcePosition);
    System.out.println(m_pivot.getPosition());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
