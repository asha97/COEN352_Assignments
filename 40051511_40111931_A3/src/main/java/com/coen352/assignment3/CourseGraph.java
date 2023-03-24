package com.coen352.assignment3;

public class CourseGraph extends GraphImpl{
	public String [] courses;
	public CourseGraph()
	{
		courses = new String [def_size];
	}
	public CourseGraph(int n)
	{
		Init(n);
		courses = new String [n];
	}
	
	public void clear()
	{
		for(int i = 0; i < this.n(); i++)
		{
			this.setMark(i, UNVISITED);
		}
	}
	
	public String getPrerequisitePath(String courseCode) { 
		this.clear();
		ADTStack <String> stack = new AStack <String> (100);
		ADTStack <String> stackToOutput = new AStack <String> (100);
		String toReturn = "";
		stack.push(courseCode);
		stackToOutput.push(courseCode);
		
		while(stack.length() > 0)
		{
			String v = stack.pop();
			
			String [] prereqs = this.getPrerequisiteHelp(v); 

			if (prereqs != null) {
				for(int i = 0; i < prereqs.length; i++)
				{
					stackToOutput.push(prereqs[i]);
					stack.push(prereqs[i]);
				}
			}
		}
		while(stackToOutput.length() > 0)
		{
			toReturn += stackToOutput.pop();
			toReturn += " ";
		}
		return toReturn;
	}

	public String [] getPrerequisite(String courseCode)
	{
		this.clear();
		return this.getPrerequisiteHelp(courseCode);
	}
	
	public String [] getPrerequisiteHelp(String courseCode)
	{
		int prCount = 0;
		int indexOfInput = -1;
		String[] prereqs = new String [this.n() - 1];

		for(int i = 0; i < this.n(); i++)
		{
			if (courses[i] != null) {
				if (courses[i].equals(courseCode))
					indexOfInput = i;
			}
		}
		if(indexOfInput == -1)
			return null;

		for(int k = 0; k < this.n(); k++)
		{
			if(matrix[k][indexOfInput] != 0)
			{
				this.setMark(k, VISITED);
				prereqs[prCount] = courses[k];
				prCount++;
			}
		}

		String [] toReturn = new String[prCount];
		for(int j = 0; j < prCount; j++)
		{
			toReturn[j] = prereqs[j];
		}
		
		return toReturn;
		
	}

}
