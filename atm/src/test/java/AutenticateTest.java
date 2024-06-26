import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.Account;
import com.example.BankDatabase;

public class AutenticateTest {

    @Test
    public void testValidatePIN() {
        Account account = new Account(1234, 5678, 1000.0, 2000.0);
        // Verificar que el PIN correcto sea válido
        assertTrue(account.validatePIN(5678));
        // Verificar que el PIN incorrecto no sea válido
        assertFalse(account.validatePIN(1111));
    }

    @Test
    public void testAuthenticateUser() {
        BankDatabase bankDatabase = new BankDatabase();

        // Verificar la autenticación con el número de cuenta y el PIN correctos
        assertTrue(bankDatabase.authenticateUser(12345, 54321));

        // Verificar la autenticación con el número de cuenta correcto y el PIN
        // incorrecto
        assertFalse(bankDatabase.authenticateUser(12345, 1111));

        // Verificar la autenticación con el número de cuenta incorrecto
        assertFalse(bankDatabase.authenticateUser(11111, 54321));
    }

}
