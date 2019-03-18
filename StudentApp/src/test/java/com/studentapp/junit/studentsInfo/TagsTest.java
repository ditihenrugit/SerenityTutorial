package com.studentapp.junit.studentsInfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase{
	
	@WithTag("studentFeature:NEGATIVE")
	@Title("This is to test negative Post request")
	@Test
	public void invalidPost(){
		SerenityRest.rest().given().when().post("/list").then().statusCode(405).log().all();
	}
	
	@WithTags({
		@WithTag("studentFeature:POSITIVE"),
		@WithTag("studentFeature:SMOKE")
	})
	@Title("This is to verify positive response")
	@Test
	public void verifyResponse(){
		SerenityRest.rest().given().when().get("/list").then().statusCode(200);
	}
	
	@WithTags({
		@WithTag("studentFeature:NEGATIVE"),
		@WithTag("studentFeature:SMOKE")
	})
	@Title("This is to test negative get request")
	@Test
	public void invalidGet(){
		SerenityRest.rest().given().when().get("/jashdk").then().statusCode(400).log().all();
	}

}
