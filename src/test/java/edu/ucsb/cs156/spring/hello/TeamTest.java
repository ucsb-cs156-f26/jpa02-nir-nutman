package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team{name=test-team, members=[]}", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_team() {
        Team sameTeam = new Team("test-team");
        assert(team.equals(sameTeam));
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_for_same_name_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");

        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name_same_members() {
        Team other = new Team("different-team");

        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name_and_members() {
        Team other = new Team("different-team");
        other.addMember("Alice");

        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        String notATeam = "not-a-team";
        assert(!team.equals(notATeam));
    }

    @Test
    public void equals_returns_true_for_casted_object() {
        Object castedTeam = new Team("test-team");
        assert(team.equals(castedTeam));
    }

    @Test
    public void hash_code_returns_correct_value() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
