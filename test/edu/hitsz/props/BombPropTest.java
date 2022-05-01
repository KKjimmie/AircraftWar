package edu.hitsz.props;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.basic.CanBoom;
import edu.hitsz.bullet.BaseBullet;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BombPropTest {
    private BombProp bombProp;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Test of BombProp.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("End of Test.");
    }

    @BeforeEach
    void setUp() {
        bombProp = new BombProp(0, 0, 0, 0);
    }

    @AfterEach
    void tearDown () {
        bombProp = null;
    }

    @DisplayName("Boom Test")
    @Test
    void boom() {
        List<AbstractAircraft> enemys = new LinkedList<>();
        enemys.add(new EliteEnemy(0,0,0,0,10));
        List<BaseBullet> enemyBullets = new LinkedList<>();
        for (var enemy: enemys) {
            for (int i=0;i<5;i++){
                enemyBullets.addAll(enemy.shoot());
            }
        }
        for(var emeny : enemys){
            bombProp.addCanBoom((CanBoom) emeny);
        }
        for(var enemyBullet : enemyBullets){
            bombProp.addCanBoom((CanBoom) enemyBullet);
        }
        bombProp.work();
        enemys.removeIf(AbstractFlyingObject::notValid);
        enemyBullets.removeIf(AbstractFlyingObject::notValid);
        assertAll("boom",
                () -> assertEquals(0, enemys.size()),
                () -> assertEquals(0,enemyBullets.size()));
    }

    @DisplayName("BombProp Crash Test")
    @Test
    void crash(){
        HeroAircraft heroAircraft = HeroAircraft.getInstance(0, 0, 0, 0, 0);
        assertEquals(true, heroAircraft.crash(bombProp), "Crash Test Fail!");
    }
}