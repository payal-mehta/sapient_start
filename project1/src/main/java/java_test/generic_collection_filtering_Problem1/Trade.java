package java_test.generic_collection_filtering_Problem1;

public class Trade {
	public Trade(int id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	int id;
	int amount;
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
