package ufc;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.HitWallEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.*;

//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * FirstRobot - a robot by (your name here)
 */
public class FirstRobot extends Robot
{
	
	//Método chamado quando o round for iniciado
	
	public void run() {
		
		// Seta as cores
		setBodyColor(Color.orange);
		setGunColor(Color.orange);
		setRadarColor(Color.red);
		setScanColor(Color.red);
		setBulletColor(Color.red);
		
		// Robot main loop
		while(true) {
			//anda 100 pixels
			ahead(50);
			//Gira o canhão para a direita na quantidade informada em graus
			turnGunRight(360);
			//Move o robô para trás, pela distância calculada em pixels
			ahead(50);
			//Gira o canhão para a direita na quantidade informada em graus
			turnGunRight(360);
		}
	}

	/**
	 * Executado quando o radar do seu robô encontra um adversário.
	 * Metodos da classe ScannedRobotEvent:
		getName() : String - Retorna o nome do robô adversário scaneado.
		getBearing() : double - Retorna o ângulo do robô adversário em relação ao seu robô
		getDistance() : double - Retorna a distacia do robô adversário em relação ao seu robô.
		getEnergy() : double - Retorna o nível de energia do robô adversário
		getHeading() : double - Retorna o ângulo em graus do adversário em relação a tela.
		getVelocity() : double - Retorna a velocidade do robô scaneado.
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
		
		if( e.getDistance() < 50)
			fire(3);
		else if(e.getDistance() < 100){
			fire(2);
		}else
			fire(1);
		scan();
	}

	/**
	 * onHitByBullet: Este método é chamado quando seu robô colide com outro robô
	 * 
	 * Métodos da classe HitRobotEvent
	 *getName() : String - Retorna o nome do robô adversário colidido.
     *getBearing() : double - Retorna o ângulo do robô adversário em relação ao seu robô
     *getDistance() : double - Retorna a distacia do robô adversário em relação ao seu robô.
     *getEnergy() : double - Retorna o nível de energia do robô adversário
     *getHeading() : double - Retorna o ângulo em graus do adversário em relação a tela.
     *getVelocity() : double - Retorna a velocidade do robô scaneado.
     *isMyFault() : boolean - Retorna true se foi seu robô quem originou o evento, e false se
         foi o adversário que bateu em seu robô.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		
		fire(1);
		turnRight(45);
		ahead(100);
		scan();
	}
	
	/**
	 * onHitWall: Este método é chamado quando seu robô colide com uma parede.
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(45);
		ahead(100);
	}	
}
