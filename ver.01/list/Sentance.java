package list;

import java.util.ArrayList;

import event.*;

public class Sentance {

	private ArrayList<String> loadWord= new ArrayList<String>();
	String sentance_basic[] = {"좋은 하루 되십시오", "나랏말싸미 듕국에 달아", "베토벤 바이러스",
							  "you are fire", "I’m faded So lost, I’m faded", "public static void String[] args"};

	public Sentance(){
		setDBSentance();			// db의 문장테이블을 확인하여 문장이 있으면 가져온다.
									// loadDB메소드를 이용해 데이터 베이스에 저장된 문장을 불러온다.
	}
	
	 public void setDBSentance() { // 이곳에서 데이터베이스의 문장을 받아온다
		DBManager db = new DBManager();
		 loadWord = db.loadDB();
		// for(int i = 0; i<loadWord.size(); i++) {
		//	 System.out.println(loadWord.get(i));
		// }
	 }
	 
	 // get/Set
	 public String[] getSentance_Basic() {
		 return sentance_basic;
	 }
	 
	 public ArrayList<String> getLoadWord() {
		 return loadWord;
	 }
	 
	 
}




 