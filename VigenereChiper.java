public class VigenereChiper {
        public String encrypt(String originalText, String key){
            //key = "CLASS";
            //originalText = "OBJECTORIENTEDPROGRAMMING";
            String res = "";
            originalText = toUpperString(originalText);
            for (int i = 0, j = 0; i < originalText.length(); i++){
                char c = originalText.charAt(i);
                if (c < 'A' || c > 'Z')
                    continue;
                char x;
                x= (char) ((c + key.charAt(j)%65+1));
                if(x>90)
                    x=(char) (x-26);
                res +=x;
                j = ++j % key.length();
            }
            System.out.println("Encrypted message: " + res);
            return res;
        }
        public String toUpperString(String text){
            text=text.toUpperCase();
            System.out.println("Uppercased message: " + text);
            return text;
        }
        public String decrypt(String encryptedText, String key ){
            String res = "";
            encryptedText = encryptedText.toUpperCase();
            for (int i = 0, j = 0; i < encryptedText.length(); i++){
                char c = encryptedText.charAt(i);
                if (c < 'A' || c > 'Z')
                    continue;

                char b;
                if ( c< key.charAt(j)){
                    c+=26;
                }
                b= (char) ((c - key.charAt(j)+64));
                if(b==64)
                    b=(char)(b+26);
                else if(b<0)
                    b=(char)(b);
                res +=b;
                j = ++j % key.length();
            }
            System.out.println("Decrypted message: " + res);
            return res;
        }
}
