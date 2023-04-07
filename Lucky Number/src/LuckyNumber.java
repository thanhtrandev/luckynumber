import java.lang.Math;
import java.util.Scanner;

public class LuckyNumber {
	// Khởi tạo các biến toàn cục 
	static int totalGames = 0; //Lưu giá trị tổng lượt chơi
	static int totalGuess = 0; // Lưu giá trị tổng lượt đoán
	static int bestGame = 0; // Lưu giá trị lượt chơi tốt nhất
	static double guessAvg = 0; // Lưu giá trị đoán đúng trung bình 

	public static void main(String[] args) {
	// Khởi tạo 2 phương thức play và report
		play(); 
		report();
	}

	public static void play() {
		Scanner sc = new Scanner(System.in); // Tạo Scanner có tên là sc để nhận giá trị nhập từ bàn phím
		String answer; // Biến lưu gí trị  để xác định xem bạn có muốn tiếp tục chơi hay không
		
		
		do {// Xác định bạn phải chơi 1 lần rồi có quyết định chơi tiếp hay không

			boolean isGuessRight = false; // Khởi tạo biến boolean là false để chạy được vòng lặp while 
			final int MAX_NUM = 100; // Số lớn nhất sau khi áp dụng nhân với Math.random()
			int LuckyNumber = (int) (Math.random() * MAX_NUM); // Dùng để tạo ra giá trị random 0=>1 với lớp toán tử Math.random() 
			int yourNumber; // Lưu giá trị nhập của số bạn đoán
			int guess = 0; // Lưu giá trị đoán của mỗi lượt chơi
			totalGames++; // Tăng giá trị lên 1 sau mỗi lần chơi tiếp, để lấy được giá trị totalGames khi kết thúc game.
			System.out.println(LuckyNumber); 

			while (!isGuessRight) { //Vòng lặp sẽ chạy đến khi đoán đúng thì dừng lại
				System.out.println("Số dự đoán của bạn là: ");
				yourNumber = sc.nextInt(); // Nhập số đoán từ bàn phím
				totalGuess++; //Tăng giá trị lên 1 sau mỗi lần đóan, để lấy được giá trị totalGuess khi kết thúc game.
				guess++; // Tăng giá trị lên 1 sau mỗi lượt đoán, sau mỗi lượt chơi giá trị sẽ quay về là 0 đã được gán trước

				//Các điều kiện để thực thi code
				if (LuckyNumber > yourNumber) {
					System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");

				} else if (LuckyNumber < yourNumber) {
					System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");

				} else {
					System.out.println("chúc mừng bạn đã đoán đúng con số may mắn sau " + guess + " lần dự đoán.");
					isGuessRight = true; //Điều kiện đúng để vòng lặp dừng lại
					
					if (bestGame == 0 || guess < bestGame) { // Điều kiện để lấy được giá trị bestGame
						bestGame = guess;
					}
				}

			}

			System.out.print("Do you want to play again? ");
			answer = sc.next(); //Nhận giá trị trả lời từ bàn phím.
			
			// Vòng lặp DO WHILE sẽ tiếp tục chạy khi điều kiện đúng.
			// Sử dụng phương thức equals để so sánh biến awser có bằng với giá trị nhập không để xét điều kiện 
			// IgnoreCase không phân biệt kiểu chữ Hoa hay thường
		
		} while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")); 
		//Sử dụng phương thức equals để so sánh biến awser có bằng với giá trị nhập không, 
		//IgnoreCase không phân biệt kiểu chữ Hoa hay thường

		guessAvg = (double) totalGuess / (double) totalGames; // Ép kiểu double để tính được giá trị chính xác.
	}

	public static void report() {
		// In ra kết quả theo yêu cầu khi dừng chơi, kết thúc phương thức play().
		System.out.println("Your Total Guess: " + totalGuess);
		System.out.println("Your Time Play: " + totalGames);
		System.out.println("Your Best Game: " + bestGame);
		System.out.println("Your Guess Avg: " + guessAvg);
	}

}
