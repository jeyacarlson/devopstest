package devopstest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Concatenator {
	
	
   @RequestMapping("/")
   String home() {
	    Concatenator lTest = new Concatenator();
		List lTokens = new ArrayList<String>();
		lTokens.add("first");
		lTokens.add("second");
		lTest.setTokens(lTokens);
	    return "Welcome to Concatenator!" + lTest.concatenate();
    }
	  
	private List<String> aTokens;
	
	public String 
	concatenate()
	{
		StringBuffer lResult = new StringBuffer();
		if (aTokens != null)
		{
			for (String pToken:aTokens)
			{
				lResult.append(pToken);
			}
		}
		return lResult.toString();
	}
	
	
	

	public List<String> getTokens()
	{
		return aTokens;
	}

	public void setTokens(List<String> pTokens)
	{
		aTokens = pTokens;
	}

	
	public static void main(String[] args) throws Exception{
		
		SpringApplication.run(Concatenator.class, args);		
		
	}

}
