package frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import event.*;


public class Practice3 extends TypingPanel {

	final static private int PanelNum=3;					// 긴 글 연습번호 3번
	private int PageNum=0;									// 현재의 연습 문장의 번호를넘기는 변수
	/*패널 목록*/
	private JLabel Title1, Title2;							/*사용 버튼, 라벨, textfleid 목록*/
	
	private JButton start, end;								 
	
	private JLabel line1, line2, line3, line4;
	private JTextField t1,t2,t3,t4;
	private JLabel speed, expact, speed_var, expact_var;
	private String str1, str2, str3, str4;
	private long startTime;
	
	PracticeManager pm = new PracticeManager();				// 글쓰기 이벤트를 불러온다
	ButtonOnOffManager btnm = new ButtonOnOffManager();		// 버튼 onoff편의 메소드를 불러온다
	
	public Practice3(mainFrame frame) {
		this.frame = frame;									// 현재 프레임 확인
		setLayout(null);									// 레이아웃 수동 조정메소드
		
		pm.UpdateFile("연습문장.txt");							// 현재 파일을 업데이트.
		
															/* 버튼의 구현 */
		end = new JButton("끝내기");
		start = new JButton("시  작");
		
		Title1 = new JLabel("긴  글");
		Title2 = new JLabel("연  습");
		
		line1 = new JLabel(str1);
		line2 = new JLabel(str2);
		line3 = new JLabel(str3);
		line4 = new JLabel(str4);
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
																					/* 타자속도 표시 부분*/
		speed = new JLabel(" 현재 타수(평균)");
		expact = new JLabel(" 현재 정확도 ");
		speed_var = new JLabel("0"+"타");
		expact_var = new JLabel("100"+"%");
																					/*폰트및 다른사항*/
		Title1.setFont(new Font("돋움", Font.BOLD, 20));
		Title2.setFont(new Font("돋움", Font.BOLD, 20));
		
																					/* 요소(Componet)배치 부분*/
		Title1.setBounds(60, 80, 110, 20);
		Title2.setBounds(60, 105, 110, 20);
		line1.setBounds(200, 80, 700, 20);
		line2.setBounds(200, 180, 700, 20);
		line3.setBounds(200, 300, 700, 20);
		line4.setBounds(200, 420, 700, 20);
		t1.setBounds(200, 120, 700, 20);
		t2.setBounds(200, 220, 700, 20);
		t3.setBounds(200, 340, 700, 20);
		t4.setBounds(200, 460, 700, 20);
		
		speed.setBounds(30, 230, 140, 20);
		expact.setBounds(30, 330, 140, 20);
		speed_var.setBounds(70, 270, 140, 20);
		expact_var.setBounds(70, 370, 140, 20);
		
		start.setBounds(475, 265, 80, 30);
		end.setBounds(20, 500, 140, 30);
		
		
		setAllvisual(false);																			/* 이벤트 부분 */
		end.addActionListener(new MoveViewManger(frame, 0));
		
		
		add(Title1);
		add(Title2);
		add(line1);
		add(line2);
		add(line3);
		add(line4);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(speed);
		add(expact);
		add(speed_var);
		add(expact_var);
		add(start);
		add(end);
																					/*이곳부터 이벤트 관리*/
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,"긴글연습을 시작합니다.");
				startTime=System.currentTimeMillis();					// 밀리 세컨드(0.001초)로 현재 시간을 계산
				
				btnm.turnButton(start, false);							// 버튼 onoff메소드로 start버튼을 누르면
				btnm.turnLabel(line1, true);							// 1번째 문장과 1번째 텍스트 필드가 나타나고, start버튼 사라짐
				btnm.turnTextField(t1, true);
				line1.setText(pm.OutputLiteracy(PageNum));				// 1번째 txt파일의 문장이 배치됨
				//System.out.println(startTime);
				
				// 총 4줄로 구성되어있으며, 각각 EnterNextLine이라는 메소드에서 엔터를 누를시 다음문장으로 넘어가 타자 문장을 계속 불러온다.
				t1.addKeyListener(new EnterNextLine(t1, t2, line2, PageNum, startTime, pm, speed_var, expact_var));
				t2.addKeyListener(new EnterNextLine(t2, t3, line3, PageNum, startTime, pm, speed_var, expact_var));
				t3.addKeyListener(new EnterNextLine(t3, t4, line4, PageNum, startTime, pm, speed_var, expact_var));
				t4.addKeyListener(new EnterNextLine(t4, t1, line1, PageNum, startTime, pm, speed_var, expact_var));
				
			}
		});
		
		
	}
	
											/* 프레임 사각형 */
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawRect(172, 52, 780, 480);		// 전체사각형 틀2
		g.drawRect(170, 50, 780, 480);		// 전체 사각형 틀1
		
		g.drawRect(20, 50, 140, 480);		// 사각형 프레임
		g.drawRect(20, 50, 140, 100);
		
		for(int i=0; i<2; i++) {
			g.drawRect(20, 220+(i*100), 140, 40);
			g.drawRect(20, 260+(i*100), 140, 60);
			
		}
		
		
	}
	
	public void setAllvisual(boolean type) {	//　화면 보이기 안보이기 메소드
		
		line1.setVisible(type);					// setVisual(booleantype)이라는 메소르로 버튼을 패널에 표시할지않할지 결정
		line2.setVisible(type);
		line3.setVisible(type);
		line4.setVisible(type);
		t1.setVisible(type);
		t2.setVisible(type);
		t3.setVisible(type);
		t4.setVisible(type);
	}
}


