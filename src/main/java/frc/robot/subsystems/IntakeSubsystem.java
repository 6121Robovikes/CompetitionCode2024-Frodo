package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;


public class IntakeSubsystem extends SubsystemBase {
TalonFX m_intakeMotor; 
VoltageOut m_request = new VoltageOut(0);

public IntakeSubsystem() {
    m_intakeMotor = new TalonFX(OperatorConstants.PivotMotorID, "canivore");

    var slot0Configs = new Slot0Configs();
    slot0Configs.kS = 0.25; //.25 V outpot to overcome static friction
    slot0Configs.kV = 0.12; //A velocity target of 1 rps results in a 0.12 V output
    slot0Configs.kA = 0.01; //An acceleration of 1 rps/s requires 0.01 V output
    slot0Configs.kP = 0.1; // /An error of 1 prs rsults in 0.11 V output
    slot0Configs.kI = 0;
    slot0Configs.kD = 0;

   m_intakeMotor.getConfigurator().apply(slot0Configs);
}
@Override
  public void periodic() {
  }
public void feedIn() {

    final VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);

    //Set velocity to 8rps, add 0.5 V to overcome gravity
    m_intakeMotor.setControl(m_request.withVelocity(4));//adjust
}
public void feedOut() {

    final VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);
    m_intakeMotor.setControl(m_request.withVelocity(-2));//adjust
}

public void ampOut() {
    
    final VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);
    m_intakeMotor.setControl(m_request.withVelocity(-1.5)); //adjust
}

public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
}
