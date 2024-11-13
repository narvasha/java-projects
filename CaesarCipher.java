import java.util.Scanner;
//Caesar Cipher (Encryption & Decryption)
public class CaesarCipher {

    // Method to encrypt the plaintext
    public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                char shifted = (char) (c + shift);
                if (Character.isLowerCase(c) && shifted > 'z' || 
                    Character.isUpperCase(c) && shifted > 'Z') {
                    shifted -= 26;
                }
                encryptedText.append(shifted);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    // Method to decrypt the ciphertext
    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, -shift);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            
            System.out.print("Enter shift number: ");
            int shift = scanner.nextInt();
            
            String encrypted = encrypt(text, shift);
            System.out.println("Encrypted text: " + encrypted);
            
            String decrypted = decrypt(encrypted, shift);
            System.out.println("Decrypted text: " + decrypted);
        }
    }
}
