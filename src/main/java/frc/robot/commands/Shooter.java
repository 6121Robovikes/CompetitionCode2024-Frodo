// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

/** Add your docs here. */
public class Shooter extends Command {
    private final ShooterSubsystem shooterSubsystem;
    
    public Shooter(ShooterSubsystem shooterSubsystem) {
        this.ShooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {}
    
    @Override
    public void execute() {

    }
}
