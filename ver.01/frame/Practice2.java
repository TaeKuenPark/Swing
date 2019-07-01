package frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
/* 짧은 글 연습 패널 */

import javax.swing.*;
import event.*;

public class Practice2 extends TypingPanel {

	final static private int PanelNum=2;			// 짧은 글 연습 패널 번호값
	JLabel Title, view, rank;
	JTextField input;
	JLabel speed, speed_var, expect, expect_per;
	JButton start, end;
	
	private long startTime, workingTime;
	
	public Practice2(mainFrame frame) {				// 패널 전환을 위해 값을 받는다.
		this.frame=frame;
		setLayout(null);
		
		Title = new JLabel("짧은 글 연습");							
		input = new JTextField("");
		view = new JLabel();
		rank = new JLabel("점  수  표");
		
		expect = new JLabel("정확도 => ");							// 정확도 표시
		speed = new JLabel("타자속도 => ");						// 속도 표시
		expect_per = new JLabel("100"+"%");						// 정확도 변수가 들어감
		speed_var = new JLabel("0"+"타");						// 스피드 값이 들어감
		
		start = new JButton("시작하기");
		end = new JButton("끝 내 기");								// 종료 버튼
		
																/* 아래는 글꼴 설정 부분 */
		Title.setFont(new Font("돋움", Font.BOLD, 30));
		input.setFont(new Font("돋움", Font.BOLD, 20));
		rank.setFont(new Font("돋움", Font.BOLD, 15));
		input.setSize(50,10);
		
																/* 아래는 기능 위치 설정 부분 */
		Title.setBounds(400, 70, 800, 100);
		view.setBounds(400, 200, 800, 100);
		input.setBounds(400, 300, 200, 20);
		rank.setBounds(800, 110, 800, 20);
		expect.setBounds(750, 210, 800, 40);
		speed.setBounds(750, 310, 800, 40);
		end.setBounds(795, 460, 85, 30);
		expect_per.setBounds(860, 210, 800, 40);
		speed_var.setBounds(860, 310, 800, 40);
		start.setBounds(450, 250, 100, 30);
		view.setText(pm.OutputWord());
		
		input.setVisible(false);
		input.setFocusable(false);								// 시작시에는 낱말 입력이 나타나지 않는다
		view.setVisible(false);
																// 시작버튼을 눌러야 프로그램이 실행된다.
																/* 기능(Component)를 패널에 추가한다 */
		add(Title);
		add(view);
		add(input);
		add(rank);
		add(expect);
		add(expect_per);
		add(speed);
		add(speed_var);
		add(end);
		add(start);
		
		// 이벤트  입력부분
		// start이벤트
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				workingTime = System.currentTimeMillis();		// 밀리 세컨드(0.001초)로 현재 시간을 계산
				onOff(1);
				view.setText(pm.OutputSetance());
				
			}
		});
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO here wirte process event
				
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					onOff(0);
				}
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					//System.out.println("이벤트 실행");
					startTime = System.currentTimeMillis();									// 엔터를 누르기 전까지의 시간을 측정
					
					speed_var.setText(pm.SpeedMensure(startTime,workingTime)+"타");			// 스피드 값이 들어감
					expect_per.setText(pm.ExpectMensure(input.getText())+"%");				// 정확도가 출력됨
					
					view.setText(pm.OutputSetance());										// 새 단어를 불러온다
					input.setText("");														// 입력칸을 비운다
					input.requestFocus();													// 다시 포커스를 가져온다
				}
			}
		});
		end.addActionListener(new MoveViewManger(frame, 0));
	}
	
	
	
	// 프로그램 틀 생성
	public void paint(Graphics g) {
		super.paint(g);
		
		int tmp=70;
		g.drawRect(170, 70, 750, 450);		// 전체 사각형 틀
		g.drawRect(210, 180, 500, 220);		// 단어 틀
		g.drawRect(730, 70, 190, 450);		// 점수표 목록
		
		for(int i =0; i< 3; i++) {			// 점수 목록 테이블
			g.drawRect(730, tmp, 190, 100);
			tmp+=100;
		}
	}
	public void onOff(int num) {				// 시작 버튼 시 입력칸 설정 메소드
		if(num == 1) {
			
			input.setVisible(true);				// 입력칸이 
			input.setFocusable(true);			// 켜지고 커서 생성
			view.setVisible(true);				// 낱말 표시됨
			start.setVisible(false);			// start버튼은 사라짐
		} else if(num == 0) {
			
			input.setVisible(false);			// 입력칸이
			input.setFocusable(false);			// 꺼지고 커서 사라짐 
			view.setVisible(false);				// 낱말 사라짐
			start.setVisible(true);				// 버튼 다시 나타남
		}
	}
	
	
}
