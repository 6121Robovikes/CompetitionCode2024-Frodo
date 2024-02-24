// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class PivotSubsystem extends SubsystemBase {

  TalonFX m_pivotMotor;
  m_pivotLimitSwitch;   //find the name
  TalonFX m_intakeMotor;
  m_intakeLimitSwitch //find the name


  public PivotSubsystem() {

    m_pivotMotor = new TalonFX(OperatorConstants.PivotMotorID); 
    m_intakeMotor = new TalonFX(OperatorConstants.IntakeMotorID);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
