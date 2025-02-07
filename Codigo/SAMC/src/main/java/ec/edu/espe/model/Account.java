package ec.edu.espe.model;

public class Account {
    private String name;
    private String lastName;
    private String userName;
    private String password;
    
    public Account(String name, String lastName, String username, String password){
        this.name = name;
        this.lastName = lastName;
        this.userName = username;
        this.password = password;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userName
     */
    public String getUsername() {
        return userName;
    }

    /**
     * @param username the userName to set
     */
    public void setUsername(String username) {
        this.userName = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
