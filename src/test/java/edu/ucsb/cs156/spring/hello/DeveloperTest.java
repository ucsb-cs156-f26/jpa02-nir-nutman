package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Nir", Developer.getName());
    }

    @Test 
    public void getGithubId_returns_correct_githubId() {
        assertEquals("nir-nutman", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertEquals("f26-06", t.getName());
        assertTrue(t.getMembers().contains("John"),"Team should contain John");
        assertTrue(t.getMembers().contains("Nir"),"Team should contain Nir");
        assertTrue(t.getMembers().contains("Anna"),"Team should contain Anna");
        assertTrue(t.getMembers().contains("Deserae"),"Team should contain Deserae");
        assertTrue(t.getMembers().contains("Kathleen"),"Team should contain Kathleen");
        assertTrue(t.getMembers().contains("Issac"),"Team should contain Issac");
    }

}
