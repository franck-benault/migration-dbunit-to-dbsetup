package net.franckbenault.migration.dbunittodbsetup;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListUtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListToString() {
		
		List<String> list = new ArrayList<String>();
		list.add("foo1");
		
		assertEquals(ListUtils.listToString(list),"\"foo1\"");

		list.add("foo2");		
		assertEquals(ListUtils.listToString(list),"\"foo1\",\"foo2\"");

	}
	
	@Test
	public void testListToStringWithNull() {
		
		List<String> list = new ArrayList<String>();
		list.add("foo1");
		
		assertEquals(ListUtils.listToStringWithNull(list,1),"\"foo1\"");
		assertEquals(ListUtils.listToStringWithNull(list,2),"\"foo1\",null");

		list.add("foo2");	
		assertEquals(ListUtils.listToStringWithNull(list,2),"\"foo1\",\"foo2\"");
		assertEquals(ListUtils.listToStringWithNull(list,4),"\"foo1\",\"foo2\",null,null");

	}

}
