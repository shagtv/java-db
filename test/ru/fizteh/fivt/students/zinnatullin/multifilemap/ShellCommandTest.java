/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.fizteh.fivt.students.zinnatullin.multifilemap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shagtv
 */
public class ShellCommandTest {
	
	public ShellCommandTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of execute method, of class ShellCommand.
	 */
	@Test
	public void testExecute() {
		System.out.println("execute");
		String[] args = null;
		ShellCommand instance = new ShellCommandImpl();
		boolean expResult = false;
		boolean result = instance.execute(args);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class ShellCommand.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		ShellCommand instance = new ShellCommandImpl();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class ShellCommandImpl implements ShellCommand {

		public boolean execute(String[] args) {
			return false;
		}

		public String getName() {
			return "";
		}
	}
	
}
