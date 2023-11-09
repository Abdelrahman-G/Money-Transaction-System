package instapay.user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UsersDatabase {
    /*
    Hashmap for users' username and password
    this hashmap will be filled from  users_authentications.txt file
    */
    private HashMap<String, ArrayList<String>> users_list= new HashMap<>();
    // file that contains users data
    private final File users_file = new File("users_authentications.txt");

    /* Description:
     *   Add a new user to the users file after doing all verifications.
     *   Uses fileWriter to write the new user to users file
     */
    public void addUser(User user) throws IOException {
        // file writer is created with the users text file in append mode
        FileWriter writer = new FileWriter(users_file,true);
        // add username and password in a new line to users file seperated with space
        writer.write(user.getUsername()+" "+user.getPassword()+" "+user.getInstapayAcc()+" "+user.getPhoneNumber()+"\n");
        writer.close();
    }

    /* Description:
     *   find if this username already exists and return true if it does.
     *   used when user in creating a new username.
    */
    public boolean searchUsername(String username){
        return users_list.containsKey(username);
    }

    /* Description:
     *   check if this user already exists.
     *   used when user is trying to sign in.
     *   returns true if the username exists with the right password.
     */
    public boolean verifyUser(String username, String password){
        return (users_list.containsKey(username))&&(users_list.get(username).get(0).equals(password));
    }



}
