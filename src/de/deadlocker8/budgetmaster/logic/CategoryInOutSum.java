package de.deadlocker8.budgetmaster.logic;

import javafx.scene.paint.Color;

public class CategoryInOutSum
{
	private int ID;
	private String name;
	private Color color;
	private int budgetIN;
	private int budgetOUT;	
	
	public CategoryInOutSum(int ID, String name, Color color, int budgetIN, int budgetOUT)
	{		
		this.ID = ID;
		this.name = name;
		this.color = color;
		this.budgetIN = budgetIN;
		this.budgetOUT = budgetOUT;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}

	public int getBudgetIN()
	{
		return budgetIN;
	}

	public void setBudgetIN(int budgetIN)
	{
		this.budgetIN = budgetIN;
	}

	public int getBudgetOUT()
	{
		return budgetOUT;
	}

	public void setBudgetOUT(int budgetOUT)
	{
		this.budgetOUT = budgetOUT;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		CategoryInOutSum other = (CategoryInOutSum)obj;
		if(ID != other.ID)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "CategoryInOutSum [ID=" + ID + ", name=" + name + ", color=" + color + ", budgetIN=" + budgetIN + ", budgetOUT=" + budgetOUT + "]";
	}
}