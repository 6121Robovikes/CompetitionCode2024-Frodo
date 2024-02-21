// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

/** Add your docs here. */
public class Shooter extends Command {
    private final ShooterSubsystem ShooterSubsystem;
    
    public Shooter(ShooterSubsystem shooterSubsystem) {
        this.ShooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
      var talonFXConfigs = new TalonFXConfiguration(); 

    var slot0Configs = new Slot0Configs();
      slot0Configs.kS = 0.05; 
      slot0Configs.kV = 0.12;
      slot0Configs.kA = 0.01; 
      slot0Configs.kP = 0.11;
      slot0Configs.kI = 0;
      slot0Configs.kD = 0;

      var motionMagicConfigs = talonFXConfigs.MotionMagic; 
      motionMagicConfigs.MotionMagicAcceleration = 400; 
      motionMagicConfigs.MotionMagicJerk = 4000; 


      leftShooterMotor.getConfigurator().apply(talonFXConfigs);
      rightShooterMotor.getConfigurator().apply(talonFXConfigs);

    }
    
    @Override
    public void execute() {

    }
}
