//package skeleton;
package cucumbertests;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import devopstest.Concatenator;;

public class ConcatenatorStepdefs {
	List<String> aTokens;
	Concatenator aConcatenator;
		
	@Given("^I have Tokens (.*) and (.*)$")
	public void i_have_Tokens_First_and_Second(String pFirst, String pSecond) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		aTokens = new ArrayList<String>();
		aTokens.add(pFirst);
		aTokens.add(pSecond);
	}
	
	@Given("^I have multiple Tokens (.*)$")
	public void i_have_multiple_Tokens_Red_Blue_Green_Yellow_Orange_White(String pInput) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String[] lTokens = pInput.split(",");
	    aTokens = new ArrayList<String>();
	    for (String lToken: lTokens)
	    {
			aTokens.add(lToken);
	    }
	  
	}

	@When("^I create a Concatenator$")
	public void i_create_a_Concatenator() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		aConcatenator = new Concatenator();
		aConcatenator.setTokens(aTokens);
	}
	
	@Then("^the concatenate method should return the concatenated result$")
	public void the_concatenate_method_should_return_the_concatenated_result() throws Throwable {
		    String lConcatenatedResult = aConcatenator.concatenate();
		    String lExpectedConcatenatedResult = StringUtils.join(aTokens, "");
		    Assert.assertEquals(lExpectedConcatenatedResult, lConcatenatedResult);		
	}
	
	
	@Given("^I have Threee Tokens (.*),  (.*) and (.*)$")
	public void i_have_Threee_Tokens_Yes_No_and_Maybe(String pFirst, String pSecond, String pThird) throws Throwable {
		aTokens = new ArrayList<String>();
		aTokens.add(pFirst);
		aTokens.add(pSecond);
		aTokens.add(pThird);
	}




}
