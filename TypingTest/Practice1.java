package mainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Practice1 extends JPanel {

	private JTextArea input;
	private JLabel Title, rank;
	private JLabel view, expect, expect_per, speed, speed_var;
	private JButton end;
	private Main win;
	
	public Practice1(Main win) {
		setLayout(null);
		this.win = win;
		
		Title = new JLabel("낱 말   연 습");
		input = new JTextArea();
		view = new JLabel("예시문장");
		rank = new JLabel("점  수  표");
		expect = new JLabel("정확도 => ");
		speed = new JLabel("타자속도 => ");
		expect_per = new JLabel(" "+"%");			// 정확도 변수가 들어감
		speed_var = new JLabel(" "+"타");				// 스피드 값이 들어감
		end = new JButton("끝 내 기");
		
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
		
		
		// 이벤트 설정
		end.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("Frame");
				
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
	
	
}
