package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.props.AbstractProp;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EliteEnemyTest {
    private EliteEnemy eliteEnemy;


    @BeforeAll
    static void beforeAll(){
        System.out.println("Test of EliteEnemy Class.");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("End of Test.");
    }

    @BeforeEach
    void setUp(){
        eliteEnemy = new EliteEnemy(0,0,10,10,10);
    }

    @AfterEach
    void tearDown(){
        eliteEnemy = null;
    }

    @DisplayName("Forward Test")
    @Test
    void forward() {
        int locationX = eliteEnemy.getLocationX();
        int locationY = eliteEnemy.getLocationY();
        int speedX = eliteEnemy.getSpeedX();
        int speedY = eliteEnemy.getSpeedY();
        eliteEnemy.forward();
        assertAll("Location",
                () -> assertEquals(locationX + speedX, eliteEnemy.getLocationX()),
                () -> assertEquals(locationY + speedY, eliteEnemy.getLocationY()));
    }

    @DisplayName("Shoot Test")
    @Test
    void shoot(){
        List<BaseBullet> enemyBullets = new LinkedList<>();
        for (int i=0;i<5;i++){
            enemyBullets.addAll(eliteEnemy.shoot());
        }
        assertEquals(5, enemyBullets.size(), "Shoot Test Fail;");
    }
}