import Characters.Enemies.Enemy;
import Characters.Enemies.Orc;
import Characters.GameCharacter;
import Characters.Heroes.Hero;
import Characters.Heroes.HeroFactory;
import Skills.SkillFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RQ14 {
    @Test
    public void RQ14_randomEnemiesInTheGame_1To5(){
        RolGame rolGame = new RolGame();
        Assert.assertEquals(0, rolGame.getEnemiesInGame().size());
        rolGame.setRandomEnemies(5);
        Assert.assertEquals(true, rolGame.getEnemiesInGame().size() > 0);
    }

    @Test
    public void RQ14_enemiesUseRandomSkillsInCombat(){
        RolGame rolGame = new RolGame();
        rolGame.addPlayer("Player_1");
        rolGame.getPlayer().select(HeroFactory.HeroClass.WARRIOR);
        rolGame.setRandomEnemies(10);
        Enemy enemy = (Enemy) rolGame.getEnemiesInGame().get(0);
        Hero hero = rolGame.getPlayer().getHeroes().get(0);
        List<GameCharacter> targets = new LinkedList<GameCharacter>();
        targets.add(hero);
        List enemies = new LinkedList();
        Enemy orc1 = new Orc();
        enemies.add(orc1);
        // Combat Manager
        List<GameCharacter> characters = new LinkedList<GameCharacter>();
        characters.add(hero);
        characters.add(orc1);
        CombatManager combatManager = new CombatManager(characters);
        //
        rolGame.setCombatManager(combatManager);
        for (int i = 0; i < 10; i++){
            SkillFactory.SkillName skillName = rolGame.getCombatManager().executeActionIA(enemy, targets);
            System.out.println(skillName);
            Assert.assertEquals(true, skillName instanceof SkillFactory.SkillName);
        }
    }
}
