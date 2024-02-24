// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class ShooterSubsystem extends SubsystemBase {
 TalonFX m_leftShooterMotor; 
 TalonFX m_rightShooterMotor;
 VoltageOut m_request = new VoltageOut(0);

  
  public ShooterSubsystem() {
    
    m_leftShooterMotor = new TalonFX(OperatorConstants.ShooterLeftMotorId); 
    m_rightShooterMotor = new TalonFX(OperatorConstants.ShooterRightMotorId);

    m_leftShooterMotor.setInverted(true);
    m_rightShooterMotor.setInverted(false);
   

    m_leftShooterMotor.getConfigurator().apply(new TalonFXConfiguration());
    m_rightShooterMotor.getConfigurator().apply(new TalonFXConfiguration());


    var talonFXConfigs = new TalonFXConfiguration();

    var slot0Configs = new Slot0Configs();
      slot0Configs.kS = 0.25; //.25 V outpot to overcome static friction
      slot0Configs.kV = 0.12; //A velocity target of 1 rps results in a 0.12 V output
      slot0Configs.kA = 0.01; //An acceldration of 1 rps/s requires 0.01 V output
      slot0Configs.kP = 0.11; // /An error of 1 prs rsults in 0.11 V output
      slot0Configs.kI = 0;
      slot0Configs.kD = 0;

     m_leftShooterMotor.getConfigurator().apply(slot0Configs);
     m_rightShooterMotor.getConfigurator().apply(slot0Configs);

  }

  @Override
  public void periodic() {

  VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);
  }

  public void shoot() {

    //Set velocity to 8rps, add 0.5 V to overcome gravity

    m_leftShooterMotor.setControl(m_request.withVelocity(8).withFeedForward(0.5));
    m_rightShooterMotor.setControl(m_request.withVelocity(8).withFeedForward(0.05));
 }
 
  public void stop(){
    m_leftShooterMotor.setControl(m_request.withVelociy(0));
    m_rightShooterMotor.setControl(m_request.withVelocity(0));
  }

  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  
}
