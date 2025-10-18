import java.util.*;

public class Workshop7 {
    
    // Simulation of Las Vegas Algorithm: Prime number test 
    // Las Vegas algoritması simülasyonu: Asallık testi
    public static String runWithTimeout(int n, int timeoutSeconds) {
        // Bu fonksiyon Las Vegas algoritmasının simülasyonu gibi çalışacak
        Random rand = new Random();
        
        // Zaman aşımını taklit etmek için rastgele bir durum oluşturuyoruz
        int maxAttempts = timeoutSeconds * 2; // Süreyi denemelere dönüştürüyoruz
        for (int i = 0; i < maxAttempts; i++) {
            int a = rand.nextInt(n - 2) + 2; // Rastgele a sayısı (2 ile n-2 arasında)
            if (modularExponentiation(a, n - 1, n) != 1) {
                return null; // Zaman aşımı: Bu denemede asal olmadığı bulunmuş
            }
        }
        
        return "Sonuç bulundu: " + n + " asal sayıdır."; // Asal olduğu garantilendi
    }

    // Rastgele tahmin yapan fonksiyon
    public static String randomGuess() {
        Random rand = new Random();
        return "Rastgele Tahmin: " + rand.nextInt(100);
    }

    // Las Vegas algoritmasını Monte Carlo algoritmasına dönüştüren fonksiyon
    public static String lVtoMC(int n, int timeoutSeconds) {
        // Las Vegas algoritmasını çalıştırma
        String result = runWithTimeout(n, timeoutSeconds);
        
        // Eğer sonuç bulunamadıysa rastgele tahmin yap
        if (result != null) {
            return result;
        } else {
            return randomGuess(); // Zaman aşımı olursa rastgele tahmin döndür
        }
    }

    // Modüler üstel hesaplama fonksiyonu: a^b % m hesaplar
    public static int modularExponentiation(int a, int b, int m) {
        int result = 1;
        a = a % m; // a'nın mod m'ye göre değeri
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % m;
            }
            b = b / 2;
            a = (a * a) % m;
        }
        return result;
    }

    // Ana fonksiyon
    public static void main(String[] args) {
        int n = 37; // Asallık testi yapılacak sayı
        int timeout = 5; // 5 saniyelik bir timeout süresi (deneme sayısı ile simüle edilecek)
        
        System.out.println(lVtoMC(n, timeout));
    }
}
