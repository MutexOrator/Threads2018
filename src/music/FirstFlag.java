package music;

public enum FirstFlag {
	patti,
	bruce,
	choir,
	guitarSolo;
	 private static FirstFlag[] vals = values();
	    public FirstFlag next()
	    {
	        return vals[(this.ordinal()+1) % vals.length];
	    }
}
