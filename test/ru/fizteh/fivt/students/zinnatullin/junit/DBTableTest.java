package ru.fizteh.fivt.students.zinnatullin.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DBTableTest {

	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testGetName() {
		System.out.println("getName");
		DBTable instance = null;
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testGet() {
		System.out.println("get");
		String key = "";
		DBTable instance = null;
		String expResult = "";
		String result = instance.get(key);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testPut() {
		System.out.println("put");
		String key = "";
		String value = "";
		DBTable instance = null;
		String expResult = "";
		String result = instance.put(key, value);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testRemove() {
		System.out.println("remove");
		String key = "";
		DBTable instance = null;
		String expResult = "";
		String result = instance.remove(key);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testSize() {
		System.out.println("size");
		DBTable instance = null;
		int expResult = 0;
		int result = instance.size();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testCommit() {
		System.out.println("commit");
		DBTable instance = null;
		int expResult = 0;
		int result = instance.commit();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testRollback() {
		System.out.println("rollback");
		DBTable instance = null;
		int expResult = 0;
		int result = instance.rollback();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testReadData() {
		System.out.println("readData");
		DBTable instance = null;
		DBTable expResult = null;
		DBTable result = instance.readData();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testSaveData() {
		System.out.println("saveData");
		String nDir = "";
		String nFile = "";
		DBTable instance = null;
		DBTable expResult = null;
		DBTable result = instance.saveData(nDir, nFile);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testGetOperations() {
		System.out.println("getOperations");
		DBTable instance = null;
		int expResult = 0;
		int result = instance.getOperations();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testGetNDir() {
		System.out.println("getNDir");
		String key = "";
		String expResult = "";
		String result = DBTable.getNDir(key);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	@Test
	public void testGetNFile() {
		System.out.println("getNFile");
		String key = "";
		String expResult = "";
		String result = DBTable.getNFile(key);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
