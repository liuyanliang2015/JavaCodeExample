package com.test.jdk8;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

public class TestJodaTime {

	@Test
	public void testTime1(){
		final Clock clock = Clock.systemUTC();
		System.out.println( clock.instant() );
		System.out.println( clock.millis() );
	}
	
	@Test
	public void testTime2(){
		final Clock clock = Clock.systemUTC();
		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( clock );

		System.out.println( date );
		System.out.println( dateFromClock );

		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );

		System.out.println( time );
		System.out.println( timeFromClock );
	}
	
	
	
}
