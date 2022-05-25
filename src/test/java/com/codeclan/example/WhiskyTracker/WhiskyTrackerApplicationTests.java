package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void canGetWhiskyFromSpecificYear(){
		List<Whisky> foundWhisky = whiskyRepository.findByYear(1991);
		assertEquals(1991, foundWhisky.get(0).getYear());
	}

	@Test
	public void canGetDistilleryByRegion(){
		List<Distillery> foundDistillery = distilleryRepository.findByRegion("Speyside");
		assertEquals("Speyside", foundDistillery.get(0).getRegion());
	}

	@Test
	public void canGetWhiskyFromPartDistFromPartAge(){
		List<Whisky> foundWhisky = distilleryRepository.findByDistillery("Viking Honour");
		List<Distillery> foundDistillery = distilleryRepository.findByAge(25);
		assertEquals("Viking Honour", 25, distilleryRepository.findByRegion());
	}

}
