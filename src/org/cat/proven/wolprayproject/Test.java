package org.cat.proven.wolprayproject;


import java.util.List;
import org.cat.proven.wolprayproject.models.pojo.Club;
import org.cat.proven.wolprayproject.models.pojo.Product;
import org.cat.proven.wolprayproject.models.pojo.User;
import org.cat.proven.wolprayproject.models.persist.ClubDao;
import org.cat.proven.wolprayproject.models.persist.ProductDao;
import org.cat.proven.wolprayproject.models.persist.UserDao;

/**
 *
 * @author Lewis
 */
public class Test {

    //Messege test ok    
    private final String msgPass;
    //Messege test fail
    private final String msgFail;

    //daos
    private UserDao userDao;
    private ClubDao clubDao;
    private ProductDao productDao;

    public Test() {
        msgPass = "ok";
        msgFail = "fail";
        initComponents();
    }

    public UserDao getUserDao() {
        return userDao;
    }
    
    
    
    private void initComponents() {
        userDao = new UserDao();
        clubDao = new ClubDao();
        productDao = new ProductDao();
    }

    /**
     * promtpt messege to user
     *
     * @param msg to shown
     */
    public void alert(String msg) {
        System.out.println(msg);
    }

    /**
     * assert equality if 2 objects
     *
     * @param result
     * @param expected
     */
    public void assertEquals(Object result, Object expected) {
        if (result == null) {
            alert(msgFail);
        } else {
            if (result.equals(expected)) {
                alert(msgPass);
            } else {
                alert(msgFail);
            }
        }
    }

    public void assertEqualsCount(int result, int expected) {
        if (result == expected) {
            alert(msgPass);
        } else {
            alert(msgFail);
        }
    }

    /**
     * Check that result is null
     *
     * @param result
     */
    public void assertNUll(Object result) {
        if (result == null) {
            alert(msgPass);
        } else {
            alert(msgFail);
        }
    }
    
    
    /**
     *Check that result is true 
     * @param result 
     * @param expected 
     */
    public void assertTrue(boolean result, boolean expected){
        if(result == expected){
            alert(msgPass);
        }else{
            alert(msgFail);
        }
    }
    
    
    private void testInsertNewUser(User user, int expected){
        System.out.println("");
        System.out.println("Testing insert new user...");
        
        int result = userDao.addUser(user);
        assertEqualsCount(result, expected);
    }
    
    private void testInsertNewUserExistWithMail(User user, int expected){
        System.out.println("");
        System.out.println("Testing insert new user exist with mail...");
        
        int result = userDao.addUser(user);
        assertEqualsCount(result, expected);
    }
    
    
    private void testInsertNewUserExistWithUsername(User user, int expected){
        System.out.println("");
        System.out.println("Testing insert new user exist with Username...");
        
        int result = userDao.addUser(user);
        assertEqualsCount(result, expected);
    }
    
    
    private void testInsertNewUserExistWithPhone(User user, int expected){
        System.out.println("");
        System.out.println("Testing insert new user exist with Phone...");
        
        int result = userDao.addUser(user);
        assertEqualsCount(result, expected);
    }
    
    
    private void testModifyUser(User user, int expected){
        System.out.println("");
        System.out.println("Testing modify user...");
        
        int result = userDao.modifyUser(user);
        assertEqualsCount(result, expected);
    }
    
    private void testModifyUserExistWithMail(User user, int expected){
        System.out.println("");
        System.out.println("Testing modify user exist with mail...");
        
        int result = userDao.modifyUser(user);
        assertEqualsCount(result, expected);
    }
    
    
    private void testModifyUserExistWithUsername(User user, int expected){
        System.out.println("");
        System.out.println("Testing modify user exist with Username...");
        
        int result = userDao.modifyUser(user);
        assertEqualsCount(result, expected);
    }
    
    
    private void testModifyUserExistWithPhone(User user, int expected){
        System.out.println("");
        System.out.println("Testing modify user exist with Phone...");
        
        int result = userDao.modifyUser(user);
        assertEqualsCount(result, expected);
    }
    
    private void testRemoveUser(User user, int expected){
        System.out.println("");
        System.out.println("Testing remove user...");
        
        int result = userDao.removeUser(user);
        assertEqualsCount(result, expected);
    }
    
    private void testRemoveUserIfNotExist(User user, int expected){
        System.out.println("");
        System.out.println("Testing remove user if not exist...");
        
        int result = userDao.removeUser(user);
        assertEqualsCount(result, expected);
    }
    
    
    private void testFindUserByUsername(String username){
        System.out.println("");
        System.out.println("Testing find by username...");
        
        User result = userDao.findUserByUserName(username);
        String nameResult;        
        if(result == null){
            nameResult = "";
        }else{
            nameResult = result.getUserName();
        }
        
        assertEquals(nameResult, username);    
    }
    
    private void testFindUserByUsernameFail(String username){
        System.out.println("");
        System.out.println("Testing find user by username fail...");
        
        User result = userDao.findUserByUserName(username);
        
        assertNUll(result);    
    }
    
    
    private void testFindUserByPhone(String phone){
        System.out.println("");
        System.out.println("Testing find by phone...");
        
        User result = userDao.findUserByPhone(phone);
        String rsult;        
        if(result == null){
            rsult = "";
        }else{
            rsult = result.getPhone();
        }
        
        assertEquals(rsult, phone);    
    }
    
    private void testFindUserByPhoneFail(String phone){
        System.out.println("");
        System.out.println("Testing find user by phone fail...");
        
        User result = userDao.findUserByUserName(phone);
        
        assertNUll(result);    
    }
   
    
    private void testFindUserById(User user){
        System.out.println("");
        System.out.println("Testing find user by id...");
        
        User result = userDao.findUserById(user.getId());
        
        assertEquals(result, user);    
    }
    
