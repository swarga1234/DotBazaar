package com.swarga.project.dotbazaar.util;

public class GeneralUtilities {
	
	public static String getFirstTenWordsOFDesc(String desc)
	{
		desc=desc.substring(1, desc.length()-1);
		desc=desc.replaceAll("[^\\x00-\\x7F]", "");
		String[] descWords=desc.split(" ");
		if(descWords.length>10)
		{
			String res="";
			for(int i=0; i<10;i++)
			{
				res=res+descWords[i]+" ";
			}
			return res+"...";
		}
		else
		{
			return desc+" ...";
		}
	}

	public static double getDiscountedPrice(double price, double discountPercent)
	{
		double discount=discountPercent/100 *price;
		if(discount>=price)
		{
			return 0.0;
		}
		double discountedPrice=price-discount;
		return discountedPrice;
		
	}
}
