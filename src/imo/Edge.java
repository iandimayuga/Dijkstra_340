package imo;

public class Edge
{
	private int m_Weight;
	
	public Edge( int weight)
	{
		m_Weight = weight;
	}

	/**
	 * @return The weight of this Edge
	 */
	public Integer getWeight()
	{
		return m_Weight;
	}

	/**
	 * @param weight The weight to set this Edge to
	 */
	public void setWeight( Integer weight)
	{
		m_Weight = weight;
	}
	
	/**
	 * Edges are only equal if they are literally the same object.
	 * This is important for the highlight collections.
	 */
	@Override
	public boolean equals( Object o)
	{
		return this == o;
	}
	
	/**
	 * Returns what will be displayed as the label for the Edge.
	 */
	@Override
	public String toString()
	{
		return this.getWeight().toString();
	}
}
