/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package vending;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    App app = new App();

    @Test
    void testReadCard() {
        boolean check = false;
        app.readCard();
        CreditCard firstCard = app.cardList.get(0);
        if (firstCard.name.equals("Charles") &&
                firstCard.number.equals("40691") &&
                app.cardList.size() == 50) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testReadSnacks() {
        boolean check = false;
        app.readSnacks();
        Snack firstSnack = app.snackList.get(0);
        if (firstSnack.getCategory().equals("Drinks") &&
                firstSnack.getName().equals("Mineral Water") &&
                firstSnack.getAmount() == 7 &&
                firstSnack.getPrice().equals(2.0) &&
                firstSnack.getCode() == 1001 &&
                firstSnack.getSold() == 0 &&
                app.snackList.size() == 16) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testReadUser() {
        boolean check = false;
        app.readUser();
        User firstUser = app.userList.get(0);
        if (firstUser.getName().equals("user") &&
                firstUser.getPassword().equals("123") &&
                firstUser.getType().equals("customer") &&
                firstUser.holder.equals("Sergio") &&
                firstUser.haveCard == true &&
                firstUser.login == false &&
                app.userList.size() == 4) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testReadTransaction1() {
        boolean check = false;
        app.readTransaction();
        if (app.transactionList.size() == 0) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testReadTransaction2() {
        boolean check = false;
        Date dateTime = new java.util.Date(System.currentTimeMillis());
        String time = new SimpleDateFormat("HH:mm:ss").format(dateTime);
        String date = new SimpleDateFormat("yyyy/MM/dd").format(dateTime);
        Transaction t = new Transaction("user1", date, time);
        app.transactionList.add(t);
        app.addTransaction();
        app.readTransaction();
        Transaction firstT = app.transactionList.get(0);
        if (firstT.name.equals("user1") &&
                firstT.time.equals(time) &&
                firstT.date.equals(date) &&
                app.transactionList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.transactionList.clear();
        app.addTransaction();
    }

    @Test
    void testReadCash() {
        boolean check = false;
        app.readCash();
        if (app.cash.getD100() == 5 &&
                app.cash.getD50() == 5 &&
                app.cash.getD20() == 5 &&
                app.cash.getD10() == 5 &&
                app.cash.getD5() == 5 &&
                app.cash.getD2() == 5 &&
                app.cash.getD1() == 5 &&
                app.cash.getC50() == 5 &&
                app.cash.getC20() == 5 &&
                app.cash.getC10() == 5 &&
                app.cash.getC5() == 5 &&
                app.cashList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testReadBuy1() {
        boolean check = false;
        app.readBuy();
        if (app.buyList.size() == 0) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testReadBuy2() {
        boolean check = false;
        currentBuy c = new currentBuy("Sprite", 2);
        app.buyList.add(c);
        app.addBuy();
        app.readBuy();
        currentBuy firstC = app.buyList.get(0);
        if (firstC.name.equals("Sprite") &&
                firstC.amount == 2 &&
                app.buyList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.buyList.clear();
        app.addBuy();
    }

    @Test
    void testAddUser() {
        boolean check = false;
        app.readUser();
        User newU = new User("newUser", "password", "hh");
        app.userList.add(newU);
        app.addUser();
        app.readUser();
        User testU = app.userList.get(app.userList.size() - 1);
        if (testU.getName().equals("newUser") &&
                testU.getPassword().equals("password") &&
                testU.getType().equals("hh")) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.userList.remove(app.userList.size() - 1);
        app.addUser();
    }

    @Test
    void testAddSnack() {
        boolean check = false;
        app.readSnacks();
        Snack newS = new Snack("Drink", "a", 9, 8.0, 1, 0);
        app.snackList.add(newS);
        app.addSnack();
        app.readSnacks();
        Snack testS = app.snackList.get(app.snackList.size() - 1);
        if (testS.getName().equals("a") &&
                testS.getCategory().equals("Drink") &&
                testS.getAmount() == 9 &&
                testS.getPrice().equals(8.0) &&
                testS.getCode() == 1 &&
                testS.sold == 0) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.snackList.remove(app.snackList.size() - 1);
        app.addSnack();
    }

    @Test
    void testAddTransaction() {
        boolean check = false;
        Transaction newT = new Transaction("test.", "test?", "test!");
        app.transactionList.add(newT);
        app.addTransaction();
        app.readTransaction();
        Transaction testT = app.transactionList.get(0);
        if (testT.name.equals("test.") &&
                testT.date.equals("test?") &&
                testT.time.equals("test!") &&
                app.transactionList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.transactionList.clear();
        app.addTransaction();
    }

    @Test
    void testAddCash() {
        boolean check = false;
        app.readCash();
        Cash newC = new Cash(5,5,5,5,5,5,5,50,50,0,0);
        app.cashList.add(newC);
        app.addCash();
        app.readCash();
        Cash testC = app.cashList.get(1);
        if (testC.getC50() == 50 &&
                testC.getC20() == 50 &&
                testC.getC10() == 0 &&
                testC.getC5() == 0 &&
                app.cashList.size() == 2) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.cashList.remove(app.cashList.size() - 1);
        app.addCash();
    }

    @Test
    void testAddBuy() {
        boolean check = false;
        currentBuy newB = new currentBuy("test.", 2);
        app.buyList.add(newB);
        app.addBuy();
        app.readBuy();
        currentBuy testB = app.buyList.get(0);
        if (testB.name.equals("test.") &&
                testB.amount == 2 &&
                app.buyList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.buyList.clear();
        app.addBuy();
    }

    @Test
    void testDisplaySnacksByCategory1() {
        boolean check = false;
        app.readSnacks();
        List<String> snackNames = app.displaySnacksByCategory("Drinks");
        if (snackNames.get(0).equals("Mineral Water") &&
                snackNames.get(1).equals("Sprite") &&
                snackNames.get(2).equals("Coca cola") &&
                snackNames.get(3).equals("Pepsi") &&
                snackNames.get(4).equals("Juice") &&
                snackNames.size() == 5) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksByCategory2() {
        boolean check = false;
        app.readSnacks();
        List<String> snackNames = app.displaySnacksByCategory("Chocolates");
        if (snackNames.get(0).equals("Mars") &&
                snackNames.get(1).equals("M&M") &&
                snackNames.get(2).equals("Bounty") &&
                snackNames.get(3).equals("Snickers") &&
                snackNames.size() == 4) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksByCategory3() {
        boolean check = false;
        app.readSnacks();
        List<String> snackNames = app.displaySnacksByCategory("Chips");
        if (snackNames.get(0).equals("Smiths") &&
                snackNames.get(1).equals("Pringles") &&
                snackNames.get(2).equals("Kettle") &&
                snackNames.get(3).equals("Thins") &&
                snackNames.size() == 4) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksByCategory4() {
        boolean check = false;
        app.readSnacks();
        List<String> snackNames = app.displaySnacksByCategory("Candies");
        if (snackNames.get(0).equals("Mentos") &&
                snackNames.get(1).equals("Sour Patch") &&
                snackNames.get(2).equals("Skittles") &&
                snackNames.size() == 3) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksClass1() {
        boolean check = false;
        app.readSnacks();
        List<Snack> snackList = app.displaySnacksClass("Drinks");
        if (snackList.get(0).getName().equals("Mineral Water") &&
                snackList.get(1).getName().equals("Sprite") &&
                snackList.get(2).getName().equals("Coca cola") &&
                snackList.get(3).getName().equals("Pepsi") &&
                snackList.get(4).getName().equals("Juice") &&
                snackList.size() == 5) {

            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksClass2() {
        boolean check = false;
        app.readSnacks();
        List<Snack> snackList = app.displaySnacksClass("Chocolates");
        if (snackList.get(0).getName().equals("Mars") &&
                snackList.get(1).getName().equals("M&M") &&
                snackList.get(2).getName().equals("Bounty") &&
                snackList.get(3).getName().equals("Snickers") &&
                snackList.size() == 4) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksClass3() {
        boolean check = false;
        app.readSnacks();
        List<Snack> snackList = app.displaySnacksClass("Chips");
        if (snackList.get(0).getName().equals("Smiths") &&
                snackList.get(1).getName().equals("Pringles") &&
                snackList.get(2).getName().equals("Kettle") &&
                snackList.get(3).getName().equals("Thins") &&
                snackList.size() == 4) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplaySnacksClass4() {
        boolean check = false;
        app.readSnacks();
        List<Snack> snackList = app.displaySnacksClass("Candies");
        if (snackList.get(0).getName().equals("Mentos") &&
                snackList.get(1).getName().equals("Sour Patch") &&
                snackList.get(2).getName().equals("Skittles") &&
                snackList.size() == 3) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplayBoughtItems1() {
        boolean check = false;
        List<String> bought = app.displayBoughtItems();
        if (bought.size() == 0) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplayBoughtItems2() {
        boolean check = false;
        app.readUser();
        Transaction t1 = new Transaction("user", "test1", "test1");
        t1.itemList = {"item1", "2", "item2", "1"};
        Transaction t2 = new Transaction("user", "test2", "test2");
        t2.itemList = {"item1", "2", "item2", "1"};
        Transaction t3 = new Transaction("user", "test3", "test4");
        t3.itemList = {"item1", "2", "item2", "1"};
        app.transactionList.add(t1);
        app.transactionList.add(t2);
        app.transactionList.add(t3);
        List<String> bought = app.displayBoughtItems();
        if (bought.size() == 5 &&
                bought.get(0).equals("item1") &&
                bought.get(1).equals("item2") &&
                bought.get(2).equals("item1") &&
                bought.get(3).equals("item2") &&
                bought.get(4).equals("item1")) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testDisplayBoughtItems3() {
        boolean check = false;
        app.readUser();
        Transaction t1 = new Transaction("user", "test1", "test1");
        t1.itemList = {"item1", "2", "item2", "1"};
        app.transactionList.add(t1);
        List<String> bought = app.displayBoughtItems();
        if (bought.size() == 2 &&
                bought.get(0).equals("item1") &&
                bought.get(1).equals("item2") &&) {
            check = true;
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testStartTransaction() {
        boolean check = false;
        app.startTransaction("test1");
        app.transactionList.clear();
        app.readTransaction();
        Transaction testT = app.transactionList.get(0);
        if (testT.name.equals("test1") &&
                app.transactionList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.transactionList.clear();
        app.addTransaction();
    }

    @Test
    void testAddPurchaseItems() {
        boolean check = false;
        app.readSnacks();
        app.addPurchaseItems("Coca cola", 2);
        app.readBuy();
        currentBuy testC = app.buyList.get(0);
        if (testC.name.equals("Coca cola") &&
                testC.amount == 2 &&
                testC.price.equals(5.0) &&
                app.buyList.size() == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.buyList.clear();
        app.addBuy();
    }

//@Test
//void testAddCustomer(){
//    boolean check = false;
//    Integer checkValue = app.addUserOwner("amazing","123","customer");
//    if (checkValue == 0){
//        check = true;
//    }
//    assertTrue(check, "pass!");
//}
//    @Test
//    void testAddOwner(){
//        boolean check = false;
//        Integer checkValue = app.addUserOwner("amazing","123","owner");
//        if (checkValue == 1){
//            check = true;
//        }
//        assertTrue(check, "pass!");
//    }

//    @Test
//    void testAddCashier(){
//        boolean check = false;
//        Integer checkValue = app.addUserOwner("amazing","123","cashier");
//        if (checkValue == 1){
//            check = true;
//        }
//        assertTrue(check, "pass!");
//    }


    @Test
    void testCheckLogin1() {
        boolean check = false;
        app.readUser();
        Integer num = app.checkLogin("user","123");
        if (num == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.Logout();
    }

    @Test
    void testCheckLogin2() {
        boolean check = false;
        app.readUser();
        Integer num = app.checkLogin("seller","123");
        if (num == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.Logout();
    }
    @Test
    void testCheckLogin3() {
        boolean check = false;
        app.readUser();
        Integer num = app.checkLogin("owner","123");
        if (num == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.Logout();
    }
    @Test
    void testCheckLogin4() {
        boolean check = false;
        app.readUser();
        Integer num = app.checkLogin("cashier","123");
        if (num == 1) {
            check = true;
        }
        assertTrue(check, "pass!");
        app.Logout();
    }

    @Test
    void testFindLogin() {
        boolean check = false;
        app.readUser();
        app.findLogin();
        if (app.currentUser == "Anonymous") {
            check = true;
        }
        assertTrue(check, "pass!");
    }
    @Test
    void testLogOut() {
        boolean check = false;
        app.readUser();
        app.checkLogin("user", "123");
        app.Logout();
        User u = app.userList.get(0);
        if (u.login == false) {
            check = true;
        }
        assertTrue(check, "pass!");
    }
    @Test
    void testCheckCreate() {
        boolean check = false;

        app.readUser();
        app.checkLogin("user", "123");
        app.Logout();
        User u = app.userList.get(0);
        if (u.login == false) {
            check = true;
        }
        assertTrue(check, "pass!");
    }
    @Test
    void testStartTransaction() {
    }
    @Test
    void testAddPurchaseItems() {
    }
    @Test
    void testCancelPurchase() {
    }

    @Test
    void testCountChange() {
    }

    @Test
    void testCheckCard() {
        boolean check = false;
        app.readCard();
        for (CreditCard u: app.cardList) {
            Integer num = app.checkCard("Sergio","42689");
            if (num == 1) {
                check = true;
            }
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testFindHolder() {
        boolean check = false;
        app.readUser();
        app.checkLogin("user", "123");
        String test = app.findHolder();
        if (test != null){
            if (test.equals("Sergio") &&
                    app.currentUser.equals("user")) {
                check = true;
            }
        }
        assertTrue(check, "pass!");
        app.Logout();
    }

    @Test
    void testFindNumber1() {
        boolean check = false;
        app.readCard();
        String test = app.findNumber("Sergio");
        if (test != null) {
            if (test.equals("42689")) {
                check = true;
            }
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testFindNumber2() {
        boolean check = false;
        app.readCard();
        String test = app.findNumber("Kasey");
        if (test != null) {
            if (test.equals("60146")) {
                check = true;
            }
        }
        assertTrue(check, "pass!");
    }

    @Test
    void testCompletePurchase() {
    }
    @Test
    void testSummary() {
    }

    @Test
    void testRemoveUser() {
    }


    @Test
    void testAddOwner(){
        boolean check = false;
        app.readUser();
        Integer checkValue = app.addUserOwner("amazing","123","owner");
        if (checkValue == 1){
            check = true;
        }
        assertTrue(check, "pass!");
        app.userList.remove(app.userList.size() - 1);
        app.addUser();
    }
    @Test
    void testAddCashier(){
        boolean check = false;
        app.readUser();
        Integer checkValue = app.addUserOwner("amazing","123","cashier");
        if (checkValue == 1){
            check = true;
        }
        assertTrue(check, "pass!");
        app.userList.remove(app.userList.size() - 1);
        app.addUser();
    }
    @Test
    void testAddSameUser(){
        boolean check = false;
        app.readUser();
        Integer checkValue = app.addUserOwner("user","123","cashier");
        if (checkValue == -1){
            check = true;
        }
        assertTrue(check, "pass!");
        app.addUser();
    }
>>>>>>> 1bd3c2b1da5beaecd4e3d17e551f70e117a35a90
}
