# Java-TDD_Kata_Rol_Game
Java local application, using Test Driven Development methodology. Rol game combat system.
It is a personal project with my own requirements like client.

**Level: HARD**<br>
**Status: Develop**

Setup:
 - JDK 1.8.0_191
 - IDE IntelliJ Idea
 - Maven (IntellliJ Idea)
 - JUnit 4


# 1. Introduction
  TDD is a methodology that let implement efficient code. To use TDD in a project, all team members musth think in TDD mode, from functional analist to junior developer.
  The TDD paradigm consist in:
  1. Take funtional requirements like technical test cases
  2. Implement an basic unit test case
  3. Write the minimun code to pass the test case
  4. Refactoring the code
  5. Repeat the poings 2, 3 and 4 to cover all requirements.

In this example I will develop a simple application using TDD. Imagine you take the next requirements:
___
Into a rol game is necessary a combat system, for build this system take the next requirements:

## Functional TDD - Phase 1 (1 vs 1)
 * RQ1. The game has only one player.
 * RQ2. The player only can use 2 heroes type: Warrior or Wizard. When the game start the player must chosse one of them.
 * RQ3. In this phase only exist 1 enemy type: Orc
 * RQ4. Hero and enemy has the same attributes: life, mana, power, spellpower, armor, spellarmor but different values.
 * RQ5. Hero start with defnied attributes according if is Warrior or Wizard:
	  * Warrior: life 100, mana 0, power 20, spellpower 0, armor 10, spellarmor 0
	  * Wizard: life 70, mana 200, power 5, spellpower 30, armor 0, spellarmor 10
 * RQ6. The enemy has attributes random into a interval:
	Orc: life 50-300, mana 30-50, power 3-6, spellpower 2-4, armor 3-5, spellarmor 3-5
 * RQ7. When player find a enemy, fight start
 * RQ8. The fight has turns, in each of them the hero o the enemy attack: hero, enemy, hero enemy
 * RQ9. Hero use habilities to fight. Some of them has coold down:
	  * **Warrior**: 
        * meeleeAttack = random(power)
        * brutalStrike = random(power) * 2 with 3 turns of CD
        * mutilate = random(power) with 4 turns of CD. This habilities produce the enemy power down a 50% for 2 turns
	  * **Wizard**:
        * meleeAttack = random(power)
        * letItGo = random(spellPower), consume 10 of mana
        * burnAll = random (spellPower) * 3 with 4 turns of CD consumes 50 mana. This habilities produce the enemy burn for 2 turns with 10% damage produces by the hability.
	  * **Orc**
        * meleeAttack = random(power)
        * bladeWithPoison = random(power) with 3 turns of CD. This habilities produce the enemy is poisoned for 2 turns with 5% damage produces by the hability
        * dirtyKick = random(power) with 5 turns of CD. This habilities produce the enemy power down a 20% for 2 turns
		
 * RQ10. Some habilities consumes mana like was defined, other produce special states in the heroes or enemy. When the character hasn't mana, can't use theses habilities
 * RQ11. When a physic attack produce damage first consume the character enemy armor. When the armor is consumed, it is not taken into account for the next turns
 * RQ12. When a magic attack produce damage first consume the spellarmor enemy armor. When the spellarmor is consumed, it is not taken into account for the next turns
 * RQ13. The player choose the hero hability to fight
 * RQ14. The enemy is controlling by the IA
 * RQ15. In this phase the fights are 1 vs 1 always
 * RQ16. When a fight start must be shown
 * RQ17. When a fight finish must be shown
 * RQ18. The damage done and special states must be shown
 * RQ19. The character life never can be negative
 * RQ20. The game finish when hero die or all enemies die.
 
## Technical TDD
 - Using Java and JUnit to TDD
 - Translate each functional requirement to several unit test to cover the behavior
 - The game must control the fights, characters and states
 - Should exist a IA for enemies control
 - Should use inheritance for characters
