package frame;

/* 메인 메뉴 사용을 위한 패널 */

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import event.*;

public class Menu extends TypingPanel {					

	final private int PanelNum =0;		// 메인(메뉴)화면
	
	// 기능
	private JButton exit;						// 종료버튼 이동 버튼
	private JButton word;						// 낱말연습 이동 버튼
	private JButton longtype;					// 긴글연습 이동 버튼
	private JButton littletype;					// 짧은글 연습 이동 버튼
	private JLabel Title;						// 프로그램 이름 출력
	
	public Menu(mainFrame frame) {
		this.frame = frame;						// 현재의 메인 프레임을 받아 메소드및 기능을 사용
		setLayout(null);						// 레이아웃 수동 배치
		
												/* 아래는 각 버튼, 라벨 배치 */
		Title = new JLabel("타자연습에 오신것을 환영합니다.");
		exit = new JButton("종     료");
		word = new JButton("낱말 연습");
		littletype = new JButton("짧은 글 연습");
		longtype = new JButton("긴 글 연습");
		
												/* 아래는 폰트 설정 부분 */
		Title.setFont(new Font("돋움", Font.BOLD, 30));
		
												/* 아래는 버튼및 기능 수동 배치 부분 */
		Title.setBounds(200, 100, 600, 200);
		word.setBounds(250, 250, 130, 50);
		littletype.setBounds(400, 250, 130, 50);
		longtype.setBounds(550, 250, 130, 50);
		exit.setBounds(300, 350, 300, 70);
												/* 아래는 기능을 패널에 추가하는 부분 */
		add(Title);
		add(exit);
		add(word);
		add(littletype);
		add(longtype); 
												/* 아래는 패널내의 이벤트 부분 */
		
		word.addActionListener(new MoveViewManger(frame,frame.PanelNum+1));			// 낱말연습 전환
		littletype.addActionListener(new MoveViewManger(frame,frame.PanelNum+2));	// 짧은 글 연습 전환
		longtype.addActionListener(new MoveViewManger(frame,frame.PanelNum+3));		// 긴글 연습 전환
		exit.addActionListener(new ExitEvent());									// 종료
		
	}
}