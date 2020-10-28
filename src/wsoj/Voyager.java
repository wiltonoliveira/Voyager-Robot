package wsoj;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class Voyager extends AdvancedRobot {

	double energiaAnterior = 100;
	int direcao = 1;
	int direcaoArma = 1;

	public void run() {
		setTurnGunRight(99999);
		setAhead(100);
		setTurnRight(100);
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		// Stay at right angles to the opponent
		// Fica com o lado direito virado ao oponente
		setTurnRight(e.getBearing() + 90 - 30 * direcao);

		// Se a inimigo tiver uma reducao na energia
		// assume que ele atirou
		double variaEnergia = energiaAnterior - e.getEnergy();
		if (variaEnergia > 0 && variaEnergia <= 3) {
			// Desvia
			direcao = -direcao;
			setAhead((e.getDistance() / 4 + 25) + (direcao * 0.3));
		}
		// Quando inimigo detectado,
		// gira a arma e o radar
		direcaoArma = -direcaoArma;
		setTurnGunRight(99999 - direcaoArma);
		
		// Atira 
		fire ( 2 ) ;
		 
		// Monitora o nivel de energia
		energiaAnterior = e.getEnergy();
	}
	
	
	public void onHitByBullet(HitByBulletEvent e) {
		double ladoParede = e.getBearing(); // lado da parede
		turnRight(-ladoParede);
		ahead(100); 
	}

	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(180);
		ahead(100);
	}

}
