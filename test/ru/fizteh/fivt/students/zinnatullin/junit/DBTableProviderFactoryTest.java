package ru.fizteh.fivt.students.zinnatullin.junit;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.fizteh.fivt.storage.strings.TableProvider;

public class DBTableProviderFactoryTest {

	@Test
	public void testCreate() {
		System.out.println("create");
		String dir = "";
		DBTableProviderFactory instance = new DBTableProviderFactory();
		TableProvider expResult;
		TableProvider result = instance.create(dir);
		
		File path = new File(dir);
		if(!path.exists() || !path.isDirectory()){
			expResult = null;
		} else {
			expResult = new DBTableProvider(path);
		}
		assertEquals(expResult, result);
	}
	
}
