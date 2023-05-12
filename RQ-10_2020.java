package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  CANSparkMax shooter = new CANSparkMax(13, MotorType.kBrushless);
  Joystick control1= new Joystick(0);
  Joystick control2 = new Joystick(1);

  /*------------------------------------*/

  Compressor compressor1 = new Compressor(0);
 
  /*-----------------------------------*/

  Solenoid escalarArriba = new Solenoid(7);
  Solenoid escalarAbajo = new Solenoid(4);
  Solenoid velocidades = new Solenoid(5);
  Solenoid intakepiston = new Solenoid(3);
  Solenoid conveyerPiston = new Solenoid(6);
  

  /*------------------------------*/

  double tanqueDerecho;
  double tanqueIzquierdo;
/*------------------------------*/

  TalonSRX derecha1 = new TalonSRX(1);
  TalonSRX derecha2 = new TalonSRX(2);
  TalonSRX izquierda1 = new TalonSRX(3);
  TalonSRX izquierda2= new TalonSRX(4);

  /*-------------------------------*/

  
  PWMVictorSPX conveyerMotor = new PWMVictorSPX(7);
  PWMVictorSPX intakeMotor = new PWMVictorSPX(6);
  //PWMVictorSPX ruleta = new PWMVictorSPX();

  /*-------------------------------*/

  boolean intakePistonActivado = false;
  boolean intakeBotonActivado = false;
  boolean conveyerPistonActivado = false;
  boolean conveyerBotonPistonActivado = false;
  boolean conveyerMotorActivado= false;
  boolean conveyerBotonMotorActivado = false;
  boolean tiradorMotorActivado = false;
  boolean tiradorBotonActivado = false;
  boolean conveyerMotorActivadoNeg= false;
  boolean conveyerBotonMotorActivadoNeg = false;
  
  /*-------------------------------*/

  double velocidadPositivaBaja = 0.25D;
  double velocidadNegativaBaja = -0.25D;
  double velocidadPositivaMedia = 0.5D;
  double velocidadNegativaMedia = -0.5D;
  double velocidadPositivaAlta = 1D;
  double velocidadNegativaAlta = -1D;

  /*----------------------------------*/

  short giro90 = 950;
  short giro45 = (short)(giro90/2 );
  short giro180 = (short)(giro90*2);
  short giro360 = (short)(giro180*2);
  short giro225 = (short)(giro180+giro45);
  short giro135 = (short)(giro180-giro45);

  /*----------------------------------*/

  AHRS navx = new AHRS(SPI.Port.kMXP);
 
  /*----------------------------------*/

  AnalogInput analogPixy = new AnalogInput(0);//F
  DigitalInput digitalPixy = new DigitalInput(0);//RIP 

  /*----------------------------------*/

  //CONTROL DRIVER

 public void Velocidad(){
    if (control1.getRawButton(5)){ //Primer velocidad
       velocidades.set(false);
     }
     if (control1.getRawButton(6)){ // Segunda velocidad
       velocidades.set(true);
     }

 }

 public void Escalador(){
  if(control1.getRawButton(8)){ //presionas y sube el 2do nivel del escalador
      escalarArriba.set(true);
     } else {
      escalarArriba.set(false);
     }
   if(control1.getRawButton(7)){  //mantienes presionado y sube el 1er nivel
      escalarAbajo.set(true);
     }else{
     escalarAbajo.set(false);
    }
       }


 public void Tirador(){
  


  /*
  if(control1.getRawButtonPressed(3)){
    if(!tiradorBotonActivado){
        tiradorMotorActivado = !tiradorMotorActivado;
        tiradorBotonActivado = true;
    }
    else{
       tiradorBotonActivado = false;
    }
   if(tiradorMotorActivado){
       tirador1.set(-1); //
       tirador2.set(-1); //
    }else{
      tirador1.set(0);
      tirador2.set(0);
      }
    }*/
  }


