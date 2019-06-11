package mainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import list.*;


public class Practice1 extends JPanel {

	private JTextArea input;
	private JLabel Title, rank;
	private JLabel view, expect, expect_per, speed, speed_var;
	private JButton end,tmp;
	private Main win;
	int count=0;
	
	
	
	public Practice1(Main win) {
		setLayout(null);
		this.win = win;
		
		
		Title = new JLabel("낱 말   연 습");
		input = new JTextArea();
		view = new JLabel(loadWordKor());
		rank = new JLabel("점  수  표");
		expect = new JLabel("정확도 => ");
		speed = new JLabel("타자속도 => ");
		
		expect_per = new JLabel(" "+"%");				// 정확도 변수가 들어감
		speed_var = new JLabel(" "+"타");				// 스피드 값이 들어감
		
		
		end = new JButton("끝 내 기");						// 종료 버튼
		tmp =  new JButton("임 시");
		
		// 글꼴, 위치
		Title.setFont(new Font("돋움", Font.BOLD, 30));
		input.setFont(new Font("돋움", Font.BOLD, 20));
		rank.setFont(new Font("돋움", Font.BOLD, 15));
		input.setSize(50,10);
		
		Title.setBounds(400, 70, 800, 100);
		view.setBounds(400, 200, 800, 100);
		input.setBounds(400, 300, 200, 20);
		rank.setBounds(800, 110, 800, 20);
		expect.setBounds(750, 210, 800, 40);
		speed.setBounds(750, 310, 800, 40);
		end.setBounds(795, 460, 85, 30);
		tmp.setBounds(800, 180, 20, 12);
		expect_per.setBounds(860, 210, 800, 40);
		speed_var.setBounds(860, 310, 800, 40);
		
		add(Title);
		add(view);
		add(input);
		add(rank);
		add(expect);
		add(expect_per);
		add(speed);
		add(speed_var);
		add(end);
		add(tmp);
		
		
		end.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				count++;
				view.setText(loadWordKor());		// 새로 지정시 setText이용
				win.change("Frame");
				
			}
		});
		tmp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tmp = input.getText();
				view.setText(tmp);
				
			}
			
		});
		
	}
	
	public void paintComponent(Graphics p) {
		super.paintComponent(p);
		p.setColor(Color.BLACK);
		
		p.drawRect(280, 200, 450, 300);
		p.drawRect(735, 100, 200, 400);
		p.drawRect(735, 100, 200, 30);
	}
	
	
	
	
	  public String loadWordKor() { // 기본 낱말 단어 불러오기메소드
	  
	  Kor kor = new Kor(); 
	  int randomNum;
	  String[] arr = kor.getBasic_word(); 
	  int len = kor.getBasic_word().length; // 배열의 길이
	  
	  randomNum = (int) (Math.random() *len); 
	  String str =arr[randomNum];
	 
	  return str+count; 
	  
	  }
	  
	  // 생성할 이벤트
	  
	  // 엔터를 누르면 다음 새 단어가 나오는 이벤트 발생
	  // 글자를 입력시에 글자가 맞는지에 따라 
	  // 갯수 변수를 만들어 현재 몇개의 단어를 연습했는지 끝내기 버튼을 누를기 출력
	  // 타자 속도
	  // 시간 함수를 이용,
	  // 
	  // 정확도
	  // 100%에서 시작, 
	  // 한글자 다를 때마다 1씩 깍이며, 50이하가 되면 경고,
	  // 정확도가 0이 되면 강제 종료
	  // 끝내기를 누르는 경우 차후 점수를 기록할수 있는 기록판 준비
	  
	
}
