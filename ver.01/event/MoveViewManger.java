package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame.mainFrame;

public class MoveViewManger implements ActionListener{		// 현재의 프레임과 패널 번호를 받아 기능 전환

	private mainFrame frame;								// 프레임
	private int num;										// 패널 번호
	
	public MoveViewManger(mainFrame frame,int num) {		// 프레임과 패널번호는 생성자가 받음
		this.frame =frame;
		this.num = num;
	}
	@Override
	public void actionPerformed(ActionEvent e) {			// 패널번호를 받아 mainframe의 패널전환 기능 사용
		frame.drawPanel(num);
		
	}
	
}
