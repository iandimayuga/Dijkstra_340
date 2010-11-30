package imo;

public class Vertex
{
	private String m_Name;
	private boolean m_Final;
	private int distance;
	
	public Vertex( String name)
	{
		m_Name = name;
		m_Final = false;
		distance = Constants.infinity;
	}
	
	/**
	 * @return The identifier of the Vertex.
	 */
	public String getName()
	{
		return m_Name;
	}
	
	/**
	 * @param name The identifier of the Vertex.
	 */
	public void setName( String name)
	{
		m_Name = name;
	}
	
	/**
	 * @return Whether this Vertex has been finalized.
	 */
	public boolean isFinal()
	{
		return m_Final;
	}
	
	/**
	 * @param f "true" to finalize this Vertex.
	 */
	public void setFinal( boolean f)
	{
		m_Final = f;
	}
	
	/**
	 * Vertices are only equal if they are literally the same object.
	 * This is important for the highlight collections.
	 */
	@Override
	public boolean equals( Object o)
	{
		return this == o;
	}
	
	/**
	 * Returns what will be displayed as the label for the Vertex.
	 */
	@Override
	public String toString()
	{
		return this.getName() + "(" + (this.getDistance() == Constants.infinity ? "∞" : this.getDistance()) + ")";
	}
	
	public void setDistance(int i){
		distance = i;
	}
	
	public int getDistance(){
		return distance;
	}
}
