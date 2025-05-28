import org.example.MjcValidCheck;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckLibraryTest {
    /*@Test
    public void testIsValidPhoneNumber() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-39a2-0203")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);
    }

    @Test
    public void testIsValidZipNumber() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidZipNumber("01234")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("12345")).isEqualTo(true);
        assertThat(mvc.isValidZipNumber("99999")).isEqualTo(true);
    }

    @Test
    public void testIsValidEmail() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidEmail(null)).isEqualTo(false);
        assertThat(mvc.isValidEmail("")).isEqualTo(false);
        assertThat(mvc.isValidEmail("test@domain")).isEqualTo(false);
        assertThat(mvc.isValidEmail("user@domain.com")).isEqualTo(true);
        assertThat(mvc.isValidEmail("a.b@domain.net")).isEqualTo(true);
    }*/

    @Test
    void testPhone() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidPhoneNumber("010-1234-5678")).isEqualTo(true);
        assertThat(mvc.isValidPhoneNumber("010-abcd-1234")).isEqualTo(false);
    }

    @Test
    void testZip() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidZipNumber("12345")).isEqualTo(true);
        assertThat(mvc.isValidZipNumber("01234")).isEqualTo(false);
    }

    @Test
    void testEmail() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidEmail("user@example.com")).isEqualTo(true);
        assertThat(mvc.isValidEmail("invalid@email")).isEqualTo(false);
    }
}