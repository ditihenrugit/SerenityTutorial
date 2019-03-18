package com.studentapp.junit.studentsId;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class StudentsIdClass {
	@BeforeClass
	public static void baseUrl(){
		RestAssured.baseURI="http://localhost:9000/student";
	}
	
	@Title("This is to get all the students details")
	@Test
	public void getAllStudents(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	@Test
	public void failedTest(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(100);
	}
	
	@Test
	public void dont() throws ArithmeticException{
		System.out.println("hey"+5/0);
	}
	
	@Test
	public void compromisedtest() throws FileNotFoundException{
		File file = new File("E//pinu/test.txt");
		FileReader fr = new FileReader(file);
	}
}
