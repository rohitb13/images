import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import payload.files;

public class complexresponse {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(files.dummybody());
		
		//Print No of courses returned by API
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase Amount
		int totalamount= js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		
		//Print Title of the first course
		String title = js.getString("courses[0].title");
		System.out.println(title);
		
		//Print All course titles and their respective Prices
		for(int i=0;i<count;i++)
		{
			String alltitle= js.getString("courses["+i+"].title");
			String allprices= js.getString("courses["+i+"].price").toString();
			System.out.println(alltitle);
			System.out.println(allprices);
		}
		
		//Print no of copies sold by RPA Course
		for(int i=0;i<count;i++)
		{
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
			{
				String copies = js.getString("courses["+i+"].copies").toString();
				System.out.println(copies);
			}
		}
		
		int sum=0;
		//Verify if Sum of all Course prices matches with Purchase Amount
		for(int i=0;i<count;i++)
		{
			 
			 sum=sum+(js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
			 System.out.println(sum);
			
		}
		Assert.assertEquals(sum, totalamount);
		
		

	}

}
