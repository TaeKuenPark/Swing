package event;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/* 낱말연습 기능 이벤트를 정의하는 클래스 */

import list.*;

public class PracticeManager {

	private String[] tmpArr;						// 단어장을 가져오는 배열
	private ArrayList<String> tmpArrList;
	private String currentWord;						// 현재 입력하는 낱말을 임시저장
	private int size;								// 낱말의 크기 측정을 위한 변수
	private int speed=0;							// 타자 속도 측정을 위한 변수
	private long record =0;							// 이전 시간값을 저장하는 변수
	private int expect=100;							// 정확도 저장
	final static int expectMax =100;				// 최초 정확도 100
	
													// 아래는 설정 언어를 받아온다
	Eng e = new Eng();								// 영어
	Jap jp = new Jap();								// 일본어
	Kor k = new Kor();								// 한국어
	Sentance st = new Sentance();					// 문장(db)
	Literacy literacy=null;								// txt불러오기
	
	public void UpdateFile(String File_) {		// 파일을 받아 긴글쓰기셋팅(txt)
		String FileName = File_;
		
		this.literacy =  new Literacy(FileName);
		
	}
	
	public void LoadString(String[] wordA_) {			// 단어장을 가져오는 메소드
		tmpArr = wordA_;							// 임시 단어장을 가져온다
		size= wordA_.length;						// 임시 단어장의 단어량 체크
	}		// 단어장을 가져온다.
	
	public void LoadString(ArrayList<String> wordB_) {
		tmpArrList = wordB_;
		size = tmpArrList.size();
	}
	
	public String OutputWord() {					// 단어장배열에서 
													// 랜덤 단어를 가져온다
		String tmp;									// 랜덤단어 임시저장
		LoadString(k.getBasic_word());				// 단어장을 불러온다
		
		
		int len =(int) (Math.random()* size);				// Math함수의 random메소드를 이용해 단어를 랜덤출력
		tmp =tmpArr[len];									// 단어장을 읽어온다
		currentWord = tmp;									// 읽어온 단어를 임시 String변수에 저장
		//System.out.println(size+","+len+","+currentWord);	// 출력 디버깅 확인용도
		return tmp;											// 출력
	}
	
	
	public String OutputSetance() {
		String tmp;
		int len;
		if(st.getLoadWord() == null) {
			LoadString(st.getSentance_Basic());
			len =(int) (Math.random()* size);				// Math함수의 random메소드를 이용해 단어를 랜덤출력
			tmp = tmpArr[len];								// 단어장을 읽어온다
			currentWord = tmp;								// 읽어온 단어를 임시 String변수에 저장
			return tmp;										// 출력							
		}
		else {
			LoadString(st.getLoadWord());
			len = (int)(Math.random() * size);
			tmp = tmpArrList.get(len);
			currentWord =tmp;
			return tmp;										// 출력
		}	
	}
	
	public String OutputLiteracy(int pageNum) {
		String tmp;
		LoadString(literacy.getLiteray());
		tmp = tmpArrList.get(pageNum).trim();							// trim(양끝 공백 제거)
		currentWord= tmp;
		return tmp;
	}
	
	/*계산 이벤트 부분*/
													/* 아래는 타자 속도 측정을 관리하는 메소드 */
	public int SpeedMensure(long startTime, long workingTime) {			// 타자속도 반환메소드
		int Speed = SpeedCalculate(startTime,workingTime);				// 타자속도 계산 메소드에서 계산
		return Speed;													// 반환
		
	} 
	
	public int SpeedCalculate(long startTime, long workingTime) {		// 시작시간과 엔터칠때 시간을 받아 계산
		
		int wlen = currentWord.length();								// 문장의 길이를 받아온다
		//System.out.println(startTime);
		float tmp;
		if(speed == 0) {												// 스피드가 초깃값(0)인 경우
			System.out.println(startTime+","+workingTime);															// record변수에 시작 시간 기입
			record = startTime;
			speed = (int) ((record-workingTime));					// 기본 계산식 
			System.out.println(speed);	
			speed = (wlen*600000)/speed;
			
			//System.out.println(speed+","+wlen);						// (엔터칠때의 시간-이전 시간)	/낱말의 길이		
		}
		else {
			int result = (int) (startTime-record);						// 엔터 칠때의 시간 - 이전시간
			record= startTime;											// 이전시간에 현재 enter버튼의 값을 받는다
			System.out.println(result);	
			speed = (wlen*600000)/result;										// 낱말의 길이를 나눈다
			//System.out.println(speed+","+wlen);
		}
		return speed;													// 값 반환
		
	}

																/* 아래는 정확도 측정을 위한 메소드 */
	public int ExpectMensure(String str) {						// 정확도 받환 메소드
		return ExpectCalculate(str);
	} 
	
	public int ExpectCalculate(String str) {					// 현재 문장을 받아 글자 비교를 통해 정확도 측정하는 메소드
		
		if(currentWord.length() != str.length()) {				// 글자수 않맞는 경우 정확도를 감소
			expect -=currentWord.length();						// 정확도 감소
			//System.out.println("점수 :"+currentWord+","+currentWord.length());
		}
		else {
			for(int i =0; i<currentWord.length(); i++) {		// 정확도를 루프를 돌려 비교
				//System.out.println(str.substring(i, i+1)+"="+currentWord.substring(i, i+1));
				if(str.substring(i, i+1).equals(currentWord.substring(i,i+1))) {		// 글자수대로 한글자씩 비교
					
				}else {
					expect--;															// 틀린 부분 있을때마다 정확도 -1
					//System.out.println("점수 :"+expect);
				}
				//System.out.println("점수 :"+expect);
			}
		
		}
		
		if(expect ==0) {																// 0인 경우 정확도 최대치로 100
			expect = expectMax;															// 시작점
		} else if(expect < 20) {														// 20이하가 될시 0이되어 타자연습 종료
			JOptionPane.showMessageDialog(null, "정확도가 20%이하입니다!");
			expect = 0;
		} 
		return expect;
	} // 정확도 계산
	//public void SpeedMensure() {} // 비교(정확도 측정)
	
}
