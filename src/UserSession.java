/**
 * Singleton class to manage user session information
 * Supports multiple roles: admin, faculty, club, student
 */
public class UserSession {
    private static int userId;
    private static String username;
    private static String email;
    private static String role; // "admin", "faculty", "club", or "student"
    private static boolean loggedIn = false;
    private static long lastActivityTime;

    // Private constructor to prevent instantiation
    private UserSession() {}

    /**
     * Initialize user session upon login
     * @param id User ID from database
     * @param user Full name of user
     * @param userEmail User's email address
     * @param userRole User's role (admin/faculty/club/student)
     */
    public static void login(int id, String user, String userEmail, String userRole) {
        userId = id;
        username = user;
        email = userEmail;
        role = userRole.toLowerCase(); // Normalize to lowercase
        loggedIn = true;
        updateLastActivity();
    }

    /**
     * Clear session data upon logout
     */
    public static void logout() {
        userId = 0;
        username = null;
        email = null;
        role = null;
        loggedIn = false;
    }

    /**
     * Update username in current session
     */
    public static void setUsername(String newUsername) {
        if (loggedIn && newUsername != null && !newUsername.trim().isEmpty()) {
            username = newUsername.trim();
        }
    }

    /**
     * Update last activity timestamp
     */
    public static void updateLastActivity() {
        lastActivityTime = System.currentTimeMillis();
    }

    /**
     * Check if session has expired
     * @param timeoutMinutes Timeout period in minutes
     * @return true if session has expired
     */
    public static boolean isExpired(int timeoutMinutes) {
        return (System.currentTimeMillis() - lastActivityTime) > (timeoutMinutes * 60 * 1000);
    }

    // Role check methods
    public static boolean isAdmin() {
        return "admin".equals(role);
    }

    public static boolean isFaculty() {
        return "faculty".equals(role);
    }

    public static boolean isClub() {
        return "club".equals(role);
    }

    public static boolean isStudent() {
        return "student".equals(role);
    }

    // Getters
    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static int getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }

    public static String getRole() {
        return role;
    }

    /**
     * Check if user has required role
     * @param requiredRole Role to check against
     * @return true if user has the required role or is admin
     */
    public static boolean hasRole(String requiredRole) {
        if (!loggedIn) return false;
        return role.equals(requiredRole.toLowerCase()) || isAdmin();
    }
}