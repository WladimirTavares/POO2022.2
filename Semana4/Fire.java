package sample;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.*;


/**
 * Fire - a sample robot by Mathew Nelson, and maintained.
 * <p>
 * Sits still. Spins gun around. Moves when hit.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */

 /**
  * Herda as características do Robot
 */
public class Fire extends Robot {
	private int dist = 50; // distance to move when we're hit

	
	public void run() {
		// Set colors
		setBodyColor(Color.orange);
		setGunColor(Color.orange);
		setRadarColor(Color.red);
		setScanColor(Color.red);
		setBulletColor(Color.red);

		// Gira o canhão lentamente para a direita
		while (true) {
			turnGunRight(5);
		}
	}
	/**
	 * Método executado quando o radar do seu robô encontra um adversário.
	 * Metodos da classe ScannedRobotEvent:
     * getName() : String - Retorna o nome do robô adversário scaneado.
     * getBearing() : double - Retorna o ângulo do robô adversário em relação ao seu robô
     * getDistance() : double - Retorna a distacia do robô adversário em relação ao seu robô.
     * getEnergy() : double - Retorna o nível de energia do robô adversário
     * getHeading() : double - Retorna o ângulo em graus do adversário em relação a tela.
     * getVelocity() : double - Retorna a velocidade do robô scaneado.
     * 
     * 
     * 
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// If the other robot is close by, and we have plenty of life,
		// fire hard!
		if (e.getDistance() < 50 && getEnergy() > 50) {
			fire(3);
		} // otherwise, fire 1.
		else {
			fire(1);
		}
		// Call scan again, before we turn the gun
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
     *isMyFault() : boolean - Retorna true se foi seu robô quem originou o evento, e false 
     * se foi o adversário que bateu em seu robô.
	 */


	public void onHitByBullet(HitByBulletEvent e) {
	    //Gira perpendicularmente à bala e avança um pouco.	
        turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));
		ahead(dist);
		dist *= -1;
		scan();
	}
	/**
    * Quando o robô bate em outro: Ajusta a mira pra ele e dispara
    * intensamente
    */
	public void onHitRobot(HitRobotEvent e) {
		//É criada a variável turnGumAmt que recebe o valor do calculo
        //de quanto a mira do canhão deve ser ajustada.
        //Para encontrar o valor adequado de ajuste, é chamada a função
        //para normalizar um ângulo.
        //Nesse exemplo é feito um cálculo entre o ângulo entre os robôs somado
        //com o ângulo do adversário em relação a tela menos a inclinação do canhão
        double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
		turnGunRight(turnGunAmt);
		
        fire(3);
	}
}
