public enum Suit {
	HEART(0), DIAMOND(1), SPADE(2), CLUB(3), JOKER(4);
	private int value;

	private Suit(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}

	@Override
	public String toString(){
		//only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase() + "s";
	}
}
