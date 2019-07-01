package event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/* 긴 글 연습의 다음 줄로 라인 전환하는 이벤트 메소드*/

public class EnterNextLine implements KeyListener{

	JLabel la_;											// 다음 올 텍스트를 출력할 JLabel을 받는다
	JTextField Startjt_, Nextjt_;						// 엔터 누르기 이전, 다음에 사용할 TextField를 받는다
	JLabel Speed_var, Expact_var;						// 측정된 정확도, 속도를 표기할 JLabel을 받는다
	PracticeManager pm;									// 주요 이벤트 관리 메소드
	MoveNextLineEvent moveE;							// 라인 전환의 주요이벤트 메소드
	
	static private int pageNum;							// 현재 문장의 위치 값을 받는다
	private long startTime, workingTime;				// 시작시간과 엔터 누르기 이전의 시간을 받는다.
	
	
	public EnterNextLine(JTextField Startjt_, JTextField Nextjt_,
			JLabel la_,int pageNum,long startTime, PracticeManager pm, JLabel Speedrate, JLabel Expactrate) {
															/* 생성자로, 엔터누르기 이전, 다음의 textfield, 다음 문장을 표기할JLabel
															 * 문장수 넘버, 시작시간, 이벤트 관리메소드, 스피드 출력위치, 정확도출력 위치를 받느다. */
		this.la_ =la_;
		this.pm=pm;
		this.Startjt_ =Startjt_;
		this.Nextjt_ = Nextjt_;
		this.pageNum=pageNum;
		this.startTime = startTime;
		this.Speed_var=Speedrate;
		this.Expact_var=Expactrate;
	}
	@Override
	public void keyPressed(KeyEvent e) {								// 사용될 키이벤트
		// TODO here write process event
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {						/* 엔터를 누를시 아래의 이벤트 적용*/
			
			 moveE= new MoveNextLineEvent(pageNum);						// 현재의 문장 넘버변수를 기반으로 다음 문장 호출 이벤트 적용
			 //pageNum++;													// 현재의 문장 넘버변수 증가
			 
			 //System.out.println(pageNum);								// 번호 전달 테스트용 
			 Expact_var.setText(setExpectMensure(Startjt_));			// 정확도 측정후 표기
			 pageNum =moveE.MoveNextLine(la_, Nextjt_, Startjt_,pm);	// 다음 문장으로 넘어가는 이벤트 적용
			 workingTime=System.currentTimeMillis();					// 엔터 누르기 직전까지 시간측정
			 
			 Speed_var.setText(setSpeedMensure(workingTime, startTime));// 타자 속도 측정후 표기
			 
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {						// ESC를 누를시 이벤트
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public String setSpeedMensure(long startTime, long workingTime) {			// 속도 측정 문장을 내보내는 메소드 
		String tmp = pm.SpeedMensure(startTime, workingTime)+"타";
		
		return tmp;
	}
	public String setExpectMensure(JTextField input_) {							// 정확도가 측정된 문장을 내보내는 메소드
		String tmp = pm.ExpectMensure(input_.getText())+"%";
		
		
		return tmp;
	}


}
