package pkg;
import robocode.*;


public class Vamola extends Robot{
	public void run() {
		while(true) {
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
