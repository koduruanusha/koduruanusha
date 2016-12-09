package ATM.New;

import org.omg.CORBA.portable.UnknownException;

public interface SI {

	String loginUser(Account user);

	String withdraw(Account user, int amount);

	String credit(Account user, int amount);

	String changePin(Account user, int oldpin, int newpin);

	int getBal(Account user) throws IllegalArgumentException;

}
