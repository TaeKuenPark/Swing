package frame;

					/* 낱말 연습 패널 */

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import event.*;


public class Practice1  extends TypingPanel{

	final static private int PanelNum=1;						// 낱말연습은 패널 번호 1번
	
																/* 아래는 사용할 J패널요소 */
	private JTextField input;									// 입력 부분
	private JLabel Title, rank;									// 현재 기능 제목, 점수
	private JLabel view, expect, expect_per, speed, speed_var;	// 단어출력, 정확도, 정확도%, 속도(타수), 속도
	private JButton end,start;									// 시작버튼, 낱말연습 나가기 버튼
	private long startTime, workingTime;						// 시작시간, 종료시간

	public Practice1(mainFrame frame) {							// 현재 프레임을 받아 프레임 전환의 기능을 사용
		this.frame = frame;
		setLayout(null);										// 레이아웃은 수동배치 설정
																/* 아래에 패널의 기능객체 설정 */
		Title = new JLabel("낱 말   연 습");							
		input = new JTextField("");
		view = new JLabel();
		rank = new JLabel("점  수  표");
		
		expect = new JLabel("정확도 => ");						// 정확도 표시
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
		JOptionPane.showMessageDialog(null, "[시작하기] 버튼을 누르면 낱말연습을 시작합니다 ");
																/* 아래는 패널안의 이벤트부분 */
		start.addActionListener(new ActionListener() {			// 타자연습 시작 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {		// 시작버튼을 누르면 타자연습 시작
				workingTime = System.currentTimeMillis();		// 밀리 세컨드(0.001초)로 현재 시간을 계산
				start.setVisible(false);						// 시작시 버튼을 표시
				view.setVisible(true);							// 단어 나타남
				input.setFocusable(true);						// 입력 가능하게 설정
				input.requestFocus();							// 포커스(커서)를 받아온다
			}
		});

		input.addKeyListener(new KeyListener() {				// 타자 입력 이벤트
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyReleased(KeyEvent e) {				// 키에서 손을 땔때 발생 이벤트
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyPressed(KeyEvent e) {											// 키 입력시 발생 이벤트
				// TODO here write to process event Action.
				
				//System.out.println(key);													// 현재 입력값 확인
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {									// 글자를 입력후 엔터를 누르면 이벤트 발생
					//System.out.println("이벤트 실행");
					startTime = System.currentTimeMillis();									// 엔터를 누르기 전까지의 시간을 측정
					
					speed_var.setText(pm.SpeedMensure(startTime,workingTime)+"타");			// 스피드 값이 들어감
					expect_per.setText(pm.ExpectMensure(input.getText())+"%");				// 정확도가 출력됨
					
					view.setText(pm.OutputWord());											// 새 단어를 불러온다
					input.setText("");														// 입력칸을 비운다
					input.requestFocus();													// 다시 포커스를 가져온다
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {								// esc를 눌러 낱말 연습을 중단하는 이벤트
					//System.out.println("포커스 누락됨");	
					input.setText("");														// 포커스를 없앤다
					input.setFocusable(false);												//
					JOptionPane.showMessageDialog(null, "낱말연습이 종료되었습니다");				// 낱말연습 종료 안내 문구 출력
					view.setVisible(false);													// 낱말연습이 중단되므로, 보기가 사라짐
					start.setVisible(true);													// 시작하기 버튼 다시 나타나는 메소드
				}
			}
		});
																							// 메인메뉴로 돌아가는 버튼 이벤트
		end.addActionListener(new MoveViewManger(frame, 0));
	}
																							/* 아래는 입력화면 사각형 생성 */
	public void paint(Graphics g) {
		super.paint(g);
		
		int tmp=70;
		g.drawRect(170, 70, 750, 450);		// 전체 사각형 틀
		g.drawRect(380, 220, 240, 140);		// 단어 틀
		g.drawRect(730, 70, 190, 450);		// 점수표 목록
		
		for(int i =0; i< 3; i++) {			// 점수 목록 테이블
			g.drawRect(730, tmp, 190, 100);
			tmp+=100;
		}
	}
}
