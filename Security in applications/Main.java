import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GUI {
  // JDBC connection variables
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/Data?useSSL=false";
    static final String DB_USER = "Admin";
    static final String DB_PASSWORD = "H45H";

    public static void main(String[] args) {
        Connection con = null;

        try {
            System.out.println("Connecting to database... " + JDBC_URL);
            con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection is successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection if it was opened
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   }
//MAKING THE INTERACTIVE GUI AND SECURITY ALGORITHMN
//simple gui class
import java.awt.*;
import java.awt.event.*;

 import public class SimpleGUI() {  
        // Create the frame
        JFrame frame = new JFrame("Simple GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a panel
        JPanel panel = new JPanel();

        // Add a text field
        JTextField textField = new JTextField(20);
        frame.add(textField);

        // Add buttons
        JButton Sign_up_button = new JButton("Sign-up");
        frame.add(Sign_up_button);
        frame.getContentPane().add(button, BorderLayout.CENTER);
	    
        
        JButton Login_button = new JButton("Login");
	      frame.add(Login_button);
	      frame.getContentPane().add(button, BorderLayout.CENTER);
	    
        // Add an action listener to the button
        button.addActionListener(e -> {
            String inputText = textField.getText();
        });

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }


public class SignUpForm extends JFrame implements ActionListener {

    // Components
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public SignUpForm() {
        setTitle("Sign-Up Form");
        setSize(350, 250);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10)); // rows, cols, hgap, vgap

        // Labels and Fields
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Empty label for spacing
        add(new JLabel(""));

        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);
        add(signUpButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Basic validation
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Sign-Up Successful!\nName: " + name + "\nEmail: " + email,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            
            
  //CODE FOR SIGNING UP
            import javax.swing.*;
            import java.awt.*;
            import java.awt.event.*;
            import java.sql.*;

            public class SignUpToDB extends JFrame implements ActionListener {

                private JTextField nameField, emailField;
                private JPasswordField passwordField;
                private JButton signUpButton;

              
                public SignUpToDB() {
                    setTitle("User Registration");
                    setSize(350, 250);
                    setLocationRelativeTo(null);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setLayout(new GridLayout(4, 2, 10, 10));

                    add(new JLabel("Name:"));
                    nameField = new JTextField();
                    add(nameField);

                    add(new JLabel("Email:"));
                    emailField = new JTextField();
                    add(emailField);

                    add(new JLabel("Password:"));
                    passwordField = new JPasswordField();
                    add(passwordField);

                    add(new JLabel(""));
                    signUpButton = new JButton("Sign Up");
                    signUpButton.addActionListener(this);
                    add(signUpButton);

                    setVisible(true);
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText().trim();
                    String email = emailField.getText().trim();
                    String password = new String(passwordField.getPassword());

                    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Save to database
                    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
                        PreparedStatement pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, name);
                        pstmt.setString(2, email);
                        pstmt.setString(3, password); // For real apps, hash the password!

                        pstmt.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Clear fields
                        nameField.setText("");
                        emailField.setText("");
                        passwordField.setText("");

                    } catch (SQLIntegrityConstraintViolationException ex) {
                        JOptionPane.showMessageDialog(this, "Email already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Database error!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                public static void main(String[] args) {
                    SwingUtilities.invokeLater(SignUpToDB::new);
                }
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUpForm());
    }
}
