package util;

public class SessionManager {
    private static String username;
    private static String role;

    // Menyimpan sesi pengguna yang sedang login
    public static void login(String user, String userRole) {
        username = user;
        role = userRole;
    }

    // Mengambil username pengguna yang sedang login
    public static String getUsername() {
        return username;
    }

    // Mengambil role pengguna yang sedang login
    public static String getRole() {
        return role;
    }

    // Mengecek apakah pengguna sudah login atau belum
    public static boolean isLoggedIn() {
        return username != null;
    }

    // Logout (menghapus sesi)
    public static void logout() {
        username = null;
        role = null;
    }
}
