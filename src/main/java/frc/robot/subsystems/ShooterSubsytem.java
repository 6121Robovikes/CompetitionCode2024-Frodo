// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class ShooterSubsytem extends SubsystemBase {
 TalonFX leftShooterMotor = new TalonFX(OperatorConstants.kShooterLeftMotorId); 
 TalonFX rightShooterMotor = new TalonFX(OperatorConstants.kShooterRightMotorId);

  VoltageOut m_request = new VoltageOut(0);

  public ShooterSubsytem() {

        leftShooterMotor.getConfigurator().apply(new TalonFXConfiguration());
    rightShooterMotor.getConfigurator().apply(new TalonFXConfiguration());

    leftShooterMotor.setInverted(true);
    rightShooterMotor.setInverted(false);

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double left_speed, double right_speed) {
    leftShooterMotor.setControl(m_request.withOutput(12.0));
    rightShooterMotor.setControl(m_request.withOutput(12.0));
 }
 
 public void stop(){
  leftShooterMotor.setControl(m_request.withOutput(0.0));
  rightShooterMotor.setControl(m_request.withOutput(0.0));
  }
  
}