/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//CONTROL PLACER
public void BotonesPrincipales2(){


if(control1.getRawButton(2)){ //motor conveyer baja pelotas
       conveyerMotor.set(1);
       intakeMotor.set(-1);
     } else if(control1.getRawButton(3)){ //motor conveyer sube pelotas
        conveyerMotor.set(-1);
        intakeMotor.set(1);
     }
     else{
      conveyerMotor.set(0);
      intakeMotor.set(0);
    }

    /*
 if(control2.getRawButton(7)){
 
  intakepiston.set(true);
}
    if(control2.getRawButton(78)){
      intakepiston.set(false);
    
  }*/
     

 }



 public void Pistonb (){
 if(control1.getRawButtonPressed(9)){         
          conveyerPiston.set(true);
        }

        if(control1.getRawButtonPressed(10)){
          conveyerPiston.set(false);
         }
 }
 








  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    /* public void Adelante() {
       derecha1.set(ControlMode.PercentOutput, velocidadPositivaBaja);
       derecha2.set(ControlMode.PercentOutput, velocidadPositivaBaja);
       izquierda1.set(ControlMode.PercentOutput, velocidadNegativaBaja);
       izquierda2.set(ControlMode.PercentOutput, velocidadNegativaBaja);
     }*/
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    /* public void Atras() {
       derecha1.set(ControlMode.PercentOutput, velocidadNegativaBaja);
       derecha2.set(ControlMode.PercentOutput, velocidadNegativaBaja);
       izquierda1.set(ControlMode.PercentOutput, velocidadPositivaBaja);
       izquierda2.set(ControlMode.PercentOutput, velocidadPositivaBaja);
     }*/

     public void AdelanteBaja() {
      izquierda1.set(ControlMode.PercentOutput, velocidadPositivaBaja);
      izquierda2.set(ControlMode.PercentOutput, velocidadPositivaBaja);
      derecha1.set(ControlMode.PercentOutput, velocidadNegativaBaja);
      derecha2.set(ControlMode.PercentOutput, velocidadNegativaBaja);
    }
  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    public void AtrasBaja() {
      izquierda1.set(ControlMode.PercentOutput, velocidadNegativaBaja);
      izquierda2.set(ControlMode.PercentOutput, velocidadNegativaBaja);
      derecha1.set(ControlMode.PercentOutput, velocidadPositivaBaja);
      derecha2.set(ControlMode.PercentOutput, velocidadPositivaBaja);
    }
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
     public void GirarDerechaBaja() {
       derecha1.set(ControlMode.PercentOutput, velocidadPositivaBaja);
       derecha2.set(ControlMode.PercentOutput, velocidadPositivaBaja);
       izquierda1.set(ControlMode.PercentOutput, velocidadPositivaBaja);
       izquierda2.set(ControlMode.PercentOutput, velocidadPositivaBaja);
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */

     }
     public void GirarIzquierdaBaja() {
       izquierda1.set(ControlMode.PercentOutput, velocidadNegativaBaja);
       izquierda2.set(ControlMode.PercentOutput, velocidadNegativaBaja);
       derecha1.set(ControlMode.PercentOutput, velocidadNegativaBaja);
       derecha2.set(ControlMode.PercentOutput, velocidadNegativaBaja);
     }

     public void AdelanteMedia() {
      izquierda1.set(ControlMode.PercentOutput, velocidadPositivaMedia);
      izquierda2.set(ControlMode.PercentOutput, velocidadPositivaMedia);
      derecha1.set(ControlMode.PercentOutput, velocidadNegativaMedia);
      derecha2.set(ControlMode.PercentOutput, velocidadNegativaMedia);
    }
  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    public void AtrasMedia() {
      izquierda1.set(ControlMode.PercentOutput, velocidadNegativaMedia);
      izquierda2.set(ControlMode.PercentOutput, velocidadNegativaMedia);
      derecha1.set(ControlMode.PercentOutput, velocidadPositivaMedia);
      derecha2.set(ControlMode.PercentOutput, velocidadPositivaMedia);
    }
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
     public void GirarDerechaMedia() {
       derecha1.set(ControlMode.PercentOutput, velocidadPositivaMedia);
       derecha2.set(ControlMode.PercentOutput, velocidadPositivaMedia);
       izquierda1.set(ControlMode.PercentOutput, velocidadPositivaMedia);
       izquierda2.set(ControlMode.PercentOutput, velocidadPositivaMedia);
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */

     }
     public void GirarIzquierdaMedia() {
       izquierda1.set(ControlMode.PercentOutput, velocidadNegativaMedia);
       izquierda2.set(ControlMode.PercentOutput, velocidadNegativaMedia);
       derecha1.set(ControlMode.PercentOutput, velocidadNegativaMedia);
       derecha2.set(ControlMode.PercentOutput, velocidadNegativaMedia);

     }

     public void AdelanteAlta() {
      izquierda1.set(ControlMode.PercentOutput, velocidadPositivaAlta);
      izquierda2.set(ControlMode.PercentOutput, velocidadPositivaAlta);
      derecha1.set(ControlMode.PercentOutput, velocidadNegativaAlta);
      derecha2.set(ControlMode.PercentOutput, velocidadNegativaAlta);
    }
  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    public void AtrasAlta() {
      izquierda1.set(ControlMode.PercentOutput, velocidadNegativaAlta);
      izquierda2.set(ControlMode.PercentOutput, velocidadNegativaAlta);
      derecha1.set(ControlMode.PercentOutput, velocidadPositivaAlta);
      derecha2.set(ControlMode.PercentOutput, velocidadPositivaAlta);
    }
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
     public void GirarDerechaAlta() {
       derecha1.set(ControlMode.PercentOutput, velocidadPositivaAlta);
       derecha2.set(ControlMode.PercentOutput, velocidadPositivaAlta);
       izquierda1.set(ControlMode.PercentOutput, velocidadPositivaAlta);
       izquierda2.set(ControlMode.PercentOutput, velocidadPositivaAlta);
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */

     }
     public void GirarIzquierdaAlta() {
       izquierda1.set(ControlMode.PercentOutput, velocidadNegativaAlta);
       izquierda2.set(ControlMode.PercentOutput, velocidadNegativaAlta);
       derecha1.set(ControlMode.PercentOutput, velocidadNegativaAlta);
       derecha2.set(ControlMode.PercentOutput, velocidadNegativaAlta);

     }


   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
     public void Alto() {
       izquierda1.set(ControlMode.PercentOutput,0);
       izquierda2.set(ControlMode.PercentOutput,0);
       derecha1.set(ControlMode.PercentOutput,0);
       derecha2.set(ControlMode.PercentOutput,0);
     }

     public void Intake(){
       intakeMotor.set(-0.75);
     }
     
     public void disparar() {
   
       conveyerMotor.set(-1);
     }
     public void conveyer(){
       conveyerMotor.set(.75);
     }
