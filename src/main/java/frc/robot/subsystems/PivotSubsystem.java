// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class PivotSubsystem extends SubsystemBase {

  TalonFX m_pivotMotor;
  DigitalInput m_pivotLimitSwitch;  
  TalonFX m_intakeMotor;
  DigitalInput m_intakeLimitSwitch; 


  public PivotSubsystem() {

    m_pivotMotor = new TalonFX(OperatorConstants.PivotMotorID); 
    m_intakeMotor = new TalonFX(OperatorConstants.IntakeMotorID);
    m_pivotLimitSwitch = new DigitalInput(OperatorConstants.pivotLimitSwitch); 
    m_intakeLimitSwitch = new DigitalInput(OperatorConstants.intakeLimitSwitch); 
    
    // Factory default on motors
    m_pivotMotor.getConfigurator().apply(new TalonFXConfiguration());
    m_intakeMotor.getConfigurator().apply(new TalonFXConfiguration());
     // Motion Profile Position
    var slot0Configs = new Slot0Configs();
    slot0Configs.kS = 0.25; // Add 0.25 V output to overcome static friction
    slot0Configs.kV = 0.12; //A velocity target
    slot0Configs.kP = 4.8; 
    slot0Configs.kI = 0; 
    slot0Configs.kD = 0.1; 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
