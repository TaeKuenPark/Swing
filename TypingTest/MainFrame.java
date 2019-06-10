package mainFrame;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JPanel {
	
	private JButton exit;				// 종료버튼
	private JButton word;				// 낱말연습
	private JButton longtype;			// 긴글연습
	private JButton littletype;			// 짧은글 연습
	private Main win;					// 현재 패널의 위치를 넘길 메소드
	
	private JLabel Title;// 타이틀메세지
	
	public MainFrame(Main win) {
		this.win = win;
		setLayout(null);
		// 버튼 수동배치
		
		Title = new JLabel("타자연습에 오신것을 환영합니다.");
					
		exit = new JButton("종     료");
		word = new JButton("낱말 연습");
		littletype = new JButton("짧은 글 연습");
		longtype = new JButton("긴 글 연습");
		
		// 폰트 설정
		Title.setFont(new Font("돋움", Font.BOLD, 30));
		
		// 버튼 수동배치
		Title.setBounds(200, 100, 600, 200);
		word.setBounds(250, 250, 130, 50);
		littletype.setBounds(400, 250, 130, 50);
		longtype.setBounds(550, 250, 130, 50);
		exit.setBounds(300, 350, 300, 70);
		
		add(Title);
		add(exit);
		add(word);
		add(littletype);
		add(longtype);
		
		
	// 버튼 이벤트목록
	// 1. 종료 이벤트	
	exit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
							
		}
	});
		
	// 2. 낱말 연습 전환	
	word.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("word");
			
		}	
	});
	
	
	// 3. 짧은 글 연습 전환
	littletype.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("little");
			
		}	
	});
	// 4. 긴 글 연습 전환
	longtype.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("long");
			
		}	
	});	
		
	}
	
	
}
