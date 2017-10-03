package de.deadlocker8.budgetmasterserver.server.payment.normal;

import static spark.Spark.halt;

import java.util.ArrayList;

import de.deadlocker8.budgetmasterserver.logic.database.DatabaseHandler;
import de.deadlocker8.budgetmasterserver.logic.database.DatabaseTagHandler;
import spark.Request;
import spark.Response;
import spark.Route;

public class PaymentDelete implements Route
{
	private DatabaseHandler handler;
	private DatabaseTagHandler tagHandler;
	
	public PaymentDelete(DatabaseHandler handler, DatabaseTagHandler tagHandler)
	{		
		this.handler = handler;
		this.tagHandler = tagHandler;
	}

	@Override
	public Object handle(Request req, Response res) throws Exception
	{
		if(!req.queryParams().contains("id"))
		{
			halt(400, "Bad Request");
		}			
		
		int id = -1;		
		
		try
		{				
			id = Integer.parseInt(req.queryMap("id").value());
			
			if(id < 0)
			{
				halt(400, "Bad Request");
			}
			
			try
			{						
				handler.deletePayment(id);	
				ArrayList<Integer> tagIDs = tagHandler.getAllTagsForPayment(id);				
				for(Integer currentTagID : tagIDs)
				{
					tagHandler.deleteTagMatchForPayment(currentTagID, id);
				}

				return "";
			}
			catch(IllegalStateException ex)
			{
				halt(500, "Internal Server Error");
			}
		}
		catch(Exception e)
		{
			halt(400, "Bad Request");
		}
		
		return "";
	}
}