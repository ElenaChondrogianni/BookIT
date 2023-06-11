package BookIT;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
    private List<User> userList;

    public UserBean() {
        // Initialize the userList with sample data
        userList = new ArrayList<>();
        userList.add(new User(1, "Vasilis Vasilopoulos", "killbill@gmail.com"));
        userList.add(new User(2, "Cristos Cristou", "Cristou@gmail.com"));
        userList.add(new User(3, "Mitsos Mitsou", "Mistos2ever@gmail.com"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void viewUser(User user) {
        // Implement the logic to navigate to the page with the specific user's information
        // You can use navigation rules, redirect to a new page, or update the current page accordingly
        // Example: Redirect to a user information page with the user's ID
        String userId = String.valueOf(user.getUserId());
        // Implement the logic to navigate to the user information page using the user's ID
        // Example: redirect("user-information.xhtml?userId=" + userId);
    }

    public void deleteUser(User user) {
        // Implement the logic to delete the user from the program
        userList.remove(user);
        // You may need to update your data source or perform any additional cleanup as required
    }
}
