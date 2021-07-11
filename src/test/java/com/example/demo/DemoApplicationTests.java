package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	Album test = new Album();

	/**
	 * Constructor Test on null object
	 */
	@Test
	public void testConstructor(){
		Assertions.assertNull(test.getArtist());
	}

	/**
	 *  Constructor Test on not null object
	 */
	@Test
	public void testConstructorWithValues(){
		test = new Album("AC/DC", "High way to hell", 10, 300, "sdsd");
		Assertions.assertNotNull(test.getArtist());
	}

	/**
	 * Getters Testing
	 */

	@Test
	public void testGetters(){
		test = new Album("High way to hell", "AC/DC", 10, 300, "sdsd");
		Assertions.assertEquals("High way to hell",test.getTitle());
		Assertions.assertEquals("AC/DC",test.getArtist());
		Assertions.assertEquals(10,test.getSongCount());
		Assertions.assertEquals(300,test.getLength());
		Assertions.assertEquals("sdsd",test.getImageUrl());
	}

	/**
	 * Setters Testing
	 */
	@Test
	public void testSetters(){
		test = new Album();
		test.setTitle("sufian");
		test.setArtist("hamdan");
		test.setSongCount(5);
		test.setLength(30);
		test.setImageUrl("sdsd");
		Assertions.assertEquals("sufian",test.getTitle());
		Assertions.assertEquals("hamdan",test.getArtist());
		Assertions.assertEquals(5,test.getSongCount());
		Assertions.assertEquals(30,test.getLength());
		Assertions.assertEquals("sdsd",test.getImageUrl());
	}

}
