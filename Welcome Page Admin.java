//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        // Define the valid email and password combinations
        String[] validEmails = { "User1", "User2", "User3" };
        String[] validPasswords = { "User1", "User2", "User3" };

        // Check if the entered email and password are valid
        boolean isValid = false;
        for (int i = 0; i < validEmails.length; i++) {
            if (email.equals(validEmails[i]) && password.equals(validPasswords[i])) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            return "first-page"; // Redirect to the "First page"
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Credentials", "Invalid email or password"));
            return ""; // Stay on the same page (or handle invalid login)
        }
    }
}
