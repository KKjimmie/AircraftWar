package edu.hitsz.basic;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.aircraft.MobEnemy;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFlyingObjectTest {
    private HeroAircraft heroAircraft;
    private MobEnemy mobEnemy;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Test of AbstractFlyingObject.");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("End of Test.");
    }

    @BeforeEach
    void setUp(){
        heroAircraft = HeroAircraft.getInstance(0, 0, 0, 0, 10);
        mobEnemy = new MobEnemy(0, 0, 0, 0, 10);
    }

    @AfterEach
    void tearDown() {
        heroAircraft = null;
        mobEnemy = null;
    }

    @DisplayName("Crash Test")
    @Test
    void crash() {
        assertEquals(true,heroAircraft.crash(mobEnemy), "Crash Test Fail!");
    }

    @DisplayName("Vanish Test")
    @Test
    void vanish() {
        heroAircraft.vanish();
        mobEnemy.vanish();
        assertAll("vanish",
                () -> assertEquals(false, heroAircraft.isValid),
                () -> assertEquals(false, mobEnemy.isValid)
        );
    }

}