/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
    public void gironavxizq90(){
      
      while(navx.getYaw()>=-83){
        GirarIzquierdaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
        while(navx.getYaw()<=-95){
          GirarDerechaMedia();
            SmartDashboard.putNumber(   "yaw",       navx.getYaw());
            SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }

    public void gironavxder90(){
      while(navx.getYaw()<85){
          GirarDerechaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }

    public void gironavxizq180(){
      while(navx.getYaw()>-175){
          GirarIzquierdaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }

    public void gironavxder180(){
      while(navx.getYaw()<175){
          GirarDerechaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }
    public void gironavxizq90180() {
      while (navx.getYaw()>-173){
        GirarIzquierdaMedia();
      }
    }

    public void gironavxparedder50(){
      while(navx.getYaw()<=50){
          GirarDerechaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
      while(navx.getYaw()>=53){
          GirarIzquierdaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }

    public void gironavxtargetder150(){
      while(navx.getYaw()<=130){
          GirarDerechaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
      while(navx.getYaw()>=125){
          GirarIzquierdaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }

    public void gironavxtargetder150180(){
      while(navx.getYaw()>=120 && navx.getYaw()<=178){
          GirarDerechaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    
    }


    public void gironavxizq090(){
      while(navx.getYaw()>=1){
        GirarIzquierdaBaja();
          SmartDashboard.putNumber(   "yaw",       navx.getYaw());
          SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
        }
    }


  /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
  public void caminoDerecha() {


   }
 /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
   public void caminoCentro() {

   }
   /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
   public void caminoIzquierda(){

   }

    public double getPixyX(){
      return analogPixy.getValue();
    }
    public boolean isObjectPresent(){
      return digitalPixy.get();
    }
     
    
  public void caminoparedderecha(){
    try {
      AdelanteBaja();
      Thread.sleep(700);
      Alto();
      Thread.sleep(250);
      gironavxparedder50();
      AdelanteBaja();
      Thread.sleep(800);
      Alto();
      Thread.sleep(1000);
      //disparar();
      //Thread.sleep(1000);
      AdelanteBaja();
      Thread.sleep(1500);
      Alto();
      Thread.sleep(1000);
      
      


    } catch (Exception e) {
      //TODO: handle exception
    }

  }
  
  public void caminofrentarget(){
    try {
      disparar();
      Thread.sleep(1000);
      AtrasAlta();
      Thread.sleep(450);
      Alto();
      Thread.sleep(250);
      gironavxtargetder150();
      AdelanteAlta();
      Thread.sleep(750);
      Alto();
      Thread.sleep(500);
      gironavxtargetder150180();
      Alto();
      Thread.sleep(500);
      intakepiston.set(true);
     //Desplegar_y_Activar_Intake_ADELANTE();
      Thread.sleep(10000);   


    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  public void caminoparedizquierda(){
    try {
      AdelanteMedia();
      Thread.sleep(1000);
      Alto();
      Thread.sleep(500);
      gironavxder90();
      AdelanteMedia();
      Thread.sleep(1000);
      Alto();
      Thread.sleep(250);
      gironavxizq090();
      AdelanteMedia();
      Thread.sleep(2800);
      Alto();
      Thread.sleep(250);
      gironavxizq90();
      AdelanteBaja();
      Thread.sleep(1000);
      Alto();
      Thread.sleep(20000);
      disparar();

    } catch (Exception e) {
      //TODO: handle exception
    }
    
  }
  public void Test(){

      try{
          AdelanteAlta();
          Thread.sleep(1000);
          Alto();

          Thread.sleep(5000);
          AdelanteMedia();
          Thread.sleep(1000);
          Alto();
          Thread.sleep(5000);
          AdelanteBaja();
          Thread.sleep(1000);
          GirarDerechaMedia();
          Thread.sleep(giro90);
          Alto();
          Thread.sleep(1000);
          GirarIzquierdaMedia();
          Thread.sleep(giro90);

    }     catch(Exception e){

}

  }




/************************************************************************************************************************************************************************************************************** */
  @Override
  public void robotInit() {
    
    CameraServer.getInstance().startAutomaticCapture(0);
    CameraServer.getInstance().startAutomaticCapture(1);
    SmartDashboard.putNumber( "yaw",       navx.getYaw());
    SmartDashboard.putNumber(   "Displacement_Y",       navx.getDisplacementY());
    compressor1.setClosedLoopControl(true);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
      try {
     AdelanteMedia();
     Thread.sleep(1300);   
     /*GirarDerechaMedia();
     Thread.sleep(500);   
     AdelanteMedia();
     Thread.sleep(1000);*/
    Alto();
    Thread.sleep(14000);
    } catch (Exception e) {
      //TODO: handle exception
    }
  }


  @Override
  public void autonomousPeriodic() {
   SmartDashboard.putNumber(   "yaw",       navx.getYaw());
  }

  @Override
  public void teleopPeriodic() {
    //DRIVER
    compressor1.start();
  
   
   tanqueDerecho = control1.getRawAxis(5);
    tanqueIzquierdo= control1.getRawAxis(1) *-1;
    derecha1.set(ControlMode.PercentOutput, tanqueDerecho);
    derecha2.set(ControlMode.PercentOutput, tanqueDerecho);
    izquierda1.set(ControlMode.PercentOutput, tanqueIzquierdo);
    izquierda2.set(ControlMode.PercentOutput, tanqueIzquierdo);

    if(control1.getRawButton(1)){
  shooter.set(1);///
    }
  else {
    shooter.set(0);
  }
   Velocidad();
   Escalador();
   
 
  //PLACER
  BotonesPrincipales2(); //meter-sacar pelotas
  //Placer();
  Pistonb(); //piston conveyer
  //Tirador();
  }

  @Override
  public void testPeriodic() {
  }
}