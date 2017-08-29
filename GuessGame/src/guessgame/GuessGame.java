package guessgame;

public class GuessGame {
	Player p1;	//用三个实例变量分别表示3个Player对象
	Player p2;
	Player p3;

	public void startGame() {	//创建出Player对象
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();

		int guessp1 = 0;	//声明3个变量来保存猜测的数字
		int guessp2 = 0;
		int guessp3 = 0;

		boolean p1isRight = false;	//声明3个变量来保存是否猜中
		boolean p2isRight = false;
		boolean p3isRight = false;

		int targetNumber = (int) (Math.random() * 10);	//产生谜底数字
		System.out.println("I'm thinking of a number between 0 and 9...");

		while(true) {
			System.out.println("Number to guess is " + targetNumber);

			p1.guess();	//调用Player的guess()方法
			p2.guess();
			p3.guess();

			guessp1 = p1.number;	//取得每个Player的数字并将它列出
			System.out.println("Player one guessed " + guessp1);

			guessp2 = p2.number;
			System.out.println("Player two guessed " + guessp2);

			guessp3 = p3.number;
			System.out.println("Player three guessed " + guessp3);

			if(guessp1 == targetNumber) {
				p1isRight = true;
			}
			if(guessp2 == targetNumber) {
				p2isRight = true;
			}
			if(guessp3 == targetNumber) {
				p3isRight = true;
			}

			if(p1isRight || p2isRight || p3isRight) {	//如果有一个或者多个玩家猜中
				System.out.println("We have a winner!");
				System.out.println("Player one got it right? " + p1isRight);
				System.out.println("Player two got it right? " + p2isRight);
				System.out.println("Player three got it right? " + p3isRight);
				System.out.println("Game is over.");
				break;	//有人猜到正确答案，则游戏结束，循环终止
			}
			else {	//都没猜到，游戏继续进行
				System.out.println("Players will have to try again.");
			}
		}
	}
}