    private void testFindUserByIdFail(User user){
        System.out.println("");
        System.out.println("Testing find user by id fail...");
        
        User result = userDao.findUserById(user.getId());
        
        assertNUll(result);    
    }
    
    
    public void testFindAllUsers(int expected){
        System.out.println("");
        System.out.println("Testing find all users...");

        List<User> result = userDao.findAllUsers();
        int resultSize;
        if(result == null){
            resultSize = -1;
        }else{
            resultSize = result.size();
        }
        
        assertEqualsCount(resultSize, expected); 
        
    }
    
    
    
    public void testFindAllClubs(int expected){
        System.out.println("");
        System.out.println("Testing find all clubs...");

        List<Club> result = clubDao.findAllClubs();
        for(Club club : result){
            System.out.println(club.getName());
        }
        int resultSize;
        if(result == null){
            resultSize = -1;
        }else{
            resultSize = result.size();
        }
        
        assertEqualsCount(resultSize, expected); 
        
    }
    
    public void testFindAllProductInClub(int expected){
        System.out.println("");
        System.out.println("Testing find all products in a club...");
        Club club = clubDao.findClubById(5);
        List<Product> result = productDao.findAllProductsInAClub(club);
        
        int resultSize;
        if(result == null){
            resultSize = -1;
        }else{
            resultSize = result.size();
        }
        
        assertEqualsCount(resultSize, expected); 
        
    }
    
    
    
    
    public void testFindUsersByRole(String role,int expected){
        System.out.println("");
        System.out.println("Testing find users by role...");

        List<User> result = userDao.findUserByRole(role);
        int resultSize;
        if(result == null){
            resultSize = -1;
        }else{
            resultSize = result.size();
        }
        
        assertEqualsCount(resultSize, expected); 
        
    }
    
    
    public void testFindUsersByRoleFail(String role,int expected){
        System.out.println("");
        System.out.println("Testing find users by role fail...");

        List<User> result = userDao.findUserByRole(role);
        int resultSize;
        if(result == null){
            resultSize = -1;
        }else{
            resultSize = result.size();
        }
        
        assertEqualsCount(resultSize, expected); 
        
    }

    public static void main(String[] args) {
        Test test = new Test();
        //Test find all users
        test.testFindAllUsers(20);//enter the number of expected users
        
        //Test find user by user name
        test.testFindUserByUsername("client1");
        
        //Test find user bt username fail
        test.testFindUserByUsernameFail("leinito");
        
        //Test find user by id
        test.testFindUserById(new User(1));
        
        //Test find user by id fail
        test.testFindUserByIdFail(new User(0));
        
        //Test find user by phone
        test.testFindUserByPhone("93111111");
        
        //Test find user by phone fail
        test.testFindUserByPhoneFail("231223");
        
        //Test find user by role
        test.testFindUsersByRole("manager", 5);
        
        //Test find by rolle fil
        test.testFindUsersByRoleFail("tutu", 0);
        
        //Test insert new User
        //TODO
        
        //Test inert new user exist with username
//        test.testInsertNewUserExistWithUsername(new User("manager5", 
//                "Lewismendez@gmail.com", "sd", "pinwe", 17, "08905", 
//                "675927020dsd", "Barcelona", "1990-8-19", "admin"), -2);
        
//        //Test insert new user exist with mail
//        test.testInsertNewUserExistWithMail(new User("Ledfdfdfwis23", 
//                "admin2@admin.com", "sd", "pinwe", 17, "08905", 
//                "675927020dsd", "Barcelona", "1990-8-19", "admin"), -1);
//        
//        //Test insert new user exist with phone
//        test.testInsertNewUserExistWithPhone(new User("lala", 
//                "Lewismerththtgndezerty@gmail.com", "sd", "pinwe", 17, "08905", 
//                "93777777", "Barcelona", "1990-8-19", "admin"), 0);
        
        User userTester = test.userDao.findUserById(10);
        
        //Test modify user with username exist
        userTester.setUserName("client7");
        userTester.setPhone("1235");
        userTester.setMail("another@mail.com");
        test.testModifyUserExistWithUsername(userTester, -2);
        
        //Test modify user with mail exist
        userTester.setUserName("Another username2");
        userTester.setPhone("1235");
        userTester.setMail("admin5@admin.com");
        test.testModifyUserExistWithMail(userTester, -1);
        
        //Test modify user with phone exist
        userTester.setUserName("Another username22");
        userTester.setPhone("93111111");
        userTester.setMail("anotheadmin5@admin.com");
        test.testModifyUserExistWithPhone(userTester, 0);
        
        //Test modify user
        userTester.setUserName("Another username22"+test.getUserDao().findAllUsers().size()+1);
        userTester.setPhone("93111111"+test.getUserDao().findAllUsers().size()+1);
        userTester.setMail("anotheadmin5@admin.com"+test.getUserDao().findAllUsers().size()+1);
        test.testModifyUser(userTester, 1);
        
        //Test remove user if not exist
//        userTester = test.userDao.findUserById(test.getUserDao().findAllUsers().size()-1);
//        test.testRemoveUser(userTester, 1);
        
        
        //Test remove user
//        userTester = test.userDao.findUserById(test.getUserDao().findAllUsers().size()-1);
//        userTester.setId(46);
//        test.testRemoveUserIfNotExist(userTester, 0);
        
        //Test find all clubs
        test.testFindAllClubs(5);
        test.testFindAllProductInClub(22);//Testing with clb id 5
        
    }
}
