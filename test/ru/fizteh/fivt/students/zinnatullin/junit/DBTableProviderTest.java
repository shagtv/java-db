package ru.fizteh.fivt.students.zinnatullin.junit;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.fizteh.fivt.storage.strings.Table;

public class DBTableProviderTest {
	
	File path;
	DBTableProvider instance;
	
	@Before
	public void setUp() {
		path = new File("");
		instance = new DBTableProvider(path);
	}

	@Test
	public void testGetTable() {
		System.out.println("getTable");
		String name = "";
		
		Table expResult;
		Table result = instance.getTable(name);
		
		File tablePath = new File(path, name);
		if(tablePath.exists() && tablePath.isDirectory()){
			expResult = new DBTable(name, tablePath);
		} else {
			expResult = null;
		}
		assertEquals(expResult, result);
	}

	@Test
	public void testCreateTable() {
		System.out.println("createTable");
		String name = "";

		Table expResult;
		Table result = instance.createTable(name);
		
		File tablePath = new File(path, name);
		if(tablePath.exists() && tablePath.isDirectory()){
			expResult = null;
		} else {
			if(!tablePath.isDirectory()){
				tablePath.delete();
			}
			tablePath.mkdir();
			expResult = new DBTable(name, tablePath);
		}
		assertEquals(expResult, result);
	}

	@Test
	public void testRemoveTable() {
		System.out.println("removeTable");
		String name = "";
		instance.removeTable(name);
	}
}
