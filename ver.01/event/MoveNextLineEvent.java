package event;

import javax.swing.*;

/* 줄바꿈 이벤트 기능을 관리하는 메소드 */
public class MoveNextLineEvent {

	static private int pageNum;										// 문장의 번호
	ButtonOnOffManager btm = new ButtonOnOffManager();				// 버튼 온오프 편의 메소드
	PracticeManager pm = new PracticeManager();						// 이벤트 총괄 메소드
	
	public MoveNextLineEvent(int pageNum) {							// 페이지 번호를 가져오는 메소드
		this.pageNum = pageNum;
		//pm.UpdateFile("연습문장.txt");								// 파일을 업데이트.(파일은 이벤트총괄 메소드)를 이용해 관리한다
	}
	
	public int MoveNextLine(JLabel NextL_,JTextField NextF_, JTextField StartF_, PracticeManager pm) {
																	/* 다음문장 표시부분, 다음 입력공간, 현재입력공간, 현재 총괄 이벤트 매니저를 가져온다*/
		this.pm =pm;												// 현재 이벤트 관리자의 사항 호출
		btm.turnTextField(NextF_, true);							// 다음 라인을 불러온다
		btm.fixTextField(StartF_, false);							// 현재 텍스트 필드를 비활성화
		btm.turnLabel(NextL_, true);								// 다음 택스트 라벨을 활성화
		pageNum++;													// 다음 문장을 위해 문장의 번호 변수값 증가
		//System.out.println(pageNum);								// 번호 전달 테스트용
		//System.out.println(pm.OutputLiteracy(pageNum));			// 번호에 따른 문장 출력 테스트용
		
		if(pageNum > 3) {											// 번호가 3이상부터는 비활성화된 텍스트 필드가 고정되므로
			btm.fixTextField(NextF_, true);							// 비활성화된 텍스트 필드를 풀어주고 
			NextF_.setText("");										// 공백으로 만든다.
		}else {
			
		}
		NextL_.setText(pm.OutputLiteracy(pageNum));					// 다음 문장 배치
		NextF_.requestFocus();										// 포커스를 준다
		
		
		return pageNum;												// 현재 페이지의 번호 출력
	}
}
