package frame;

/* 사용될 메임 프레임 구성*/

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import event.*;


public class mainFrame extends JFrame {

	 public int PanelNum=0;						// 기본 메뉴 변수
	
	
	
	JPanel movePan= null;						// 기능 전환시 바꿀 패널 변수
	
	public mainFrame() {						// 메인 프레임의 설정
		
		
		// 패널 설정
		
	
		movePan=checkedPanel(PanelNum);					// checkedPanel 메소드를 이용해 현재 패널 변수값을 파악해 기능을 전환
		add(movePan);									// add메소드로 메인메뉴 패널로 이동
		
		// 설정
		setTitle("타자연습 프로그램");						// 상단 프로그램의 제목
		setSize(1000, 600);								// 프로그램 창(프레임)의 크기
		setLocation(400, 200);							// 프레임의 표시 좌표
		
		setVisible(true);								// 프레임의 표시 여부
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// x를 누르면 효과 설정
		setResizable(false);							// 확대/축소기능 미사용
		
	}
	
	public void drawPanel(int PanelNum) {					// 프레임을 전환하는 메소드(프레임 전환시 다시 그리는 방식)
		getContentPane().removeAll();						// 패널 인터페이스를 removeAll()메소드로 지운다
		getContentPane().add(checkedPanel(PanelNum));		// 패널 번호를 확인해 맞는 새 패널을 넣는다.
		//System.out.println(PanelNum+"번 화면으로 전환됨");		// 패널 전환 확인
		
		revalidate();										// 전환된 패널을 확인하는 메소드
		repaint();
	}
	
	
	 public JPanel checkedPanel(int PanelNum) {				// 패널의 번호를 체크후 맞는 패널 설정 메소드
		 JPanel tmp;										// 패널 임시 변수
		 if(PanelNum == 1) {								// 1입력시 낱말연습 패널 선택
			 tmp = new Practice1(this);						
		 } else if(PanelNum == 2) {							// 2입력시 낱말연습 패널 선택
			 tmp = new Practice2(this);
		 } else if(PanelNum == 3) {							// 3입력시 낱말연습 패널 선택
			 tmp = new Practice3(this);
		 } else {											// 이외의 패널 번호가 올경우 메인메뉴 패널 선택
			 tmp = new Menu(this);
		 }
		return tmp;
	 }
	
	
	
}
