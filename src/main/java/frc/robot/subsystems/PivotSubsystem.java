// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class PivotSubsystem extends SubsystemBase {

  TalonFX m_pivotMotor;



  public PivotSubsystem() {

    m_pivotMotor = new TalonFX(OperatorConstants.PivotMotorID, "Canivore"); 
    
    
    // Factory default on motors
    m_pivotMotor.getConfigurator().apply(new TalonFXConfiguration());
   

     // Motion Profile Position
    var slot0Configs = new Slot0Configs();
    slot0Configs.kS = 0.25; // Add 0.25 V output to overcome static friction
    slot0Configs.kV = 0.12; // A velocity target of 1 rps results in 0.12 V output
    slot0Configs.kP = 1; // A position error of 2.5 rotations results in 12 V output
    slot0Configs.kI = 0; // no output for integrated error
    slot0Configs.kD = 0.1; // A velocity error of 1 rps results in 0.1 V output

    m_pivotMotor.getConfigurator().apply(slot0Configs);


  }
  public void setPosition(double position) {
    
    //final PositionVoltage m_request = new PositionVoltage(0).withSlot(0);

    //Change the 0 until arm hold position, also realy hard math so don't do it yet
    //m_pivotMotor.setControl(m_request.withPosition(position).withFeedForward(0));


    // Trapezoid profile with max velocity 2 rps, max accel 8 rps/s
  final TrapezoidProfile m_profile = new TrapezoidProfile(
   new TrapezoidProfile.Constraints(2, 8));

// Final target of 200 rot, 0 rps
TrapezoidProfile.State m_goal = new TrapezoidProfile.State(position, 0);
TrapezoidProfile.State m_setpoint = new TrapezoidProfile.State();

// create a position closed-loop request, voltage output, slot 0 configs
final PositionVoltage m_request = new PositionVoltage(position).withSlot(0);


// send the request to the device
m_request.Position = m_setpoint.position;
m_request.Velocity = m_setpoint.velocity;
m_pivotMotor.setControl(m_request);

   }


   
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
