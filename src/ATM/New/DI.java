package ATM.New;

public interface DI {

	Account findAccount(Account user) throws IllegalArgumentException;

	String withdraw(Account user, int amount) throws IllegalArgumentException;

	String credit(Account user, int amount)throws IllegalArgumentException;

	String changePin(Account user, int oldpin, int newpin)throws IllegalArgumentException;

	int getBal(Account user) throws IllegalArgumentException;

}
