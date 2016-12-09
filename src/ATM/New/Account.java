package ATM.New;

public class Account {

	private int accno;
	private int pin;
	private int bal;
	
	public Account(int a,int p,int b) {
		// TODO Auto-generated constructor stub
		accno=a;
		pin=p;
		bal=b;
	}

	public Account(int a,int p) {
		// TODO Auto-generated constructor stub
		accno=a;
		pin=p;
	}

	public Account(int a) {
		// TODO Auto-generated constructor stub
		accno=a;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accno != other.accno)
			return false;
		return true;
	}

	
	
}
