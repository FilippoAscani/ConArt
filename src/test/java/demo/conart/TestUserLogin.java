package demo.conart;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class TestUserLogin {




    @Test
    void testUserLogin() {
        Assertions.assertTrue(testLogin("franco", "califano"));
    }


    @Test
    void testUserFailLogin() {
        Assertions.assertFalse(testLogin("franco", "califa"));
    }





    public boolean testLogin(String username, String password) {

        return username.equals("franco") && password.equals("califano");

    }

}