package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
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
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		assertEquals("The Glendronach Revival", whiskyRepository.findWhiskyByYear(2018).get(0).getName());
	}

	@Test
	public void canFindDistilleryByRegion(){
		assertEquals(3, distilleryRepository.getDistilleryByRegion("Highland").size());
	}

	@Test
	public void canFindWhiskyByAge(){
		assertEquals(6, whiskyRepository.findWhiskyByAge(12).size());
	}

	@Test
	public void canFindWhiskyByDistillery(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryName("Glendronach");
		assertEquals(2, foundWhiskies.size());
	}

//	@Test
//	public void canFindWhiskyByDistilleryAndAge(){
//		assertEquals(1, whiskyRepository.findWhiskyByDistilleryAndAge("Glendronach", 15).size());
//	}

}
